package com.example.orderf_ood.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.orderf_ood.view.login.LoginFragment;
import com.example.orderf_ood.view.login.SignUpFragment;

public class LoginAdapter extends FragmentStateAdapter {

    public LoginAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public LoginAdapter(@NonNull FragmentManager supportFragmentManager, Lifecycle lifecycle) {
        super(supportFragmentManager,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                LoginFragment loginFragment = new LoginFragment();
                return  loginFragment;
            case 1:
                SignUpFragment signUpFragment = new SignUpFragment();
                return signUpFragment;
            default:
                Log.d("error","error when switch position, position: "+position);
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
