package com.example.orderf_ood.presenter.login;

import android.content.Context;
import android.text.TextUtils;

import com.example.orderf_ood.core.data.local.helpers.SQLiteDatabaseHelpers;
import com.example.orderf_ood.model.login.LoginInteract;
import com.example.orderf_ood.view.login.ILoginActivity;

public class LoginPresenter implements ILoginPresenter {

    private ILoginActivity mILoginActivity;

    public LoginPresenter(Context context, ILoginActivity iLoginActivity) {
        mILoginActivity = iLoginActivity;
        SQLiteDatabaseHelpers.getInstance(context);
    }
}