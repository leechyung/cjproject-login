package com.example.cjproject.retrofit;

import com.google.gson.annotations.SerializedName;

public class User_login {

    @SerializedName("USER_ID")
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    @SerializedName("USER_PASSWORD")
    private String user_password;

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public User_login() {

    }

    public User_login(String user_id,String user_password) {
        this.user_id = user_id;
        this.user_password = user_password;
    }

}
