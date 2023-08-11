package com.example.orderf_ood.view.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.orderf_ood.R;

/**
 * Home Fragment
 */
public class AccountFragment extends Fragment {
    private Button  buttonMap;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance() {
        AccountFragment fragment = new AccountFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View  view = inflater.inflate(R.layout.fragment_account, container, false);
       buttonMap = view.findViewById(R.id.button_map);
       buttonMap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String address = "";
               String url = "http://maps.google.com/maps?daddr="+address;
               Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
               startActivity(intent);
           }
       });
        return  view;
    }
}