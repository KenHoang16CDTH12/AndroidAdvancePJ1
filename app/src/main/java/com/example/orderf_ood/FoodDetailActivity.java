package com.example.orderf_ood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.core.data.local.table.FoodProductTable;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FoodDetailActivity extends AppCompatActivity {
    private FoodModel foodModel;
    private String KEY = "FoodDetail_Info";
    private KenBurnsView mFoodDetailImage;
    private TextView mFoodName;
    private TextView mFoodPrice;
    private ElegantNumberButton elegantNumberButton;
    private RatingBar mRatingBar;
    private Button mShowCommentButton;
    private FloatingActionButton mButtonRatingBar;
    private List<FoodModel> mListFood = new ArrayList<>();

    public FoodModel getFoodModel() {
        return foodModel;
    }

    public void setFoodModel(FoodModel foodModel) {
        this.foodModel = foodModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        //save instance state
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY)) {
            foodModel = (FoodModel) savedInstanceState.getSerializable(KEY);
        }
        mListFood.addAll(FoodProductTable.getFoods(getApplication()));

        elegantNumberButton = findViewById(R.id.elegant_number_button);
        mFoodDetailImage = findViewById(R.id.food_detail_image);
        mFoodName = findViewById(R.id.food_detail_name_2);
        mFoodPrice = findViewById(R.id.food_detail_price);
        mRatingBar = findViewById(R.id.food_detail_rating_bar);
        mButtonRatingBar = findViewById(R.id.button_rating);
        mShowCommentButton = findViewById(R.id.food_detail_btn_show_comment);

        elegantNumberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = elegantNumberButton.getNumber();
                // save number and may add animation
            }
        });
        mButtonRatingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingBarDialog();
            }
        });
    }

    private void showRatingBarDialog() {
        // create alert dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // rigister view
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_custom_rating_food,null);

        //set view to dialog
        dialogBuilder.setView(dialogView);
        EditText editTextComment = dialogView.findViewById(R.id.edit_text_comment);
        RatingBar ratingBar = dialogView.findViewById(R.id.rating_bar_food);
        MaterialButton buttonCancel = dialogView.findViewById(R.id.button_cancel);
        MaterialButton buttonSubmit = dialogView.findViewById(R.id.button_submit);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        //click button cancel
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });

        //click button submit
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRatingBar.setRating(ratingBar.getRating());
                alertDialog.dismiss();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(KEY, foodModel);
    }
}