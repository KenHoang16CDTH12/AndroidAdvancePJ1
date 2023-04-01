package com.example.orderf_ood.view.login.sign_up;

public interface ISignUpFragment {
    void showLoading();
    void hideLoading();
    void showErrorMailValidate();
    void showErrorPasswordValidate();
    void loginSuccess();
    void loginFailure(String message);
}
