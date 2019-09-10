package com.tourist.police.apps;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.tourist.police.R;

public class Apps extends Application {

    private static Apps mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized Apps getAppsContext() {
        return mInstance;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static void redirect(Context context, final Class<? extends Activity> activityToOpen) {
        Intent intent = new Intent(context, activityToOpen);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        ((Activity) context).startActivity(intent);
        ((Activity) context).overridePendingTransition(0, 0);
        ((Activity) context).finish();
    }

    public static void startWaitingDialog(ProgressDialog pDialog, String msg, boolean cancelable) {
        pDialog.setMessage(msg);
        pDialog.setCancelable(cancelable);
        pDialog.show();
    }

    public static void stopWaitingDialog(ProgressDialog pDialog) {
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    public static boolean isNetworkAvailable() {
        Context context = getAppsContext().getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isLocationEnabled() {
        Context context = getAppsContext().getApplicationContext();
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static void snackBarMsg(View view, String msg, int length, boolean action) {
        final Snackbar snackbar = Snackbar.make(view, msg, length);
        if (action) {
            snackbar.setActionTextColor(Color.WHITE);
            snackbar.setAction(getAppsContext().getString(R.string.snack_bar), new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
        }
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(getAppsContext().getResources().getColor(R.color.colorPrimaryDark));
        TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }
}