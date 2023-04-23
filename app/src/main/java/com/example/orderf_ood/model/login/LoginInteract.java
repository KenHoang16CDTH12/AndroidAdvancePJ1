package com.example.orderf_ood.model.login;

import android.content.Context;
import android.text.TextUtils;

import com.example.orderf_ood.core.data.local.model.UserModel;
import com.example.orderf_ood.core.data.local.table.UserTable;

public class LoginInteract implements ILoginInteract {

    private static final String CLASS_NAME = "LoginInteract";

    @Override
    public boolean requestLogin(Context context, String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            return false;
        }
        final boolean isLoginResult = UserTable.requestLogin(context, email, password);
        return isLoginResult;
    }

    @Override
    public boolean register(Context context, UserModel userModel) {
        final boolean isResult = UserTable.insertUser(context, userModel);
        return isResult;
    }

    @Override
    public boolean checkUsernameExists(Context context, String username) {
        final boolean isExists = UserTable.checkUserNameExists(context, username);
        return isExists;
    }
}