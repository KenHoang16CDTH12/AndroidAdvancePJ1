package com.example.orderf_ood.core.data.local.table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderf_ood.core.data.local.helpers.SQLiteDatabaseHelpers;
import com.example.orderf_ood.core.data.local.model.FoodModel;
import com.example.orderf_ood.core.data.local.model.UserModel;

import java.util.ArrayList;

public class FoodProductTable {
    public static String sTableName = "foods_table";

    private static String mColumnId = "id";
    private static String mColumnNameFood = "food_name";
    private static String mColumnDescription = "description";
    private static String mColumnQuantity = "quantity";
    private static String mColumnPrice = "price";
    private static String mColumnUrl = "url";

    public static String createTableSQL() {
        return "CREATE TABLE " + sTableName +
                "(" + mColumnId + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mColumnNameFood + " VARCHAR(255), "
                + mColumnDescription + " TEXT, "
                + mColumnQuantity + " INTEGER,"
                + mColumnPrice + " INTEGER,"
                + mColumnUrl + " TEXT"
                + ");";
    }

    public static boolean addFood(Context context, FoodModel foodModel){
        final SQLiteDatabase db = SQLiteDatabaseHelpers.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mColumnId, foodModel.getId());
        values.put(mColumnNameFood, foodModel.getTitle());
        values.put(mColumnDescription, foodModel.getDescription());
        values.put(mColumnQuantity, foodModel.getQuantity());
        values.put(mColumnPrice, foodModel.getPrice());
        values.put(mColumnUrl, foodModel.getUrl());
        long result = db.insert(sTableName, null, values);
        db.close();
        return result > -1;
    }

    public static ArrayList<FoodModel> getFoods(Context context) {
        final SQLiteDatabase db = SQLiteDatabaseHelpers.getInstance(context).getReadableDatabase();
        ArrayList<FoodModel> foods = new ArrayList<>();
        // Truy van SQLite
        Cursor cursor = db.query(sTableName, null, null, null,null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                final FoodModel foodModel = new FoodModel(cursor.getInt(0), cursor.getString(1),
                        cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getString(5));
                foods.add(foodModel);
                cursor.moveToNext();
            }
        }
        db.close();
        return foods;
    }

}
