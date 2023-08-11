package com.example.orderf_ood.view.cart;

import com.example.orderf_ood.core.data.local.model.FoodModel;

public class CartModel {
    private FoodModel foodModel;
    private int quantity;

    public CartModel(FoodModel foodModel, int quantity) {
        this.foodModel = foodModel;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameFood() {
        return foodModel.getTitle();
    }

    public String getUrlImage() {
        return foodModel.getUrl();
    }

    public int getTotalMoney() {
        return quantity * foodModel.getPrice();
    }
}
