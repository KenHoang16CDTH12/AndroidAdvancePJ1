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
    final Context mContext;
    final ISignUpFragment mFragment;
    final ILoginInteract mInteract;

    public SignUpPresenter(Context context, ISignUpFragment fragment) {
        this.mContext = context;
        this.mFragment = fragment;
        mInteract = new LoginInteract();
    }

    @Override
    public void register(String username, String email, String password, String confirmPassword) {
        // 1 show loading
        mFragment.showLoading();
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // 2 validate
            // TextUtils.isEmpty -> null, ""
            if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(email)) {
                mFragment.registerFailure("Register failure. Input data is null value.");
            } else {
                // 1/ Validate input username
                //  -> Username length 10
                if (username.length() < 5) {
                    mFragment.registerFailure("Register failure.  Username must contain at least 5 characters ");
                } else {
                    // 2/ Kiem tra username trong database chua
                    if (mInteract.checkUsernameExists(mContext, username)) {
                        mFragment.registerFailure("This name already exist. Please try another name");
                    } else {
                        // 3/ Kiem tra email da ton tai trong database chua
                        if(mInteract.checkEmailExists(mContext, email)){
                            mFragment.registerFailure("This email already exist. Please try another email");
                        }else {
                            // 4/ Validate password
                            // -> Condition①: Password length 8
                            // -> Condition②: Password == ConfirmPassword
                            if(password.length()<8){
                                mFragment.registerFailure("Register failure. Password must contain at least 8 characters");
                            }else{
                                if(!password.equals(confirmPassword)){
                                    mFragment.registerFailure("Register failure. Password do not match");
                                }else{
                                    UserModel userModel = new UserModel(username, password, email);
                                    boolean isResult = mInteract.register(mContext, userModel);
                                    if (isResult) {
                                        mFragment.registerSuccess();
                                        mInteract.requestLogin(mContext,email,password);
                                    } else {
                                        mFragment.registerFailure("Register failure. Occurs error!!!");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // handle hide loading
            mFragment.hideLoading();
        }, 2000);
    }
}