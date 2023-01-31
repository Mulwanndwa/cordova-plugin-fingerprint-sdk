package com.simpl;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//-------------------------------
import com.integratedbiometrics.ibscanultimate.IBScan;
import com.integratedbiometrics.ibscanultimate.IBScan.HashType;
import com.integratedbiometrics.ibscanultimate.IBScan.SdkVersion;
import com.integratedbiometrics.ibscanultimate.IBScanDevice;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.FingerCountState;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.FingerQualityState;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.ImageData;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.ImageType;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.LedState;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.PlatenState;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.RollingData;
import com.integratedbiometrics.ibscanultimate.IBScanDevice.SegmentPosition;
import com.integratedbiometrics.ibscanultimate.IBScanDeviceListener;
import com.integratedbiometrics.ibscanultimate.IBScanException;
import com.integratedbiometrics.ibscanultimate.IBScanListener;

import com.integratedbiometrics.ibscancommon.IBCommon.*;

import uk.co.senab.photoview.PhotoViewAttacher;

//-------------------------------

import com.simpl.android.fingerprint.SimplFingerprintListener;
import com.simpl.android.fingerprint.SimplFingerprint;
import android.content.Context;

public class SimplFingerprintWrapper extends CordovaPlugin {

    @Override
    public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("generateFingerprint")) {
            String phoneNumber = args.getString(1);
            String email = args.getString(2);
            this.generateFingerprint(phoneNumber, email, callbackContext);
            return true;
        }
        return false;
    }

    private void generateFingerprint(final String phoneNumber, final String email, final CallbackContext callbackContext) {
        Context context=this.cordova.getActivity().getApplicationContext();
        SimplFingerprint.init(context, phoneNumber, email);
        SimplFingerprint.getInstance().generateFingerprint(new SimplFingerprintListener() {
            @Override
            public void fingerprintData(String payload) {
                callbackContext.success(payload);
            }
        });
    }
}
