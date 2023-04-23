package com.example.orderf_ood.view.login.sign_in;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.sign_in.SignInPresenter;

public class SignInFragment extends Fragment implements ISignInFragment {
    private SignInPresenter mPresenter;
    private EditText edEmail;
    private EditText edPassword;
    private Button buttonLoadingTest;
    private Button buttonSignIn;
    private ProgressDialog mProgressBar;
    private CheckBox RememberCheckBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
        buttonLoadingTest = root.findViewById(R.id.btn_test_loading);
        buttonSignIn = root.findViewById(R.id.btn_sign_in);
        edEmail= root.findViewById(R.id.edt_email);
        edPassword= root.findViewById(R.id.edt_password);
        RememberCheckBox= root.findViewById(R.id.checkBox);
        initData();
        initView();
        return root;
    }

    private void initData() {
        mPresenter = new SignInPresenter(this);
    }

    private void initView() {
        buttonLoadingTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoading();
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(edEmail.getText().toString(),
                                 edPassword.getText().toString(),
                                 hasRememberbuttonchecked());
            }
        });
        mProgressBar = new ProgressDialog(getContext());

    }

    @Override
    public void showLoading() {
        startLoadData();
    }

    @Override
    public void hideLoading() {
        mProgressBar.dismiss();
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

    public void startLoadData() {
        mProgressBar.setCancelable(false);
        mProgressBar.setMessage("Loading　..");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.show();
    }
    private boolean hasRememberbuttonchecked(){
        if(RememberCheckBox.isChecked()){
            return true;
        }else{
            return false;
        }
    }
}