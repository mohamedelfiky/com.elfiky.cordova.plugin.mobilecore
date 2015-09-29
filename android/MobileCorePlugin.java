package com.elfiky.cordova.plugin.mobilecore;

import org.apache.cordova.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.ironsource.mobilcore.MobileCore;
import com.ironsource.mobilcore.OnReadyListener;
import com.ironsource.mobilcore.MobileCore.AD_UNITS;
import com.ironsource.mobilcore.MobileCore.LOG_TYPE;

import android.util.Log;

public class MobileCorePlugin extends CordovaPlugin {

	public static final String ACTION_SHOW_INTERSTITIAL_AD = "show_interstitial";
	public static final String ACTION_SHOW_STICKEE_AD = "show_stickee";
	public static final String ACTION_DIRECT_TO_MARKET = "show_direct_to_market";

	private final String TAG = "mobilecore_log";

	private static final String DEFAULT_DEV_HASH = "82VXL1FJZV6C1AKK2KSZQMW7NFPS4";

	/* options */
	private static final String OPT_DEV_HASH = "dev_hash";

	private String dev_hash = DEFAULT_DEV_HASH;

	@Override
	public boolean execute(final String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {

		if (ACTION_SHOW_INTERSTITIAL_AD.equals(action)) {
			JSONObject options = data.optJSONObject(0);
			executeCreateInterstitialView(options, callbackContext);
		}else if(ACTION_SHOW_STICKEE_AD.equals(action)){
			JSONObject options = data.optJSONObject(0);
			executeCreateStickeeView(options, callbackContext);
		}else if (ACTION_DIRECT_TO_MARKET.equals(action)) {
			JSONObject options = data.optJSONObject(0);
			executeDirectToMarketView(options, callbackContext);
			
			return true;
		}

		return true;

	}

	private PluginResult executeCreateInterstitialView(JSONObject options,
			final CallbackContext callbackContext) {
		this.setOptions(options);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					MobileCore.init(cordova.getActivity(), dev_hash, null,
							LOG_TYPE.DEBUG, AD_UNITS.STICKEEZ,
							AD_UNITS.INTERSTITIAL, AD_UNITS.DIRECT_TO_MARKET,
							AD_UNITS.NATIVE_ADS);
					MobileCore.showInterstitial(cordova.getActivity(), MobilecorePlugin.this);

					Log.v(TAG, "Show mobilecore ad Interstitial");
				} catch (Exception ex) {
					Log.e(TAG, "error error error error ");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}

	
	private PluginResult executeCreateStickeeView(JSONObject options,
			final CallbackContext callbackContext) {
		this.setOptions(options);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					MobileCore.init(cordova.getActivity(), dev_hash, null,
							LOG_TYPE.DEBUG, AD_UNITS.STICKEEZ,
							AD_UNITS.INTERSTITIAL, AD_UNITS.DIRECT_TO_MARKET,
							AD_UNITS.NATIVE_ADS);
					MobileCore.showStickee(cordova.getActivity());

					Log.v(TAG, "Show mobilecore Stickee ad ");
				} catch (Exception ex) {
					Log.e(TAG, "error error error error ");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}

	private PluginResult executeDirectToMarketView(JSONObject options,
			final CallbackContext callbackContext) {
		this.setOptions(options);
		cordova.getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					MobileCore.init(cordova.getActivity(), dev_hash, null,
							LOG_TYPE.DEBUG, AD_UNITS.STICKEEZ,
							AD_UNITS.INTERSTITIAL, AD_UNITS.DIRECT_TO_MARKET,
							AD_UNITS.NATIVE_ADS);

					MobileCore.setDirectToMarketReadyListener(new OnReadyListener() {
						@Override
						public void onReady(AD_UNITS arg0) {
							MobileCore.directToMarket(cordova.getActivity());

							Log.v(TAG, "Show mobilecore direct To Market ad ");
						}
					});
					
				} catch (Exception ex) {
					Log.e(TAG, "error error error error ");
					Log.e(TAG, ex.getMessage());
				}

				callbackContext.success();
			}
		});

		return null;
	}
	
	private void setOptions(JSONObject options) {
		if (options == null)
			return;

		if (options.has(OPT_DEV_HASH))
			this.dev_hash = options.optString(OPT_DEV_HASH);
	}

}