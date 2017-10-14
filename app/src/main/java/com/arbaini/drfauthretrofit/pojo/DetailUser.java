package com.arbaini.drfauthretrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by xplore on 10/14/17.
 */

public class DetailUser {
    @SerializedName("token")
    @Expose
    public String token;
    @SerializedName("user")
    @Expose
    public User user;

}