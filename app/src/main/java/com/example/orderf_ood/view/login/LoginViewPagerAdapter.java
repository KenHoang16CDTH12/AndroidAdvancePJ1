package com.example.orderf_ood.view.login;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.orderf_ood.view.login.sign_in.SignInFragment;
import com.example.orderf_ood.view.login.sign_up.SignUpFragment;

public class LoginViewPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGE = 2;

    public LoginViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public LoginViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public LoginViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SignInFragment();
            case 1:
                return new SignUpFragment();
        }
        return new SignInFragment();
    }

    @Override
    public int getItemCount() {
        return NUM_PAGE;
    }
}