package com.getcapacitor.community;

import android.Manifest;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import java.util.List;

@NativePlugin(
        permissions = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        }
)
public class NativeGaoDeMap extends Plugin {
    public AMapLocationClient mLocationClient = null;

    public static final String TAG = "NativeGaoDeMap";

    @PluginMethod()
    public void initialize(final PluginCall call) {
        AndPermission.with(getContext())
                .runtime()
                .permission(Permission.ACCESS_FINE_LOCATION)
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        call.resolve();
                        mLocationClient = new AMapLocationClient(getContext());
                        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
                        mLocationOption.setOnceLocation(true);
                        mLocationOption.setOnceLocationLatest(true);
                        mLocationOption.setNeedAddress(true);
                        //给定位客户端对象设置定位参数
                        mLocationClient.setLocationOption(mLocationOption);
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        call.error("定位失败，请打开定位权限");
                    }
                })
                .start();
    }

    @PluginMethod()
    public void myLocation(final PluginCall call) {
        if (mLocationClient == null){
            call.error("请先初始化定位模块");
            return;
        }
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                mLocationClient.stopLocation();
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                        JSObject jsonObject = new JSObject();
                        jsonObject.put("latitude", aMapLocation.getLatitude());
                        jsonObject.put("longitude", aMapLocation.getLongitude());
                        jsonObject.put("address", aMapLocation.getAddress());
                        call.resolve(jsonObject);
                    } else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        call.error("location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }else {
                    call.error("定位失败");
                }
            }
        };
        mLocationClient.setLocationListener(mLocationListener);
        //启动定位
        mLocationClient.startLocation();
    }
}
