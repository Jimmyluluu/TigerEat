package com.example.tigereatapp;

public class User {

    private UserState userState = UserState.ILLEGAL_USER;
    private int userId;
    private String account;
    private String phone;
    private String password;
    private String address;
    private String nickName;

    public User(int userId, String account, String phone, String password, String address, String nickName) {
        this.userId = userId;
        this.account = account;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.nickName = nickName;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
