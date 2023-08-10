package com.example.orderf_ood.view.drawerMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orderf_ood.R;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.core.data.local.table.FoodProductTable;
import com.example.orderf_ood.view.login.sign_up.SignUpFragment;

public class AddProductFragment extends Fragment {
    private static final String CLASS_NAME = SignUpFragment.class.getName();
    private EditText mEditTextiD;
    private EditText mEditTextTitle;
    private EditText mEditTextDescription;
    private EditText mEditTextQuantity;
    private EditText mEditTextPrice;
    private EditText mEditTextURL;
    private Button mAddButton;
    private Button mBackButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_add_product, container, false);
        initData();
        initView(root);
        return root;
    }

    private void initView(View view) {
        mEditTextiD = view.findViewById(R.id.product_id_edittext);
        mEditTextTitle = view.findViewById(R.id.product_title_edittext);
        mEditTextDescription = view.findViewById(R.id.product_description_edittext);
        mEditTextQuantity = view.findViewById(R.id.product__equantity_edittext);
        mEditTextPrice = view.findViewById(R.id.product_price_edittext);
        mEditTextURL = view.findViewById(R.id.product_url_edittext);
        mAddButton = view.findViewById(R.id.add_button);
        mBackButton = view.findViewById(R.id.back_button);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                addToFoodTable();
                }
        });

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    private void initData() {
    }

    private void addToFoodTable(){
        int id = Integer.parseInt(mEditTextiD.getText().toString());
        String title = mEditTextTitle.getText().toString();
        String description = mEditTextDescription.getText().toString();
        int quantity = Integer.parseInt(mEditTextQuantity.getText().toString());
        int price = Integer.parseInt(mEditTextPrice.getText().toString());
        String url = mEditTextURL.getText().toString();
        Log.d("foodTableData", "id :" + id + "\ntitle: "+ title+ "\ndescription"+
                "\nquantity: " + quantity + "\nprice: " + price + "\nurl: " + url);

//        if (id == 0 || title.length() == 0 || description.length() == 0 ||
//                quantity.length() == 0 || price.length() == 0 || url.length() == 0) {
//            Toast.makeText(getContext(), "Please fill all the data", Toast.LENGTH_LONG).show();
//        } else {
            FoodModel foodModel = new FoodModel(id, title, description, quantity, price, url);
            boolean isFoodAdded = FoodProductTable.addFood(getContext(), foodModel);
            if (isFoodAdded) {
                Toast.makeText(getContext(), "Food added successfully", Toast.LENGTH_LONG).show();
                resetUIData();
            } else {
                Toast.makeText(getContext(), "Fail to add food", Toast.LENGTH_LONG).show();
            }
//        }
    }
    private void resetUIData() {
        mEditTextiD.setText("");
        mEditTextTitle.setText("");
        mEditTextDescription.setText("");
        mEditTextQuantity.setText("");
        mEditTextPrice.setText("");
        mEditTextURL.setText("");
    }
}