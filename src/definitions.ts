export interface CloudinaryPlugin {
  /**
   * Initialize the plugin.
   *
   * This method must be called once before all other methods.
   *
   * @since 0.0.1
   */
  initialize(options: InitializeOptions): Promise<void>;
  uploadResource(options: UploadResourceOptions): Promise<void>;
}

/**
 * @since 0.0.1
 */
export interface InitializeOptions {
  /**
   * The cloud name of your app which you can find in the Cloudinary Management Console.
   *
   * @since 0.0.1
   */
  cloudName: string;
}

export interface UploadResourceOptions {
  /**
   * The resource type to upload.
   *
   * @since 0.0.1
   */
  resourceType: ResourceType;
  /**
   * The file to upload.
   *
   * Only available on Web.
   *
   * @since 0.0.1
   */
  file?: File;
  /**
   * The selected upload preset.
   *
   * @since 0.0.1
   * @see https://cloudinary.com/documentation/upload_presets
   */
  uploadPreset: string;
  /**
   * The path of the file to upload.
   *
   * Only available on Android and iOS.
   *
   * @since 0.0.1
   */
  path?: string;
  /**
   * Assign a unique identifier to the resource.
   *
   * @since 0.0.1
   * @see https://cloudinary.com/documentation/upload_images#public_id
   */
  publicId: string;
}

export enum ResourceType {
  image = 'image',
  video = 'video',
  raw = 'raw',
}
