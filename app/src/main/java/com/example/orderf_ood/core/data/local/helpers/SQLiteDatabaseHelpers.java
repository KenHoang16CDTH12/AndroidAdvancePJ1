package com.example.orderf_ood.core.data.local.helpers;

// tạo database
//Tạo bảng quản lý của database :userTable
//quản lý version database :insert data( viet ham xu ly)
//Query(get)data( viet ham xu ly)

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDatabaseHelpers extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "app_database";
    private static int DATABASE_VERSION = 1;

    private SQLiteDatabaseHelpers(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    //Tao bang user_table
        //ctrl shift F6: doi ten tat ca
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    //xu ly xoa bang neu bang da ton tai roi goi oncreate de tao bang moi

    }
}
