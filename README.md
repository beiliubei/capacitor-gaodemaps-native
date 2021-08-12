
## Purpose

Maps SDK for Android & iOS bring better performance and offline caching compared to JS SDK and they're free to use.

## Project Status

| Features  | Android | &nbsp; &nbsp; iOS &nbsp; &nbsp; | Current Status | Pending |
| ------------- | ------------- |  ------------- | ------------- | ------------- |
| Location  | <h5 align="center">WIP</h5>  | <h5 align="center">WIP</h5>  | <li>iOS: ``myLocation()``| API wrapping needs improvement so that it becomes consistent for both platforms |

## Getting Started

### Installation

#### Install package from npm
```
npm i --save @beiliubei/capacitor-gaodemaps-native
npx cap sync
```

### Set up Gaode API Keys

- [iOS](https://console.amap.com/dev/key/app)

```
#### iOS
- On iOS, this step is little different and mentioned below.

### Importing & Initializing the plugin

```javascript
import {Plugins} from "@capacitor/core";
const { NativeGaoDeMap } = Plugins

/* initialize() is important for iOS,
  Android doesn't need any initialization.
*/
await CapacitorGaodeMaps.initialize({
 key: "YOUR_IOS_API_KEY"
});
```

### Usage
```javascript
NativeGaoDeMap.myLocation().then((r: any) => {
                console.info("myLocation: " + r)
                
            }).catch((e: any) => {
                console.info("myLocation error: " + e)
            })

```
