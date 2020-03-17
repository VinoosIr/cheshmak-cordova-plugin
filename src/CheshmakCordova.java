package me.cheshmak.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Log;
import me.cheshmak.android.sdk.core.Cheshmak;
import me.cheshmak.android.sdk.core.network.CheshmakIDResponseListener;

public class CheshmakCordova extends CordovaPlugin {
    private static final String TAG = "Cheshmak Cordova";
    public CordovaInterface cordova = null;

    @Override
    public void initialize(CordovaInterface initCordova, CordovaWebView webView) {
        cordova = initCordova;
        Log.e(TAG, "initialize");
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("initialize".equals(action)) {
        	initialize(args, callbackContext);
            return true;
        }
        if ("getCheshmakID".equals(action)) {
        	getCheshmakID(callbackContext);
            return true;
        }
        if ("addTag".equals(action)) {
            addTag(args, callbackContext);
            return true;
        }
        if ("deleteTag".equals(action)) {
            deleteTag(args, callbackContext);
            return true;
        }
        if ("deleteAllTags".equals(action)) {
            deleteAllTags(callbackContext);
            return true;
        }
        if ("startView".equals(action)) {
            startView(callbackContext);
            return true;
        }
        if ("stopView".equals(action)) {
            stopView(callbackContext);
            return true;
        }
        if ("getData".equals(action)) {
            getData(args, callbackContext);
            return true;
        }
        return false;
    }

    public void initialize(JSONArray args, final CallbackContext callbackContext) throws JSONException {
    	try {
    		String appKey = args.getString(0);
        	Cheshmak.with(cordova.getActivity().getApplicationContext());
            Cheshmak.initTracker(appKey);
            callbackContext.success();
        } catch (JSONException e) {
            callbackContext.error(e.getMessage());
        }
    	
    }

    public void getCheshmakID(final CallbackContext callbackContext) throws JSONException {
        Cheshmak.getCheshmakID(cordova.getActivity(), new CheshmakIDResponseListener(){

			@Override
			public void onCheshmakIdReceived(String cheshmakID) {
				callbackContext.success(cheshmakID);
			}

			@Override
			public void onError(Throwable throwable) {
				callbackContext.error(throwable.getMessage());
			}
		});
    }

    public void addTag(JSONArray args, final CallbackContext callbackContext) throws JSONException {
        try {
            String tagName = args.getString(0);
            Cheshmak.sendTag(tagName);
            callbackContext.success();
        } catch (JSONException e) {
        	Cheshmak.trackException(e);
            callbackContext.error(e.getMessage());
        }
    }

    public void deleteTag(JSONArray args, CallbackContext callbackContext) {
        try {
            String tagName = args.getString(0);
            Cheshmak.deleteTag(tagName);
            callbackContext.success();
        } catch (JSONException e) {
        	Cheshmak.trackException(e);
            callbackContext.error(e.getMessage());
        }
    }

    public void deleteAllTags(final CallbackContext callbackContext) {
        Cheshmak.deleteAllTags();
        callbackContext.success();
    }

    public void startView(final CallbackContext callbackContext) {
        Cheshmak.startView(cordova.getActivity().toString());
        callbackContext.success();
    }

    public void stopView(CallbackContext callbackContext) {
        Cheshmak.stopView(cordova.getActivity().toString());
        callbackContext.success();
    }

    public void getData(JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Intent intent = cordova.getActivity().getIntent();
        if (intent != null) {
            if (intent.getExtras() != null) {
                callbackContext.success(intent.getExtras().getString("me.cheshmak.data"));
            }
        } else {
            callbackContext.error(0);
        }
    }
}