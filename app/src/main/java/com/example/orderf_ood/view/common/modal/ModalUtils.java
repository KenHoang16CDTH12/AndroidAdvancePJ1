package com.example.orderf_ood.view.common.modal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;

import com.example.orderf_ood.R;
import com.google.android.material.button.MaterialButton;
import com.hbb20.CountryPickerView;

public class ModalUtils {
    public static void showDialogPlaceOrder(Activity activity) {
        // create alert dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        // rigister view
        LayoutInflater inflater = activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_place_order,null);

        //set view to dialog
        dialogBuilder.setView(dialogView);
        CountryPickerView countryPicker = dialogView.findViewById(R.id.country_picker);
        EditText commentText = dialogView.findViewById(R.id.place_order_comment);
        RadioButton radioButton = dialogView.findViewById(R.id.ship_to_this_address_button);
        RadioButton shipToThisAddressRadioButton = dialogView.findViewById(R.id.ship_to_this_address_button);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}
