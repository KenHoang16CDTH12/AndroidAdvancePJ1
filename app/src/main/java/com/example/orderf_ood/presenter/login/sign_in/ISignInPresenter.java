package com.example.orderf_ood.presenter.login.sign_in;

public interface ISignInPresenter {
    void initData();
    void login(String email, String password, boolean hasRemember);
    void onRememberCheckedChange(boolean hasRemember);
}