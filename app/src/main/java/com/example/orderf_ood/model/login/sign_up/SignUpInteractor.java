package com.example.orderf_ood.model.login.sign_up;

import android.content.Context;

import com.example.orderf_ood.core.data.local.model.UserModel;
import com.example.orderf_ood.core.data.local.table.UserTable;

public class SignUpInteractor implements ISignUpInteract {
    @Override
    public boolean register(Context context, UserModel userModel) {
        final boolean isResult = UserTable.insertUser(context, userModel);
        return isResult;
    }
}
