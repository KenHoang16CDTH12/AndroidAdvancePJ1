package com.example.orderf_ood.model.login;

import android.content.Context;

import com.example.orderf_ood.core.data.local.model.UserModel;

public interface ILoginInteract {
    boolean register(final Context context, final UserModel userModel);
    boolean checkUsernameExists(final Context context, final String username);
    boolean requestLogin(final Context context, String email, String password);
    boolean checkEmailExists(final Context context, String email);
}