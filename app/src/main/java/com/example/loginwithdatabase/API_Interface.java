package com.example.loginwithdatabase;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API_Interface {
    @FormUrlEncoded
    @POST("bhojon23_latest/V1/sign_in")
    Call <Model_Class_DataPassing> getDATA(@Field("email") String email, @Field("password") String password);
}
