package com.example.orderf_ood.presenter.login.sign_up;

public interface ISignUpPresenter {
    void register(
            String name,
            String numberPhone,
            String email,
            String password,
            String confirmPassword
    );
}