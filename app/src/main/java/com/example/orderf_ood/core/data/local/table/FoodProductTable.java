package com.example.orderf_ood.core.data.local.table;

public class FoodProductTable {
    public static String sTableName = "foods_table";

    private static String mColumnId = "id";
    private static String mColumnNameFood = "food_name";
    private static String mColumnDescription = "description";
    private static String mColumnQuantity = "quantity";
    private static String mColumnPrice = "price";

    public static String createTableSQL() {
        return "CREATE TABLE " + sTableName +
                "(" + mColumnId + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mColumnNameFood + " VARCHAR(255), "
                + mColumnDescription + " TEXT, "
                + mColumnQuantity + " INTEGER,"
                + mColumnPrice + " INTEGER"
                + ");";
    }
}
