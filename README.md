# com.elfiky.cordova.plugin.mobilecore
Cordova plugin to use mobilecore sdk 

You can manage some types of Ads .

  - Interstitial Ad
  - Stickee Ad
  - Direct To Market Ad


### Version
1.0

### Installation

```sh
$ cordova plugin add https://github.com/mohamedelfiky/com.elfiky.cordova.plugin.mobilecore.git
```

### Examples

show Interstitial Ads
```js
mobileCore('82VXL1FJZV6C1AKK2KSZQMW7NFPS4').showInterstitial(success, failure);
```


show Stickee Ads
```js
mobileCore('82VXL1FJZV6C1AKK2KSZQMW7NFPS4').showStickee(success, failure);
```


show Direct To Market Ads
```js
mobileCore('82VXL1FJZV6C1AKK2KSZQMW7NFPS4').showDirectToMarket(success, failure);
```
