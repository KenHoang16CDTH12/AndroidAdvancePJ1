package com.example.orderf_ood.presenter.login.sign_up;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.example.orderf_ood.core.data.local.model.UserModel;
import com.example.orderf_ood.model.login.ILoginInteract;
import com.example.orderf_ood.model.login.LoginInteract;
import com.example.orderf_ood.view.login.sign_up.ISignUpFragment;

public class SignUpPresenter implements ISignUpPresenter {
    final Context context;
    final ISignUpFragment fragment;
    final ILoginInteract interact;

    public SignUpPresenter(Context context, ISignUpFragment fragment) {
        this.context = context;
        this.fragment = fragment;
        interact = new LoginInteract();
    }

    @Override
    public void register(String username, String email, String password, String confirmPassword) {
        // 1 show loading
        fragment.showLoading();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // 2 validate
            // TextUtils.isEmpty -> null, ""
            if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(email)) {
                fragment.registerFailure("Register failure. Input data is null value.");
            } else {
                // 1/ Validate input username
                //  -> Username length 10
                if (username.length() < 5) {
                    fragment.registerFailure("Register failure username length not true");
                } else {
                    // 2/ Kiem tra username trong database chua
                    if (interact.checkUsernameExists(context, username)) {
                        fragment.showErrorUserNameExists();
                    } else {
                        // 3/ Kiem tra email da ton tai trong database chua
                        // TODO: BTVN ↑
                        // 4/ Validate password
                        // -> Condition①: Password length 8
                        // -> Condition②: Password == ConfirmPassword
                        // TODO: BTVN ↑
                        UserModel userModel = new UserModel(username, password, email);
                        boolean isResult = interact.register(context, userModel);
                        if (isResult) {
                            fragment.registerSuccess();
                        } else {
                            fragment.registerFailure("Occurs error!!!");
                        }
                    }
                }
            }
            // handle hide loading
            fragment.hideLoading();
        }, 2000);
    }
}