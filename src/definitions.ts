export interface CloudinaryPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
