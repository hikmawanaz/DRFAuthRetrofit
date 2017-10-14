package com.arbaini.drfauthretrofit.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xplore on 10/14/17.
 */

public class CreateUser {

    @SerializedName("username")
    public String username;
    @SerializedName("email")
    public String email;
    @SerializedName("password1")
    public String password1;
    @SerializedName("password2")
    public String password2;
    @SerializedName("first_name")
    public String firstName;
    @SerializedName("last_name")
    public String lastName;

    public CreateUser(String username, String email, String password1,String password2, String firstName, String lastName) {
        this.username = username;
        this.password1 = password1;
        this.email = email;
        this.password2 = password2;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
