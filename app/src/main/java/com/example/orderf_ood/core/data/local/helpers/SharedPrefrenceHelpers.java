package com.example.orderf_ood.core.data.local.helpers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrenceHelpers {

    private static final String PREFS_NAME = "app_prefs";
    private static final String SPREF_SET_REMEMBER_KEY = "SPREF_SET_REMEMBER_KEY";
    private static final String SPREF_SET_EMAIL_KEY = "SPREF_SET_EMAIL_KEY";
    private static final String SPREF_SET_PASSWORD_KEY = "SPREF_SET_PASSWORD_KEY";
    private static final String SPREF_SET_USER_NAME_KEY = "SPREF_SET_USER_NAME_KEY";

    private static volatile SharedPrefrenceHelpers INSTANCE = null;

    private SharedPrefrenceHelpers() {}

    // public static method to retrieve the singleton instance
    public static SharedPrefrenceHelpers getInstance() {
        // Check if the instance is already created
        if (INSTANCE == null) {
            // synchronize the block to ensure only one thread can execute at a time
            synchronized (SharedPrefrenceHelpers.class) {
                // check again if the instance is already created
                if (INSTANCE == null) {
                    // create the singleton instance
                    INSTANCE = new SharedPrefrenceHelpers();
                }
            }
        }
        // return the singleton instance
        return INSTANCE;
    }

    public void setRememberUserInformation(final Context context, boolean hasRemember) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean(SPREF_SET_REMEMBER_KEY, hasRemember);
        editor.apply(); // commit changes
    }

    public boolean hasRemember(final Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getBoolean(SPREF_SET_REMEMBER_KEY, false);
    }

    public void setEmail(final Context context, String email) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(SPREF_SET_EMAIL_KEY, email);
        editor.apply(); // commit changes
    }

    public void setUserName(final Context context, String name) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(SPREF_SET_USER_NAME_KEY, name);
        editor.apply(); // commit changes
    }

    public String getEmail(final Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(SPREF_SET_EMAIL_KEY, null);
    }

    public String getUserName(final Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(SPREF_SET_USER_NAME_KEY, null);
    }

    public void setPassword(final Context context, String password) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(SPREF_SET_PASSWORD_KEY, password);
        editor.apply(); // commit changes
    }

    public String getPassword(final Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        return sharedpreferences.getString(SPREF_SET_PASSWORD_KEY, null);
    }
    public void remove(final Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.apply();
    }
}
