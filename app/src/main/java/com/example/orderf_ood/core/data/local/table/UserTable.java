package com.example.orderf_ood.core.data.local.table;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orderf_ood.core.data.local.helpers.SQLiteDatabaseHelpers;
import com.example.orderf_ood.core.data.local.model.UserModel;

import java.util.ArrayList;

/// SQLite command line
// 1/ Đặt tên bảng. -> DONE
// 2/ Định nghĩa các column trong bảng -> DONE
// 3/ Insert data (viết hàm xử lý). -> DONE
// 4/ Query(get) data (viết hàm xử lý). -> DONE
public class UserTable {
    public static String sTableName = "users_table";

    private static String mColumnId = "id";
    private static String mColumnUserName = "username";
    private static String mColumnPassword = "password";
    private static String mColumnEmail = "email";

    public static String createTableSQL() {
        return "CREATE TABLE " + sTableName +
                "(" + mColumnId + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mColumnUserName + " VARCHAR(255), "
                + mColumnPassword + " VARCHAR(255), "
                + mColumnEmail + " VARCHAR(255));";
    }

    public static boolean insertUser(Context context, UserModel userModel) {
        final SQLiteDatabase db = SQLiteDatabaseHelpers.getInstance(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(mColumnUserName, userModel.getUserName());
        values.put(mColumnPassword, userModel.getPassword());
        values.put(mColumnEmail, userModel.getEmail());
        long result = db.insert(sTableName, null, values);
        db.close();
        return result > -1;
    }

    public static ArrayList<UserModel> getAllUser(Context context) {
        final SQLiteDatabase db = SQLiteDatabaseHelpers.getInstance(context).getReadableDatabase();
        ArrayList<UserModel> users = new ArrayList<>();
        // Truy van SQLite
        Cursor cursor = db.query(sTableName, null, null, null,null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                final UserModel userModel = new UserModel(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                users.add(userModel);
                cursor.moveToNext();
            }
        }
        db.close();
        return users;
    }
}
