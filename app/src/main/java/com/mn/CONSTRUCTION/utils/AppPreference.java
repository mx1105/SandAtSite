package com.mn.CONSTRUCTION.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreference {
    private static final String PREFERENCE_NAME = "SandAtSite";
    private int PRIVATE_MODE = 0;

    private static AppPreference sInstance;

    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;

    public AppPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        mEditor = mSharedPreferences.edit();
    }

    public static synchronized AppPreference getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AppPreference(context);
        }
        return sInstance;
    }

    public String getuserData(String key) {
        return mSharedPreferences.getString(key, "");
    }

    public void setuserData(String Key,String value) {
        this.mEditor.putString(Key, value).commit();
    }

    public Boolean getBooleanData(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }

    public void setBooleanData(String Key,Boolean value) {
        this.mEditor.putBoolean(Key, value).commit();
    }

    public int getIntegerData(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public void setIntegerData(String Key,int value) {
        this.mEditor.putInt(Key, value).commit();
    }


    public void ClearSharedpreference() {
        this.mEditor.clear();
        this.mEditor.commit();
    }
}
