package com.artcak.artcakbase.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SessionSharedPrefHelper {
    private static final String SESSSION_PREFS = "SESSSION_PREFS";
    private static final String KEY_DATASESSION = "KEY_DATASESSION";
    private static final String KEY_IS_LOGGEDIN = "KEY_IS_LOGGEDIN";

    private SharedPreferences mSharedPreferences;

    public SessionSharedPrefHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(SESSSION_PREFS, MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public boolean getIsLoggedin() {
        return mSharedPreferences.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    public void setIsLoggedin(boolean loggedIn) {
        mSharedPreferences.edit().putBoolean(KEY_IS_LOGGEDIN, loggedIn).apply();
    }

    public void setDataSession(String dataSession){
        mSharedPreferences.edit().putString(KEY_DATASESSION, dataSession).apply();
    }

    public String getDataSession(){
        return mSharedPreferences.getString(KEY_DATASESSION,"");
    }
}
