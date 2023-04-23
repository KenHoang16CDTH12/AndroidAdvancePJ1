package com.example.orderf_ood.view.login.sign_up;

public interface ISignUpFragment {
    void showLoading();
    void hideLoading();
    void registerSuccess();
    void registerFailure(String message);
    void showErrorUserNameExists(); // TODO: BTVN -> Remove
    void showErrorEmailExists(); // TODO: BTVN -> Remove
    // Length 8
    void showErrorValidatePassword(); // TODO: BTVN -> Remove
    void showErrorPasswordNotMatch(); // TODO: BTVN -> Remove
}