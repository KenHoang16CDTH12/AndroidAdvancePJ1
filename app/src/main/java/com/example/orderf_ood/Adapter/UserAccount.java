package com.example.orderf_ood.Adapter;

public class UserAccount {
    private String userName;
    private String password;

    public UserAccount(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserAccount() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
