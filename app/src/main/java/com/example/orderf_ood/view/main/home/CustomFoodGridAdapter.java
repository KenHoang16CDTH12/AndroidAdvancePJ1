package com.example.orderf_ood.view.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.core.handler.DownloadImageTaskHandler;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomFoodGridAdapter extends BaseAdapter {

    private List<FoodModel> mListFood;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public CustomFoodGridAdapter(List<FoodModel> listFood, Context context) {
        this.mListFood = listFood;
        this.mContext = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListFood.size();
    }

    @Override
    public FoodModel getItem(int i) {
        return mListFood.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mListFood.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = mLayoutInflater.inflate(R.layout.item_grid_food, null);
        KenBurnsView imageFood = view.findViewById(R.id.image_food);
        TextView textNameFood = view.findViewById(R.id.text_name_food);
        ProgressBar progressBar = view.findViewById(R.id.progres_bar);
        // prepare food data
        final FoodModel data = getItem(position);
        // image -> url -> hiển thị hình ảnh bằng url
//        DownloadImageTaskHandler newTask = new DownloadImageTaskHandler(imageFood);
//        newTask.execute(data.getURL());
        Picasso.get()
                .load(data.getURL())
                .placeholder(R.drawable.failed_image)
                .error(R.drawable.failed_image)
                .into(imageFood, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        progressBar.setVisibility(View.GONE);
                    }
                });

        //
        textNameFood.setText(data.getTitle());
        return view;
    }
}
