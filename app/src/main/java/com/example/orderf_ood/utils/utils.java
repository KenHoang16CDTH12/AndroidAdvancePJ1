package com.example.orderf_ood.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class utils {
    /**
     * キーボード非表示
     */
    public static void hideSoftKeyboard(Activity activity) {
        if (null == activity) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) activity
                .getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (null != inputMethodManager) {
            View view = activity.getCurrentFocus();
            if (null != view) {
                inputMethodManager.hideSoftInputFromWindow(
                        view.getWindowToken(), 0);
            }

        }
    }
}
