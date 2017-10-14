package com.arbaini.drfauthretrofit;
import com.arbaini.drfauthretrofit.pojo.CreateUser;
import com.arbaini.drfauthretrofit.pojo.DetailUser;
import com.arbaini.drfauthretrofit.pojo.LoginUser;
import com.arbaini.drfauthretrofit.pojo.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
/**
 * Created by xplore on 10/14/17.
 */

public interface APIInterface {

    @POST("/rest-auth/login/")
    Call<DetailUser> loginUser(@Body LoginUser user);
    @POST("/rest-auth/registration/")
    Call<DetailUser> createUser(@Body CreateUser createUser);

}
