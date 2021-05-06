package com.mn.CONSTRUCTION.Interfaces;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET
    Call<ResponseBody> doGetData(@Url String url, @QueryMap Map<String, String> params);


    @Multipart
    @POST
    Call<ResponseBody> getResponseData(@Url String url, @PartMap Map<String,RequestBody> params);
}


