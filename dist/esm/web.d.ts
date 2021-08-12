import { WebPlugin } from '@capacitor/core';
import { NativeGaoDeMapPlugin } from './definitions';
export declare class NativeGaoDeMapWeb extends WebPlugin implements NativeGaoDeMapPlugin {
    constructor();
    initialize(_options: {
        key: string;
    }): Promise<any>;
    myLocation(_options: any): Promise<any>;
}
declare const NativeGaoDeMap: NativeGaoDeMapWeb;
export { NativeGaoDeMap };
