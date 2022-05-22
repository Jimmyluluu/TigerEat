package com.example.tigereatapp;

import android.util.Log;

public class CheckUser {

    private String account;
    private String password;

    public CheckUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public boolean check() {
        /**
         * 驗證
         */
        if (account.contentEquals("admin") && password.contentEquals("12345")) {//user exist
            Log.i("CheckAccountAndPassword", "correct");
            Log.i("account", account);
            Log.i("password", password);
            return true;
        } else {
            Log.i("CheckAccountAndPassword", "wrong");
            Log.i("account", account);
            Log.i("password", password);
            return false;
        }
    }
}
