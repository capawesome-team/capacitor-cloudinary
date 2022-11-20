export interface CloudinaryPlugin {
  initialize(options: { cloudName: string }): Promise<void>;
  uploadRessource(options: UploadRessourceOptions): Promise<void>;
}

export interface UploadRessourceOptions {
  resourceType: ResourceType;
  file: File;
  uploadPreset: string;
  /**
   * Only available for Web.
   */
  signature?: string;
  publicId?: string;
}

export enum ResourceType {
  image = 'image',
  video = 'video',
  raw = 'raw',
}
