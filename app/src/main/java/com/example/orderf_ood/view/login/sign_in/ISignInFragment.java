package com.example.orderf_ood.view.login.sign_in;

public interface ISignInFragment {
    void showLoading();
    void hideLoading();
    void showErrorMailValidate();
    void showErrorPasswordValidate();
    void loginSuccess();
    void loginFailure(String message);
}
