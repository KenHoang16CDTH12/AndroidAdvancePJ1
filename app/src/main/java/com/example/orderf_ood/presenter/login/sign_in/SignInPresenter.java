package com.example.orderf_ood.presenter.login.sign_in;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.example.orderf_ood.core.data.local.helpers.SharedPrefrenceHelpers;
import com.example.orderf_ood.model.login.LoginInteract;
import com.example.orderf_ood.view.login.sign_in.ISignInFragment;


public class SignInPresenter implements ISignInPresenter {

    private Context mContext;

    private LoginInteract mLoginInteract;

    private ISignInFragment mIFragment;

    public SignInPresenter(final Context context, ISignInFragment iSignInFragment) {
        mContext = context;
        mIFragment = iSignInFragment;
        // init variable
        mLoginInteract = new LoginInteract();
    }

    @Override
    public void initData() {
        final String email = SharedPrefrenceHelpers.getInstance().getEmail(mContext);
        final String password = SharedPrefrenceHelpers.getInstance().getPassword(mContext);
        final boolean hasRemember = SharedPrefrenceHelpers.getInstance().hasRemember(mContext);
        mIFragment.loadSaveUserData(email, password, hasRemember);
//        login(email, password, hasRemember);
    }

    @Override
    public void onRememberCheckedChange(boolean hasRemember) {
        if (!hasRemember) {
            SharedPrefrenceHelpers.getInstance().remove(mContext);
        }
    }

    @Override
    public void login(String email, String password, boolean hasRemember) {
        // Step 1: display loading progress
        mIFragment.showLoading();
        // Step 2: fake delay
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (email != null || password != null) {
                if (validateEmail(email) && validatePassword(password)) {
                    boolean isLoginResult = mLoginInteract.requestLogin(mContext, email, password);
                    if (isLoginResult) {
                        if (hasRemember) {
                            SharedPrefrenceHelpers.getInstance().setEmail(mContext, email);
                            SharedPrefrenceHelpers.getInstance().setPassword(mContext, password);
                            SharedPrefrenceHelpers.getInstance().setRememberUserInformation(mContext, hasRemember);
                        }
                        mIFragment.loginSuccess();
                    } else {
                        mIFragment.loginFailure("Email or password is not correct");
                    }
                } else {
                    mIFragment.loginFailure("Email or password validate not correct");
                }
            }

            mIFragment.hideLoading();
        }, 1500);
    }

    private boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            mIFragment.loginFailure("Email is empty");
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            mIFragment.loginFailure("Password is empty");
            return false;
        } else {
            return true;
        }
    }
}