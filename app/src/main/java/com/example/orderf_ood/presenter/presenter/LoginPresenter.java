package com.example.orderf_ood.presenter.presenter;

import android.text.TextUtils;

import com.example.orderf_ood.model.login.LoginInteract;
import com.example.orderf_ood.view.login.ILoginActivity;

public class LoginPresenter implements ILoginPresenter {

    private ILoginActivity mILoginActivity;
    private LoginInteract mLoginInteract;

    public LoginPresenter(ILoginActivity iLoginActivity) {
        mILoginActivity = iLoginActivity;
        // init variable
        mLoginInteract = new LoginInteract();
    }

    @Override
    public void login(String email, String password) {
        mILoginActivity.showLoading();
        if (validateEmail(email) && validatePassword(password)) {
           boolean isLoginResult = mLoginInteract.requestLogin(email, password);
           if (isLoginResult) {
               mILoginActivity.loginSuccess();
           } else {
               mILoginActivity.loginFailure("Email or password is not correct");
           }
        } else {
            mILoginActivity.loginFailure("Email or password validate not correct");
        }
        mILoginActivity.hideLoading();
    }

    private boolean validateEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            mILoginActivity.showErrorMailValidate();
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            mILoginActivity.showErrorPasswordValidate();
            return false;
        } else {
            return true;
        }
    }
}
