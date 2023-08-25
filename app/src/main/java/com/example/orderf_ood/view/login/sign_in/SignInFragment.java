package com.example.orderf_ood.view.login.sign_in;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.sign_in.SignInPresenter;
import com.example.orderf_ood.view.main.HomeActivity;

public class SignInFragment extends Fragment implements ISignInFragment {
    private static final String CLASS_NAME = "SignInFragment";
    private SignInPresenter mPresenter;
    private EditText mEdEmail;
    private EditText mEdPassword;
    private Button mButtonSignIn;
    private ProgressDialog mProgressBar;
    private CheckBox mRememberCheckbox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
        initView(root);
        initData();
        return root;
    }

    private void initData() {
        mPresenter = new SignInPresenter(requireContext(), this);
        mPresenter.initData();
    }

    private void initView(View view) {
        mButtonSignIn = view.findViewById(R.id.btn_sign_in);
        mEdEmail = view.findViewById(R.id.edt_email);
        mEdPassword = view.findViewById(R.id.edt_password);
        mRememberCheckbox = view.findViewById(R.id.checkBox);

        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(mEdEmail.getText().toString(),
                        mEdPassword.getText().toString(),
                        hasRemember()
                );
            }
        });

        mRememberCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mPresenter.onRememberCheckedChange(isChecked);
            }
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
    public void loadSaveUserData(String email, String password, boolean hasRemember) {
        mEdEmail.setText(email);
        mEdPassword.setText(password);
        mRememberCheckbox.setChecked(hasRemember);
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
    public void showErrorMailValidate() {

    }

    @Override
    public void showErrorPasswordValidate() {

    }

    @Override
    public void loginSuccess() {
                // Open HomeActivity
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
    }

    @Override
    public void loginFailure(String message) {
        displayDialog("Information", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(CLASS_NAME, ".loginFailure message: " + message);
            }
        });
    }

    private boolean hasRemember() {
        return mRememberCheckbox.isChecked();
    }
}