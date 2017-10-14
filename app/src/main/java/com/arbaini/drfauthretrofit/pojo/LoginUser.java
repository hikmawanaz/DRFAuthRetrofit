package com.arbaini.drfauthretrofit.pojo;
import com.google.gson.annotations.SerializedName;


/**
 * Created by xplore on 10/14/17.
 */

public class LoginUser {
    @SerializedName("username")
    public String username;
    @SerializedName("password")
    public String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
