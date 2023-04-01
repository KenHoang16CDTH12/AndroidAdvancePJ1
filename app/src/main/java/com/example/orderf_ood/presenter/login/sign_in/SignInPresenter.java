package com.example.orderf_ood.presenter.login.sign_in;

import android.text.TextUtils;

import com.example.orderf_ood.model.login.LoginInteract;
import com.example.orderf_ood.view.login.sign_in.ISignInFragment;

public class SignInPresenter implements ISignInPresenter {

    private LoginInteract mLoginInteract;

    private ISignInFragment mIFragment;

    public SignInPresenter(ISignInFragment iSignInFragment) {
        mIFragment = iSignInFragment;
        // init variable
        mLoginInteract = new LoginInteract();
    }

    @Override
    public void login(String email, String password, boolean hasRemember) {
        mIFragment.showLoading();
        if (validateEmail(email) && validatePassword(password)) {
            boolean isLoginResult = mLoginInteract.requestLogin(email, password);
            if (isLoginResult) {
                mIFragment.loginSuccess();
            } else {
                mIFragment.loginFailure("Email or password is not correct");
            }
        } else {
            mIFragment.loginFailure("Email or password validate not correct");
        }
        mIFragment.hideLoading();
    }

    private boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            mIFragment.showErrorMailValidate();
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            mIFragment.showErrorPasswordValidate();
            return false;
        } else {
            return true;
        }
    }
}
