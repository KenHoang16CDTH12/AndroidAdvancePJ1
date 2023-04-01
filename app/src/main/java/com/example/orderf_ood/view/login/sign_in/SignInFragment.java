package com.example.orderf_ood.view.login.sign_in;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.LoginPresenter;
import com.example.orderf_ood.presenter.login.sign_in.SignInPresenter;
import com.example.orderf_ood.view.login.LoginViewPagerAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

public class SignInFragment extends Fragment implements ISignInFragment {
    private SignInPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
        initData();
        initView();
        return root;
    }


    private void initData() {
        mPresenter = new SignInPresenter(this);
    }

    private void initView() {
        Button buttonLoadingTest = getView().findViewById(R.id.btn_test_loading);
        buttonLoadingTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showErrorMailValidate() {

    }

    @Override
    public void showErrorPasswordValidate() {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailure(String message) {

    }
}
