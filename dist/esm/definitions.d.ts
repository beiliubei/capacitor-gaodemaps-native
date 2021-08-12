declare module "@capacitor/core" {
    interface PluginRegistry {
        NativeGaoDeMap: NativeGaoDeMapPlugin;
    }
}
export interface NativeGaoDeMapPlugin {
    /** [iOS only] Initializes GaoDeMaps with API key */
    initialize(options: {
        key: string;
    }): Promise<any>;
    /** Get user location */
    myLocation(options: any): Promise<any>;
}
