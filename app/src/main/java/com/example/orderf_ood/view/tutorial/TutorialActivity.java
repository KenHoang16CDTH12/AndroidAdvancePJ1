package com.example.orderf_ood.view.tutorial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.orderf_ood.R;
import com.example.orderf_ood.view.login.LoginActivity;
import com.example.orderf_ood.view.main.HomeActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class TutorialActivity extends AppCompatActivity implements ITutorialActivity {
    public static CallbackManager mCallbackManager;
    public static AccessToken accessToken;

    private Button mContinueButton;
    private LoginButton mFacebookLoginButton;
    private static final String EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        initView();
        printHashKey(getApplicationContext());
        accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if (isLoggedIn) {
            // if already login move to home activuty
            Intent intent = new Intent(TutorialActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }
    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("test", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("test", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("test", "printHashKey()", e);
        }
    }

    private void initView() {
        mContinueButton = findViewById(R.id.btn_login_tutorial);
        mFacebookLoginButton = findViewById(R.id.facebook_login_button);
        if(mContinueButton != null){
            mContinueButton.setOnClickListener(view -> openLoginView());
        }
        mCallbackManager = CallbackManager.Factory.create();
    }

    public void settingFacebookLogin() {
//        mFacebookLoginButton.setPermissions("email","public_profile");
        // Callback registration
        accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        if(!isLoggedIn) {
            mFacebookLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    AccessToken accessToken = loginResult.getAccessToken();
                    Intent intent = new Intent(TutorialActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    mFacebookLoginButton.setVisibility(View.GONE);
                    Log.d("test","settingFacebookLogin dang nhap thanh cong");
                }

                @Override
                public void onCancel() {
                    // App code
                    Log.d("test","settingFacebookLogin huy dang nhap");
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                    Log.d("test","settingFacebookLogin dang nhap that bai");
                }
            });
        } else {
            Intent intent = new Intent(TutorialActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            mFacebookLoginButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void openLoginView() {
        // Open Login
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}