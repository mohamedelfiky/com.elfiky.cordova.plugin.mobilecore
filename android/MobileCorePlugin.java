package com.elfiky.cordova.plugin.mobilecore;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.ironsource.mobilcore.MobileCore;
import com.ironsource.mobilcore.MobileCore.AD_UNITS;
import com.ironsource.mobilcore.MobileCore.AD_UNIT_SHOW_TRIGGER;
import com.ironsource.mobilcore.MobileCore.LOG_TYPE;
import com.ironsource.mobilcore.UserProperties;
import com.ironsource.mobilcore.UserProperties.AgeRange;
import com.ironsource.mobilcore.UserProperties.Gender;

import android.util.Log;

public class MobileCorePlugin extends CordovaPlugin {

	public static final String ACTION_SHOW_INTERSTITIAL_ADD = "show_interstitial";

	private final String DEV_HASH = "161LSETH6VFWNHL9PL5YCME1GM17C";
	private final String SAMPLE_URL = "www.mobilecore.com";

	@Override
	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {

		if (ACTION_SHOW_INTERSTITIAL_ADD.equals(action)) {
			Log.v("MobileCore test", "test");
			/*************************/

			UserProperties user = new UserProperties().setGender(Gender.FEMALE)
					.setAgeRange(AgeRange._18_24);
			MobileCore.init(cordova.getActivity(), DEV_HASH, user,
					LOG_TYPE.DEBUG, AD_UNITS.STICKEEZ, AD_UNITS.INTERSTITIAL,
					AD_UNITS.DIRECT_TO_MARKET, AD_UNITS.NATIVE_ADS);

			// If you will be using banners in your Ads listview call the
			// following method after init
			MobileCore.setNativeAdsBannerSupport(true);

			// This button will call showInterstitial with forceShow = true (on
			// screen response to no connection situations)
			// Notice how it's possible to set a null value instead of a
			// CallbackResponse if you don't want to react to user.
			showInterstitial();

			/*************************/
			callbackContext.success("sucess");
			return true;
		} else {
			return false;
		}

	}

	private void showInterstitial() {
		MobileCore.showInterstitial(cordova.getActivity(),
				AD_UNIT_SHOW_TRIGGER.BUTTON_CLICK, null);
	}
}