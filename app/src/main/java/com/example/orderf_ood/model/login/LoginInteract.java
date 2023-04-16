package com.example.orderf_ood.model.login;

import android.util.Log;

public class LoginInteract implements ILoginInteract {

    private static final String CLASS_NAME = "LoginInteract";

    private String mEmailDataDummy = "test@gmail.com";
    private String mPassword = "123456";

    @Override
    public boolean requestLogin(String email, String password) {
        // Call Api
        // Truy cap Database
        // ---
        if (email.equals(mEmailDataDummy) && password.equals(mPassword)) {
            Log.d(CLASS_NAME, "Login success!!!");
            return true;
        }
        Log.d(CLASS_NAME, "Login failure!!!");
        return false;
    }
}