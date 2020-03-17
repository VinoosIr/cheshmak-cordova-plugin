# Cordova Cheshmak plugin

for Android, by [Milad Mohammadi Rezagah](http://www.miladesign.ir)

This is a plugin for Cheshmak android library for Cordova and other Cordova-base users (like Ionic and PhoneGap) which enables them to integrate Cheshmak into their applications.

## 0. Index

1. [How to use](#1-how-to-use)
2. [Other functions](#2-other-functions)
3. [Designer](#3-designer)

## 1. How to use

if you are using cordova:

``cordova plugin add <path-to-this-plugin-on-your-computer>``

For example, if you download it to *D:/development/cheshmak-cordova* and *cheshmak-cordova* contains the plugin files, add plugin command become:

``cordova plugin add D:/development/cheshmak-cordova-plugin``

- Login to your panel on cheshmak.me and create a new application.

- Add below lines to your app's *index.html* file. Please note that this is an example.

```js
    <script type="text/javascript">
        document.addEventListener("deviceready", deviceReady, true);
        function deviceReady() {
			window.cheshmak.initialize('ADD_YOUR_APP_KEY_HERE');
            window.cheshmak.getData(success);
        }
		function success(data) {
			if  (!!data) {
				console.log('Received Data: ' + data);
			}
		}
    </script>
```
- replace "ADD_YOUR_APP_KEY_HERE" with the app key of your app.
- Then build and run your app. You should see Cheshmak initialization logs in android log-cat (if your device is connected to your computer with usb cable) and one new installation will appear in your panel on cheshmak.me in a few seconds. You can now send push notifications to your app.

## 2. Other functions

### Get Cheshmak Id:

``window.cheshmak.getCheshmakID(function(cheshmakID){}, function(error){});``

### Add Tag:

``window.cheshmak.addTag("TagName");``

### Delete Tag:

``window.cheshmak.deleteTag("TagName");``

### Delete All Tags:

``window.cheshmak.deleteAllTags();``

### Start View:

``window.cheshmak.startView();``

### Stop View:

``window.cheshmak.stopView();``

### Track Event:

``window.cheshmak.trackEvent("EventName");``

## 3. Designer

- Milad Mohammadi Rezagah
- www.miladesign.ir
- Rezagah.Milad@Gmail.com