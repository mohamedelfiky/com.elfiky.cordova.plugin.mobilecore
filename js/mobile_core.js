/**
 * Created by elfiky on 28/07/15.
 */

var mobileCore = {
  showInterstitial: function (successCallback, errorCallback) {
    cordova.exec(
      successCallback, // success callback function
      errorCallback, // error callback function
      'com.elfiky.cordova.plugin.mobilecore.MobileCorePlugin', // mapped to our native Java class called "MobileCorePlugin"
      'show_interstitial', // with this action name
      []
    );
  }
};

module.exports = mobileCore;
