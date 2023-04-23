package com.example.orderf_ood.view.login.sign_up;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.sign_up.ISignUpPresenter;
import com.example.orderf_ood.presenter.login.sign_up.SignUpPresenter;

public class SignUpFragment extends Fragment implements ISignUpFragment {

    private ISignUpPresenter mPresenter;
    private EditText edUserName;
    private EditText edEmail;
    private EditText edPassword;
    private Button buttonRegister;
    private ProgressDialog mProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_up, container, false);
        initData();
        initView(root);
        return root;
    }

    private void initData() {
        // Create presenter
        mPresenter = new SignUpPresenter(getContext(), this);
    }

    private void initView(View view) {
        edUserName = view.findViewById(R.id.edt_username);
        edEmail = view.findViewById(R.id.edt_email);
        edPassword = view.findViewById(R.id.edt_password);
        buttonRegister = view.findViewById(R.id.btn_register);
        buttonRegister.setOnClickListener(viewClick -> {
            mPresenter.register(
                    edUserName.getText().toString(),
                    edPassword.getText().toString(),
                    edEmail.getText().toString()
            );
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
    public void registerSuccess() {
        new AlertDialog.Builder(getContext())
                .setTitle("Oshirase")
                .setMessage("Dang ky thanh cong")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    // Continue with delete operation
                })
                .show();
    }

    @Override
    public void registerFailure(String message) {
        new AlertDialog.Builder(getContext())
                .setTitle("Oshirase That bai")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    // Continue with delete operation
                })
                .show();
    }
    public void startLoadData() {
        mProgressBar.setCancelable(false);
        mProgressBar.setMessage("Loading　..");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.show();
    }
}