package com.example.orderf_ood.core.data.table;

import com.example.orderf_ood.core.data.model.UserModel;

//dat ten bang: tenbang_table
//dinh nghia cac column trong bang
public class UserTable {
    //s o dau ten bien la viet tat cua static
    public static String sTableName = "user_table";

    private static String mColumnId= "id";
    private static String mColumnUserName= "user_name";
    private static String mColumnPassword= "password";
    private static String mColumnEmail= "email";

    private static final String CREATE_TABLE  ="CREATE_TABLE"+TABLE_NAME+
            "("+UID+"INTERGER";
    private static String CreateTable(){
        return "CREATE TABLE"+sTableName+
                "("+mColumnId+ "INTERGER PRIMARY KEY AUTOINCREMENT,"
                +mColumnUserName +"VACHAR225,"
                +mColumnPassword +"VACHAR225,"
                +mColumnPassword +"VACHAR225));";


    //contentValue
    }
}
