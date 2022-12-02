import { WebPlugin } from '@capacitor/core';

import type {
  CloudinaryPlugin,
  InitializeOptions,
  UploadResourceOptions,
  UploadResourceResult,
} from './definitions';

export class CloudinaryWeb extends WebPlugin implements CloudinaryPlugin {
  public static readonly ERROR_NOT_INITIALIZED = 'Plugin is not initialized.';
  public static readonly ERROR_FILE_MISSING = 'blob must be provided.';

  private cloudName?: string;

  public async initialize(options: InitializeOptions): Promise<void> {
    this.cloudName = options.cloudName;
  }

  public async uploadResource(
    options: UploadResourceOptions,
  ): Promise<UploadResourceResult> {
    if (!options.blob) {
      throw new Error(CloudinaryWeb.ERROR_FILE_MISSING);
    }
    const uniqueUploadId = this.generateUniqueId();
    const chunkSize = 1024 * 1024 * 10; // 10 Megabytes
    const totalSize = options.blob.size;
    const chunks: { start: number; end: number; blob: Blob }[] = [];

    let start = 0;
    let end = Math.min(chunkSize, totalSize);
    while (start < totalSize) {
      const blob = options.blob.slice(start, end);
      chunks.push({ start, end, blob });
      start = end;
      end = Math.min(start + chunkSize, totalSize);
    }
    let response: any;
    for (const chunk of chunks) {
      const { start, end, blob } = chunk;
      response = await this.uploadResourceChunk(
        options,
        uniqueUploadId,
        start,
        end - 1,
        totalSize,
        blob,
      );
    }
    return {
      assetId: response.asset_id,
      bytes: response.bytes,
      createdAt: response.created_at,
      format: response.format,
      originalFilename: response.original_filename,
      resourceType: response.resource_type,
      publicId: response.public_id,
      url: response.secure_url,
    };
  }

  public async uploadResourceChunk(
    options: UploadResourceOptions,
    uniqueUploadId: string,
    start: number,
    end: number,
    size: number,
    chunk: Blob,
  ): Promise<void> {
    if (!this.cloudName) {
      throw new Error(CloudinaryWeb.ERROR_NOT_INITIALIZED);
    }
    const formData = new FormData();
    formData.append('file', chunk);
    formData.append('upload_preset', options.uploadPreset);
    formData.append('cloud_name', this.cloudName);
    if (options.publicId) {
      formData.append('public_id', options.publicId);
    }
    await fetch(
      `https://api.cloudinary.com/v1_1/${this.cloudName}/${options.resourceType}/upload`,
      {
        method: 'PUT',
        body: formData,
        headers: {
          'X-Unique-Upload-Id': uniqueUploadId,
          'Content-Range': `bytes ${start}-${end}/${size}`,
        },
      },
    ).then(async response => {
      console.log('chunk', { body: await response.json() });
      if (!response.ok) {
        throw new Error(
          `Request failed with status ${response.status}: ${response.statusText}`,
        );
      }
    });
  }

  private generateUniqueId(): string {
    return Date.now().toString(36) + Math.random().toString(36).substring(2);
  }
}
