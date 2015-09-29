/**
 * Created by elfiky on 28/07/15.
 */

  var mobileCore = {

    init: function (dev_hash, successCallback, errorCallback) {
      cordova.exec(
        successCallback, // success callback function
        errorCallback, // error callback function
        'MobileCorePlugin', // mapped to our native Java class called "MobileCorePlugin"
        'init_mobile_core', // with this action name
        [{
          dev_hash: dev_hash
        }]
      );
    },

    showInterstitial: function (dev_hash, successCallback, errorCallback) {
      cordova.exec(
        successCallback, // success callback function
        errorCallback, // error callback function
        'MobileCorePlugin', // mapped to our native Java class called "MobileCorePlugin"
        'show_interstitial', // with this action name
        [{
          dev_hash: dev_hash
        }]
      );
    },

    showStickee: function (dev_hash,successCallback, errorCallback) {
      cordova.exec(
        successCallback, // success callback function
        errorCallback, // error callback function
        'MobileCorePlugin', // mapped to our native Java class called "MobileCorePlugin"
        'show_stickee', // with this action name
        [{
          dev_hash: dev_hash
        }]
      );
    },

    showDirectToMarket: function (dev_hash,successCallback, errorCallback) {
      cordova.exec(
        successCallback, // success callback function
        errorCallback, // error callback function
        'MobileCorePlugin', // mapped to our native Java class called "MobileCorePlugin"
        'show_direct_to_market', // with this action name
        [{
          dev_hash: dev_hash
        }]
      );
    }


  };

module.exports = mobileCore;
