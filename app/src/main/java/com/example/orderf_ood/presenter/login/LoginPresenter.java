package com.example.orderf_ood.presenter.login;

import android.text.TextUtils;

import com.example.orderf_ood.model.login.LoginInteract;
import com.example.orderf_ood.view.login.ILoginActivity;

public class LoginPresenter implements ILoginPresenter {

    private ILoginActivity mILoginActivity;

    public LoginPresenter(ILoginActivity iLoginActivity) {
        mILoginActivity = iLoginActivity;
    }
}
