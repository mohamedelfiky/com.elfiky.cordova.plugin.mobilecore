package com.elfiky.cordova.plugin.mobilecore;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;

public class MobileCorePlugin extends CordovaPlugin {

    public static final String ACTION_SHOW_INTERSTITIAL_ADD= "show_interstitial";


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (ACTION_SHOW_INTERSTITIAL_ADD.equals(action)) {
            Log.v("MobileCore test","test")
            return true;
        }
        else {
            return false;
        }

    }
}