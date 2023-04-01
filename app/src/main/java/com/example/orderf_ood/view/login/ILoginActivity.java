package com.example.orderf_ood.view.login;

public interface ILoginActivity {
    void showLoading();
    void hideLoading();
    void showErrorMailValidate();
    void showErrorPasswordValidate();
    void loginSuccess();
    void loginFailure(String message);
}
