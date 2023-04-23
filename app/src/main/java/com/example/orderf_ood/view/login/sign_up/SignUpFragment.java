package com.example.orderf_ood.view.login.sign_up;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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

import java.util.Objects;

public class SignUpFragment extends Fragment implements ISignUpFragment {
    private static final String CLASS_NAME = SignUpFragment.class.getName();
    private ISignUpPresenter mPresenter;
    private EditText edUserName;
    private EditText edEmail;
    private EditText edPassword;
    private EditText edConfirmPassword;
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
        edConfirmPassword = view.findViewById(R.id.edt_confirm_password);
        buttonRegister = view.findViewById(R.id.btn_register);
        buttonRegister.setOnClickListener(viewClick -> {
            mPresenter.register(
                    edUserName.getText().toString(),
                    edEmail.getText().toString(),
                    edPassword.getText().toString(),
                    edConfirmPassword.getText().toString()
            );
        });
        mProgressBar = new ProgressDialog(getContext());
    }

    private void displayDialog(String title,
                               String message,
                               final DialogInterface.OnClickListener onCallbackClickOK) {
        new AlertDialog.Builder(requireContext())
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, onCallbackClickOK)
                .show();
    }

    @Override
    public void showLoading() {
        mProgressBar.setCancelable(false);
        mProgressBar.setMessage("Loading　..");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.show();
    }

    @Override
    public void hideLoading() {
        mProgressBar.dismiss();
    }

    @Override
    public void registerSuccess() {
        displayDialog("Information", "Register successfully !!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, "registerSuccess");
            }
        });
    }

    @Override
    public void registerFailure(String message) {
        displayDialog("Information", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, "registerFailure");
            }
        });
    }

    @Override
    public void showErrorUserNameExists() {
        displayDialog("Information", "Error -> username exists", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, "showErrorUserNameExists");
            }
        });
    }

    @Override
    public void showErrorEmailExists() {
        displayDialog("Information", "Error -> email exists", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, "showErrorEmailExists");
            }
        });
    }

    @Override
    public void showErrorValidatePassword() {
        displayDialog("Information", "Error -> validate password failure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, "showErrorValidatePassword");
            }
        });
    }

    @Override
    public void showErrorPasswordNotMatch() {
        displayDialog("Information", "Error -> password not match", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, "showErrorPasswordNotMatch");
            }
        });
    }
}