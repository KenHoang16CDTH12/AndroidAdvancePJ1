package com.example.orderf_ood.view.drawerMenu;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.orderf_ood.R;


public class AddProductButtonFragment extends Fragment implements View.OnClickListener {
    private Button mAddProductButton;
    private Button mAddTestButton1;
    private Button mAddTestButton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product_button, container, false);
        mAddProductButton = view.findViewById(R.id.add_product_button);
        mAddProductButton.setOnClickListener(this);
        mAddTestButton1 = view.findViewById(R.id.test_button_1);
        mAddProductButton.setOnClickListener(this);
        mAddTestButton2 = view.findViewById(R.id.test_button_2);
        mAddProductButton.setOnClickListener(this);

        return view;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_product_button:
                ((AddProductActivity)getActivity()).replaceFragments(AddProductFragment.class);
                break;
            case R.id.test_button_1:
                //TODO:
                break;
            case R.id.test_button_2:
                break;
        }
    }
}