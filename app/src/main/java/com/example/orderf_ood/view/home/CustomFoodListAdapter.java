package com.example.orderf_ood.view.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomFoodListAdapter extends RecyclerView.Adapter<CustomFoodListAdapter.ViewHolder> {
    private final List<FoodModel> mListFood;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private OnItemClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageFood;
        TextView tvNameFood;
        TextView tvPriceFood;
        Button btnAddToCard;
        ProgressBar progressBar;

        public ViewHolder(@NonNull View view) {
            super(view);
            imageFood = view.findViewById(R.id.image_food);
            tvNameFood = view.findViewById(R.id.tv_food_name);
            tvPriceFood = view.findViewById(R.id.tv_food_price);
            btnAddToCard = view.findViewById(R.id.btn_add_to_card);
            progressBar = view.findViewById(R.id.progres_bar);
        }
    }

    public CustomFoodListAdapter(@NonNull Context context, @NonNull List<FoodModel> objects, OnItemClickListener listener) {
        mListFood = objects;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.item_grid_food, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodModel foodModel = mListFood.get(position);
        //image -> hien thi hinh anh  bang url
        Picasso.get().
                load(foodModel.getUrl())
                .placeholder(R.drawable.failed_image)
                .error(R.drawable.failed_image)
                .into(holder.imageFood, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        holder.progressBar.setVisibility(View.GONE);
                    }
                });
        holder.tvNameFood.setText(foodModel.getTitle());
        holder.tvPriceFood.setText(foodModel.getPrice()+"円");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(foodModel);

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
        return mListFood.size();
    }

    public interface OnItemClickListener {
        void onItemClick(FoodModel item);
    }
}
