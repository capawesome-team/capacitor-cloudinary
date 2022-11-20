import { WebPlugin } from '@capacitor/core';

import type { CloudinaryPlugin, UploadRessourceOptions } from './definitions';

export class CloudinaryWeb extends WebPlugin implements CloudinaryPlugin {
  private cloudName?: string;

  public async initialize(options: { cloudName: string }): Promise<void> {
    this.cloudName = options.cloudName;
  }

  public async uploadRessource(options: UploadRessourceOptions): Promise<void> {
    const formData = new FormData();
    formData.append('file', options.file);
    const uniqueUploadId = this.generateUniqueId();
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
    );
  }

  private generateUniqueId(): string {
    return Date.now().toString(36) + Math.random().toString(36).substring(2);
  }
}
