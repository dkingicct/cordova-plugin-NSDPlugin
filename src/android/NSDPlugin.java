package io.ionic.nsd;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//
// import android.content.Context;
// import android.net.nsd.NsdServiceInfo;
// import android.net.nsd.NsdManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class NSDPlugin extends CordovaPlugin {
    //
    // Context mContext;
    // NsdServiceInfo mService;
    // String mServiceName;
    // String mServiceType;
    //
    // NsdManager mNsdManager;
    // NsdManager.ResolveListener mResolveListener;
    // NsdManager.DiscoveryListener mDiscoveryListener;
    // NsdManager.RegistrationListener mRegistrationListener;

    // @Override
    // public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    //     super.initialize(cordova, webView);
    //     // your init code here
    // }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         if(action.equals("initializeNsd")) {
            Log.d("hi!!!!","hi!!!!");
             callbackContext.success();
            // String serviceName = args.getString(0);
            // String ServiceType = args.getString(1);
            // this.initializeNsd(serviceName, ServiceType, callbackContext);
            return true;
        }
        // else if(action.equals("registerService")) {
        //     int port = args.getInt(0);
        //     this.registerService(port, callbackContext);
        //     return true;
        // } else if(action.equals("discoverServices")) {
        //     this.discoverServices(callbackContext);
        //     return true;
        // } else if(action.equals("getChosenServiceInfo")) {
        //     this.getChosenServiceInfo(callbackContext);
        //     return true;
        // } else if(action.equals("stopDiscovery")) {
        //     this.stopDiscovery(callbackContext);
        //     return true;
        // } else if(action.equals("tearDown")) {
        //     this.tearDown(callbackContext);
        //     return true;
        // }


        return false;
    }
    //
    // //interface methods
    // private void registerService(int port, CallbackContext callbackContext) {
    //     NsdServiceInfo serviceInfo = new NsdServiceInfo();
    //     serviceInfo.setPort(port);
    //     serviceInfo.setServiceName(mServiceName);
    //     serviceInfo.setServiceType(mServiceType);
    //
    //     mNsdManager.registerService(
    //         serviceInfo, NsdManager.PROTOCOL_DNS_SD, mRegistrationListener);
    //
    //     callbackContext.success();
    // }
    //
    // private void discoverServices(CallbackContext callbackContext) {
    //     mNsdManager.discoverServices(
    //     mServiceType, NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
    //     callbackContext.success();
    // }
    //
    // private void stopDiscovery(CallbackContext callbackContext) {
    //     mNsdManager.stopServiceDiscovery(mDiscoveryListener);
    //     callbackContext.success();
    // }
    //
    // private void getChosenServiceInfo(CallbackContext callbackContext) {
    //
    //     JSONObject tempJson = new JSONObject();
    //     try {
    //         tempJson.put("port", mService.getPort());
    //     } catch (JSONException e) {
    //
    //     }
    //
    //     try {
    //         tempJson.put("host", mService.getHost());
    //     } catch (JSONException e) {
    //
    //     }
    //
    //
    //     callbackContext.success(tempJson);
    // }
    //
    // private void tearDown(CallbackContext callbackContext) {
    //     callbackContext.success();
    // }
    //
    // private void initializeNsd(String serviceName, String serviceType, CallbackContext callbackContext) {
    //     if(serviceName != null && serviceType != null) {
    //         //set context some how here;
    //         mServiceName = serviceName;
    //         mServiceType = serviceType;
    //         initializeResolveListener();
    //         initializeDiscoveryListener();
    //         initializeRegistrationListener();
    //         callbackContext.success();
    //     } else {
    //         callbackContext.error("invalid service name or service type");
    //     }
    // }
    //
    // //none interface methods
    // private void initializeResolveListener() {
    //     mResolveListener = new NsdManager.ResolveListener() {
    //
    //         @Override
    //         public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
    //
    //         }
    //
    //         @Override
    //         public void onServiceResolved(NsdServiceInfo serviceInfo) {
    //
    //
    //             if (serviceInfo.getServiceName().equals(mServiceName)) {
    //
    //                 return;
    //             }
    //             mService = serviceInfo;
    //         }
    //     };
    // }
    //
    // private void initializeDiscoveryListener() {
    //     mDiscoveryListener = new NsdManager.DiscoveryListener() {
    //
    //         @Override
    //         public void onDiscoveryStarted(String regType) {
    //
    //         }
    //
    //         @Override
    //         public void onServiceFound(NsdServiceInfo service) {
    //
    //             if (!service.getServiceType().equals(mServiceType)) {
    //
    //             } else if (service.getServiceName().equals(mServiceName)) {
    //
    //             } else if (service.getServiceName().contains(mServiceName)){
    //                 mNsdManager.resolveService(service, mResolveListener);
    //             }
    //         }
    //
    //         @Override
    //         public void onServiceLost(NsdServiceInfo service) {
    //
    //             if (mService == service) {
    //                 mService = null;
    //             }
    //         }
    //
    //         @Override
    //         public void onDiscoveryStopped(String serviceType) {
    //
    //         }
    //
    //         @Override
    //         public void onStartDiscoveryFailed(String serviceType, int errorCode) {
    //
    //             mNsdManager.stopServiceDiscovery(this);
    //         }
    //
    //         @Override
    //         public void onStopDiscoveryFailed(String serviceType, int errorCode) {
    //
    //             mNsdManager.stopServiceDiscovery(this);
    //         }
    //     };
    // }
    //
    // private void initializeRegistrationListener() {
    //     mRegistrationListener = new NsdManager.RegistrationListener() {
    //
    //         @Override
    //         public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
    //             mServiceName = NsdServiceInfo.getServiceName();
    //         }
    //
    //         @Override
    //         public void onRegistrationFailed(NsdServiceInfo arg0, int arg1) {
    //         }
    //
    //         @Override
    //         public void onServiceUnregistered(NsdServiceInfo arg0) {
    //         }
    //
    //         @Override
    //         public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
    //         }
    //
    //     };
    // }
}
