package com.example.orderf_ood.core.data.local.model;

import android.content.Context;

import com.example.orderf_ood.core.data.local.table.FoodProductTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FoodModel implements Serializable {
    private int mId;
    private String mTitle;
    private String mDescription;
    private int mQuantity;
    private int mPrice;
    private String mURL;

    public FoodModel(int id, String title, String description, int quantity, int price, String url) {
        this.mId = id;
        this.mTitle = title;
        this.mDescription = description;
        this.mQuantity = quantity;
        this.mPrice = price;
        this.mURL = url;
    }

    public static void insertDataTestFood(Context context) {
        final ArrayList<FoodModel> foods = new ArrayList<>();
        FoodProductTable.addFood(context, new FoodModel(1, "Banh xeo","Sizzling cake", 10, 1000, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_3.jpg"));
        FoodProductTable.addFood(context, new FoodModel(2, "Banh mi","Steamed Rice Cake", 10, 1100, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_5.jpg"));
        FoodProductTable.addFood(context, new FoodModel(3, "Cha gio"," Fried Spring Rolls", 10, 1000, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_7.jpg"));
        FoodProductTable.addFood(context, new FoodModel(4, "Bun bo hue","Bun bo hue", 10, 1500, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_8.jpg"));
        FoodProductTable.addFood(context, new FoodModel(5, "Bun cha","Bun cha", 10, 900, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_9.jpg"));
        FoodProductTable.addFood(context, new FoodModel(6, "Goi cuon ","Spring roll", 10, 1200, "https://www.luneproduction.com/Content/Images/uploaded/PressParnership/food_10.jpg"));
    }


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        this.mQuantity = quantity;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        this.mPrice = price;
    }

    public String getUrl() {
        return mURL;
    }

    public void setUrl(String url) {
        this.mURL = url;
    }
}
