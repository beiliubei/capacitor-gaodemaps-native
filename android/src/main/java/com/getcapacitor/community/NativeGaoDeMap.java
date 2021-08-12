package com.getcapacitor.community;

import android.Manifest;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin(
    permissions = {
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    }
)
public class NativeGaoDeMap extends Plugin {

    public static final String TAG = "NativeGaoDeMap";

    @PluginMethod()
    public void initialize(final PluginCall call) {

    }

    @PluginMethod()
    public void myLocation(final PluginCall call) {

    }
}
