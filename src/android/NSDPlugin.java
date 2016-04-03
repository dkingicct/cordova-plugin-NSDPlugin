package cordova-plugin-nsd-plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.nsd.NsdServiceInfo;
import android.net.nsd.NsdManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class NSDPlugin extends CordovaPlugin {

    Context mContext;
    String mServiceName;
    String mServiceType;

    NsdManager mNsdManager;
    NsdManager.ResolveListener mResolveListener;
    NsdManager.DiscoveryListener mDiscoveryListener;
    NsdManager.RegistrationListener mRegistrationListener;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
         if(action.equals('initalizeNsd')) {
             String context = args.getString(0);
            String serviceName = args.getString(1);
            String ServiceType = args.getString(2);
            this.initalizeNsd(context, serviceName, ServiceType, callbackContext);
            return true;
        } else if(action.equals('registerService')) {
            Int port = args.getInt(0);
            this.registerService(int port, callbackContext);
            return true;
        } else if(action.equals('discoverServices')) {
            this.discoverServices(callbackContext);
            return true;
        } else if(action.equals('getChosenServiceInfo')) {
            this.getChosenServiceInfo(callbackContext);
            return true;
        } else if(action.equals('stopDiscovery')) {
            this.stopDiscovery(callbackContext);
            return true;
        } else if(action.equals('tearDown')) {
            this.tearDown(callbackContext);
            return true;
        }
        return false;
    }

    //interface methods
    private void registerService(int port, CallbackContext callbackContext) {
        if( port != null ) {
            NsdServiceInfo serviceInfo = new NsdServiceInfo();
            serviceInfo.setPort(port);
            serviceInfo.setServiceName(mServiceName);
            serviceInfo.setServiceType(mServiceType);

            mNsdManager.registerService(
                serviceInfo, NsdManager.PROTOCOL_DNS_SD, mRegistrationListener);

            callbackContext.success();
        } else {
            callbackContext.failed();
        }
    }

    private void discoverServices(CallbackContext callbackContext) {
        mNsdManager.discoverServices(
        mServiceType, NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
        callbackContext.success();
    }

    private void stopDiscovery(CallbackContext callbackContext) {
        mNsdManager.stopServiceDiscovery(mDiscoveryListener);
        callbackContext.success();
    }

    private void getChosenServiceInfo(CallbackContext callbackContext) {
        callbackContext.success(mService.getPort(), mService.getHost());
    }

    private void tearDown(CallbackContext callbackContext) {
        callbackContext.success();
    }

    private void initalizeNsd(String context, String serviceName, String serviceType, CallbackContext callbackContext) {
        if(context != null && serviceName != null && serviceType != null) {
            mContext = context;
            mServiceName = serviceName;
            mServiceType = serviceType;
            initalizeResolveListener();
            initializeDiscoveryListener();
            initializeRegistrationListener();
            callbackContext.success();
        } else {
            callbackContext.failed();
        }
    }

    //none interface methods
    private void initializeResolveListener() {
        mResolveListener = new NsdManager.ResolveListener() {

            @Override
            public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                Log.e(TAG, "Resolve failed" + errorCode);
            }

            @Override
            public void onServiceResolved(NsdServiceInfo serviceInfo) {
                Log.e(TAG, "Resolve Succeeded. " + serviceInfo);

                if (serviceInfo.getServiceName().equals(mServiceName)) {
                    Log.d(TAG, "Same IP.");
                    return;
                }
                mService = serviceInfo;
            }
        };
    }

    private void initializeDiscoveryListener() {
        mDiscoveryListener = new NsdManager.DiscoveryListener() {

            @Override
            public void onDiscoveryStarted(String regType) {
                Log.d(TAG, "Service discovery started");
            }

            @Override
            public void onServiceFound(NsdServiceInfo service) {
                Log.d(TAG, "Service discovery success" + service);
                if (!service.getServiceType().equals(SERVICE_TYPE)) {
                    Log.d(TAG, "Unknown Service Type: " + service.getServiceType());
                } else if (service.getServiceName().equals(mServiceName)) {
                    Log.d(TAG, "Same machine: " + mServiceName);
                } else if (service.getServiceName().contains(mServiceName)){
                    mNsdManager.resolveService(service, mResolveListener);
                }
            }

            @Override
            public void onServiceLost(NsdServiceInfo service) {
                Log.e(TAG, "service lost" + service);
                if (mService == service) {
                    mService = null;
                }
            }

            @Override
            public void onDiscoveryStopped(String serviceType) {
                Log.i(TAG, "Discovery stopped: " + serviceType);
            }

            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                Log.e(TAG, "Discovery failed: Error code:" + errorCode);
                mNsdManager.stopServiceDiscovery(this);
            }

            @Override
            public void onStopDiscoveryFailed(String serviceType, int errorCode) {
                Log.e(TAG, "Discovery failed: Error code:" + errorCode);
                mNsdManager.stopServiceDiscovery(this);
            }
        };
    }

    private void initializeRegistrationListener() {
        mRegistrationListener = new NsdManager.RegistrationListener() {

            @Override
            public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
                mServiceName = NsdServiceInfo.getServiceName();
            }

            @Override
            public void onRegistrationFailed(NsdServiceInfo arg0, int arg1) {
            }

            @Override
            public void onServiceUnregistered(NsdServiceInfo arg0) {
            }

            @Override
            public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
            }

        };
    }
}
