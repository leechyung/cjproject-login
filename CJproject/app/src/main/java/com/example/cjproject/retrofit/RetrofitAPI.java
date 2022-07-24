package com.example.cjproject.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("/user/getUser")
    Call<com.example.cjproject.retrofit.JsonResponse>getUser();

    @Headers({"Content-Type: application/json"})
    @POST("/user/login")
    Call <User_login> LoginUser(@Body User_login data);

    @Headers({"Content-Type: application/json"})
    @POST("/user/registerUser")
    Call <User_Request> registerUser(@Body User_Request data);
}
