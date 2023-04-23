package com.example.orderf_ood.view.login.sign_in;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.sign_in.SignInPresenter;
import com.example.orderf_ood.view.home.HomeActivity;
import com.example.orderf_ood.view.login.LoginActivity;

public class SignInFragment extends Fragment implements ISignInFragment {
    private SignInPresenter mPresenter;
    private EditText edEmail; // TODO: BTVN -> (coding convention: private name)
    private EditText edPassword; // TODO: BTVN -> (coding convention: private name)
    private Button buttonSignIn; // TODO: BTVN -> (coding convention: private name)
    private ProgressDialog mProgressBar;
    private CheckBox mRememberCheckbox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_in, container, false);
        buttonSignIn = root.findViewById(R.id.btn_sign_in);
        edEmail= root.findViewById(R.id.edt_email);
        edPassword= root.findViewById(R.id.edt_password);
        mRememberCheckbox = root.findViewById(R.id.checkBox);
        initData();
        initView();
        return root;
    }

    private void initData() {
        mPresenter = new SignInPresenter(requireContext(), this);
    }

    private void initView() {
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(edEmail.getText().toString(),
                                 edPassword.getText().toString(),
                                 hasRemember()
                );
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
        displayDialog("Information", "Login success", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Open Register
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }

    @Override
    public void loginFailure(String message) {
        displayDialog("Information", message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // TODO: BTVN -> Add log
            }
        });
    }

    private boolean hasRemember(){
        return mRememberCheckbox.isChecked();
    }
}