package com.example.orderf_ood.presenter.login.sign_up;

import android.content.Context;
import android.text.TextUtils;

import com.example.orderf_ood.core.data.local.model.UserModel;
import com.example.orderf_ood.model.login.sign_up.ISignUpInteract;
import com.example.orderf_ood.model.login.sign_up.SignUpInteractor;
import com.example.orderf_ood.view.login.sign_up.ISignUpFragment;

public class SignUpPresenter implements ISignUpPresenter {
    final Context context;
    final ISignUpFragment fragment;
    final ISignUpInteract interact;

    public SignUpPresenter(Context context, ISignUpFragment fragment) {
        this.context = context;
        this.fragment = fragment;
        interact = new SignUpInteractor();
    }

    @Override
    public void register(String username, String password, String email) {
        // 1 show loading
        fragment.showLoading();
        // 2 validate
        // TextUtils.isEmpty -> null, ""
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(email)) {
            fragment.hideLoading();
            fragment.registerFailure("Register failure. Input data is null value.");
        } else {
            UserModel userModel = new UserModel(username, password, email);
            boolean isResult = interact.register(context, userModel);
            fragment.hideLoading();
            if (isResult) {
                fragment.registerSuccess();
            } else {
                fragment.registerFailure("Occurs error!!!");
            }
        }
    }
}