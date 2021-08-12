import { WebPlugin } from '@capacitor/core';
import { NativeGaoDeMapPlugin } from './definitions';


export class NativeGaoDeMapWeb extends WebPlugin implements NativeGaoDeMapPlugin {
  constructor() {
    super({
      name: 'NativeGaoDeMap',
      platforms: ['web'],
    });
  }

  initialize(_options: { key: string }): Promise<any> {
    throw new Error('Method not implemented.');
  }
  myLocation(_options: any): Promise<any> {
    throw new Error('Method not implemented.');
  }
}

const NativeGaoDeMap = new NativeGaoDeMapWeb();

export { NativeGaoDeMap };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NativeGaoDeMap);
