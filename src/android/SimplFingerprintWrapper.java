package com.simpl.android.fingerprint;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//-------------------------------

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
//import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

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

import android.content.Context;




public class SimplFingerprintWrapper extends CordovaPlugin {
    

    int deviceIndex = 0;
    @Override
    public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("generateFingerprint")) {
            String phoneNumber = args.getString(1);
            String email = args.getString(2);
            //this.generateFingerprint(phoneNumber, email, callbackContext);
            return true;
        } 
        if (action.equals("openScanner")) {
            
            //this.m_ibScan = IBScan.getInstance(this.getApplicationContext());

            try
            {
            IBScanDevice myDevice = this.m_ibScan.open(deviceIndex);
            }
            catch (IBScanException ibse)
            {
            System.out.println("Failed to open with exception " +ibse.getCode().toString());
            }
            return true;
        }
        return false;
    }

   
   
}

