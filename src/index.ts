import { registerPlugin } from "@capacitor/core";
import { CapacitorGaodeMapsPlugin } from "./definitions";

const CapacitorGaodeMaps = registerPlugin<CapacitorGaodeMapsPlugin>(
    "CapacitorGoogleMaps",
    {
        web: () => import("./web").then((m) => new m.CapacitorGaodeMapsWeb()),
    }
);

export * from "./definitions";
export { CapacitorGaodeMaps };
