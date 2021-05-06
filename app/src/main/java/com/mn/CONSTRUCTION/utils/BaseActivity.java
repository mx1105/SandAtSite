package com.mn.CONSTRUCTION.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    static Context context;
    private static BaseActivity sInstance;
    public CustomProgressDialog progressDialog;

    public static synchronized BaseActivity getInstance() {
        if (sInstance == null) {
            sInstance = new BaseActivity();
        }
        return sInstance;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
    public static void displayShortToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public static void displayLongToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }


    public void showProgress(Context context) {
        if (progressDialog != null) {
            progressDialog.dissmissDialog();
        }
        progressDialog = new CustomProgressDialog();
        if (!isDestroyed()) {
            progressDialog.showCustomDialog(context);
        }

    }

    public void dismissProgress() {
        if (progressDialog != null) {
            progressDialog.dissmissDialog();
        }

    }

}

