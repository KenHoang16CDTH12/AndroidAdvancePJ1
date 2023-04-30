package com.example.orderf_ood.core.data.local.model;

import java.util.ArrayList;

public class FoodModel {
    private long mId;
    private String mTitle;
    private String mDescription;
    private int mQuantity;
    private int mPrice;
    private String mURL;

    // Constructor
    public FoodModel(long id, String title, String description, int quantity, int price, String url) {
        this.mId = id;
        this.mTitle = title;
        this.mDescription = description;
        this.mQuantity = quantity;
        this.mPrice = price;
        this.mURL = url;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
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

    public String getURL() {
        return mURL;
    }

    public void setURL(String url) {
        this.mURL = url;
    }

    public static ArrayList<FoodModel> dataTestFoods() {
        final ArrayList<FoodModel> foods = new ArrayList<>();
        foods.add(new FoodModel(1, "Food 1", "TODO: Description", 99, 1000, "https://img.freepik.com/free-photo/big-tasty-burger-with-fries_144627-24415.jpg?w=2000"));
        foods.add(new FoodModel(2, "Food 2", "TODO: Description", 1, 11000, "https://w7.pngwing.com/pngs/692/99/png-transparent-hamburger-street-food-seafood-fast-food-delicious-food-salmon-with-vegetables-salad-in-plate-leaf-vegetable-food-recipe-thumbnail.png"));
        foods.add(new FoodModel(3, "Food 3", "TODO: Description", 22, 2000, "https://images.rawpixel.com/image_png_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvcGYtczk5LW1uLXN3ZWV0LXBvdGF0by1mYWxhZmVsLWJvd2wtNy5wbmc.png?s=Kn6iMY8Xvsajbu2Yxz_R6r6IjS4tzeuB-DbkvYNB1Yg"));
        foods.add(new FoodModel(4, "Food 4", "TODO: Description", 33, 5000, "https://www.freeiconspng.com/thumbs/fast-food-png/fast-food-png-most-popular-fast-food-snacks-in-your-area-and-most--3.png"));
        foods.add(new FoodModel(5, "Food 5", "TODO: Description", 5, 3000, "https://goodmanfielder.com/assets/Uploads/nz-home-food-small.png"));
        return foods;
    }
}
