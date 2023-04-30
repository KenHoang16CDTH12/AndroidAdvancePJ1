package com.example.orderf_ood.view.main.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;

import java.util.List;

/**
 * Home Fragment
 */
public class HomeFragment extends Fragment {

    private GridView mGridFoodView;
    private CustomFoodGridAdapter mCustomFoodGridAdapter;
    private List<FoodModel> mListFood;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        mListFood = FoodModel.dataTestFoods();
    }

    private void initView(final View view) {
        mGridFoodView = view.findViewById(R.id.grid_list_food);
        mCustomFoodGridAdapter = new CustomFoodGridAdapter(mListFood, requireContext());
        mGridFoodView.setAdapter(mCustomFoodGridAdapter);
    }
}