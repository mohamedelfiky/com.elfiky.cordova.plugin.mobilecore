/**
 * Created by elfiky on 28/07/15.
 */

var mobileCore = function(dev_hash){
  var _module = {


    showInterstitial: function (successCallback, errorCallback) {
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

    showStickee: function (successCallback, errorCallback) {
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

    showDirectToMarket: function (successCallback, errorCallback) {
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


  return _module;
};

module.exports = mobileCore;
