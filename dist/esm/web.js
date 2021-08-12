import { WebPlugin } from '@capacitor/core';
export class NativeGaoDeMapWeb extends WebPlugin {
    constructor() {
        super({
            name: 'NativeGaoDeMap',
            platforms: ['web'],
        });
    }
    initialize(_options) {
        throw new Error('Method not implemented.');
    }
    myLocation(_options) {
        throw new Error('Method not implemented.');
    }
}
const NativeGaoDeMap = new NativeGaoDeMapWeb();
export { NativeGaoDeMap };
import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NativeGaoDeMap);
//# sourceMappingURL=web.js.map