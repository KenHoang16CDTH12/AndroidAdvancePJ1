package com.example.orderf_ood.core.data.local.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.orderf_ood.core.data.local.table.FoodProductTable;
import com.example.orderf_ood.core.data.local.table.UserTable;
// create database
// create table
// version database setting

public class SQLiteDatabaseHelpers extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "app_database";
    private static int DATABASE_VERSION = 1;

    private static volatile SQLiteDatabaseHelpers INSTANCE = null;

    private SQLiteDatabaseHelpers(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // public static method to retrieve the singleton instance
    public static SQLiteDatabaseHelpers getInstance(@Nullable Context context) {
        // Check if the instance is already created
        if (INSTANCE == null) {
            // synchronize the block to ensure only one thread can execute at a time
            synchronized (SQLiteDatabaseHelpers.class) {
                // check again if the instance is already created
                if (INSTANCE == null) {
                    // create the singleton instance
                    INSTANCE = new SQLiteDatabaseHelpers(context);
                }
            }
        }
        // return the singleton instance
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 1/ Tao bang UserTable
        sqLiteDatabase.execSQL(UserTable.createTableSQL());
        // 2/ Tao bang FoodProductTable
        sqLiteDatabase.execSQL(FoodProductTable.createTableSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserTable.sTableName);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FoodProductTable.sTableName);
        onCreate(sqLiteDatabase);
    }
}
