import { WebPlugin } from '@capacitor/core';

import type { CloudinaryPlugin } from './definitions';

export class CloudinaryWeb extends WebPlugin implements CloudinaryPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
