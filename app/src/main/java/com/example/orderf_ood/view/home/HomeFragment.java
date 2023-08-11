package com.example.orderf_ood.view.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.orderf_ood.FoodDetailActivity;
import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.core.data.local.table.FoodProductTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Home Fragment
 */
public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerFoodView;
    private ImageSlider mImageSlider;
    private CustomFoodListAdapter mCustomFoodListAdapter;
    private List<FoodModel> mListFood = new ArrayList<>();


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
        mListFood.clear();
        mListFood.addAll(FoodProductTable.getFoods(getContext()));
    }

    private void initView(final View view) {
        mRecyclerFoodView = view.findViewById(R.id.recycler_list_food);
        mRecyclerFoodView.setHasFixedSize(true);
        mCustomFoodListAdapter = new CustomFoodListAdapter(requireContext(), mListFood, new CustomFoodListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FoodModel item) {
                Intent intent = new Intent(getActivity(), FoodDetailActivity.class);
                intent.putExtra("url_food", item.getUrl());
                startActivity(intent);
            }
        });
        mRecyclerFoodView.setAdapter(mCustomFoodListAdapter);
        mImageSlider = view.findViewById(R.id.imageSlider);
        refreshData();

    }

    @Override
    public void onResume() {
        initData();
        refreshData();
        super.onResume();
    }

    private void refreshData() {
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        for (FoodModel item : mListFood) {
            slideModels.add(new SlideModel(item.getUrl(), item.getTitle(), ScaleTypes.FIT));
        }
        mImageSlider.setImageList(slideModels, ScaleTypes.FIT);
        mCustomFoodListAdapter.notifyDataSetChanged();
    }
}