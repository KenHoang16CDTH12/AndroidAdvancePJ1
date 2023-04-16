package com.example.orderf_ood.model.login.sign_up;

import android.content.Context;

import com.example.orderf_ood.core.data.local.model.UserModel;

public interface ISignUpInteract {
    boolean register(final Context context, final UserModel userModel);
}