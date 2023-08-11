package com.example.orderf_ood.view.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.view.main.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class CartListActivity extends AppCompatActivity {
    private FoodModel foodModel;
    private String KEY = "FoodDetail_Info";
    private RecyclerView mRecyclerCartView;
    private CartListAdapter mCartListAdapter;
    private ImageView buttonBack;
    private List<CartModel> mCartFoodList = new ArrayList<>();
    private TextView textViewTotalPrice;
    private Button buttonOder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        buttonBack = findViewById(R.id.button_back);
        textViewTotalPrice = findViewById(R.id.text_view_price);
        buttonOder = findViewById(R.id.button_place_order);
        mRecyclerCartView = findViewById(R.id.list_item_cart_food);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartListActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        initData();

        mCartListAdapter = new CartListAdapter(getApplicationContext(), mCartFoodList, new CartListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CartModel item) {
                // setting when click cart list item
            }
        });
        mRecyclerCartView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerCartView.setAdapter(mCartListAdapter);

        mCartListAdapter.notifyDataSetChanged();

    }

    private void initData() {
        mCartFoodList.clear();
        mCartFoodList.addAll(cartListDummy());
    }

    private List<CartModel> cartListDummy() {
        ArrayList<CartModel> carts = new ArrayList<>();
        carts.add(new CartModel(new FoodModel(1, "Banh xeo","Sizzling cake", 10, 1000, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_3.jpg"), 5));
        carts.add(new CartModel(new FoodModel(2, "Banh mi","Steamed Rice Cake", 10, 1100, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_5.jpg"), 12));
        carts.add(new CartModel(new FoodModel(3, "Cha gio"," Fried Spring Rolls", 10, 1000, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_7.jpg"), 1));
        carts.add(new CartModel(new FoodModel(4, "Bun bo hue","Bun bo hue", 10, 1500, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_8.jpg"), 4));
        carts.add(new CartModel(new FoodModel(5, "Bun cha","Bun cha", 10, 900, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_9.jpg"), 22));
        carts.add(new CartModel(new FoodModel(6, "Goi cuon ","Spring roll", 10, 1200, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_10.jpg"), 99));
        return carts;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, foodModel);
    }
}
