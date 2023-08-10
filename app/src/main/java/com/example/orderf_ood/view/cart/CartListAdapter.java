package com.example.orderf_ood.view.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.orderf_ood.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private final List<CartModel> mListCart;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private OnItemClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFood;
        TextView tvNameFood;
        TextView tvPriceFood;
        ElegantNumberButton elegantNumberButton;


        public ViewHolder(@NonNull View view) {
            super(view);
            imageFood = view.findViewById(R.id.item_image_food);
            tvNameFood = view.findViewById(R.id.item_name_food);
            tvPriceFood = view.findViewById(R.id.item_price_food);
            elegantNumberButton = view.findViewById(R.id.elegant_number_button_item_cart_list);
        }
    }

    public CartListAdapter(@NonNull Context context, @NonNull List<CartModel> objects, OnItemClickListener listener) {
        mListCart = objects;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_cart_list_food, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartModel cartModel = mListCart.get(position);
        //image -> hien thi hinh anh  bang url
        Picasso.get().
                load(cartModel.getUrlImage())
                .placeholder(R.drawable.failed_image)
                .error(R.drawable.failed_image)
                .into(holder.imageFood);
        holder.tvNameFood.setText(cartModel.getNameFood());
        holder.tvPriceFood.setText(cartModel.getTotalMoney()+" 円");
        holder.elegantNumberButton.setNumber(String.valueOf(cartModel.getQuantity()));
        holder.elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                cartModel.setQuantity(newValue);
            }
        });
    }

    /**o
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mListCart.size();
    }

    public interface OnItemClickListener {
        void onItemClick(CartModel item);
    }
}
