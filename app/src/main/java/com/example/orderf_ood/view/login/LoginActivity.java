package com.example.orderf_ood.view.login;

import static com.example.orderf_ood.view.tutorial.TutorialActivity.accessToken;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.LoginPresenter;
import com.example.orderf_ood.view.main.HomeActivity;
import com.example.orderf_ood.view.tutorial.TutorialActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {
    private LoginPresenter mPresenter;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initData();
        initView();
    }

    private void initData() {
        mPresenter = new LoginPresenter(getApplicationContext(),this);
    }

    private void initView() {
        // get
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_container_page);
        final LoginViewPagerAdapter pagerAdapter = new LoginViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        mViewPager.setAdapter(pagerAdapter);
        String[] listTitle = getResources().getStringArray(R.array.login_tab_title_array);
        new TabLayoutMediator(mTabLayout, mViewPager, true,
                (tab, currentPosition) -> {
                    // position of the current tab and that tab
                    tab.setText(listTitle[currentPosition]);
                }
        ).attach();
    }
}