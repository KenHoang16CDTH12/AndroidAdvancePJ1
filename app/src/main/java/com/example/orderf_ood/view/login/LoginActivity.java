package com.example.orderf_ood.view.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.orderf_ood.Adapter.LoginAdapter;
import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.presenter.LoginPresenter;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private LoginPresenter mPresenter;
    private EditText mEdEmail;
    private EditText mEdPassword;
    private Button mButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
        initView();
    }

    private void initData() {
        mPresenter = new LoginPresenter(this);
    }

    private void initView() {
        mEdEmail = findViewById(R.id.edt_email);
        mEdPassword = findViewById(R.id.edt_password);
        mButtonLogin = findViewById(R.id.btn_login_tutorial);
        if(mButtonLogin != null){
            mButtonLogin.setOnClickListener(
                    view -> mPresenter.login(
                            mEdEmail.getText().toString(),
                            mEdPassword.getText().toString()
                    )
            );
        }
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager2);
        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("Sign Up"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
    }

    @Override
    public void showLoading() {
        // TODO:
    }

    @Override
    public void hideLoading() {
        // TODO:
    }

    @Override
    public void showErrorMailValidate() {
        // Dialog
        // Text red
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Email validate failure")

                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void showErrorPasswordValidate() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Password validate failure")

                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void loginSuccess() {

        new AlertDialog.Builder(this)
                .setTitle("Welcome")
                .setMessage("Login success")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }

    @Override
    public void loginFailure(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Login failure")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}