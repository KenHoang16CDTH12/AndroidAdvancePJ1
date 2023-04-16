package com.example.orderf_ood.view.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.orderf_ood.R;
import com.example.orderf_ood.presenter.login.LoginPresenter;
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
        mPresenter = new LoginPresenter(getApplicationContext(), this);
    }

    private void initView() {
        // Set up touch listener for non-text box views to hide keyboard.
        findViewById(R.id.root_layout).setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                hideSoftKeyboard(LoginActivity.this);
                return false;
            }
        });
        // get
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_container_page);
        //
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

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }
}