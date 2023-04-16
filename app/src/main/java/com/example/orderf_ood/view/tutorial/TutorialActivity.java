package com.example.orderf_ood.view.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.orderf_ood.R;
import com.example.orderf_ood.view.login.LoginActivity;


public class TutorialActivity extends AppCompatActivity implements ITutorialActivity {

    private Button mContinueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        initView();
    }

    private void initView() {
        mContinueButton = findViewById(R.id.btn_login_tutorial);
        if(mContinueButton != null){
            mContinueButton.setOnClickListener(view -> openLoginView());
        }
    }

    @Override
    public void openLoginView() {
        // Open Login
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void openSignUpView() {
        // Open Register
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}