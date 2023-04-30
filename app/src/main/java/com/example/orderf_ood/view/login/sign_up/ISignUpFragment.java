package com.example.orderf_ood.view.login.sign_up;

import android.app.Activity;

public interface ISignUpFragment {
    void showLoading();
    void hideLoading();
    void registerSuccess();
    void registerFailure(String message);
    void hideKeyBoard(Activity activity);
}