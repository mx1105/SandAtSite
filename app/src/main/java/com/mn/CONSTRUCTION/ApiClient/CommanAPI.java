package com.mn.CONSTRUCTION.ApiClient;

import android.util.Log;

import com.mn.CONSTRUCTION.Interfaces.OnDataResponceListner;
import com.mn.CONSTRUCTION.Interfaces.RetrofitService;
import com.mn.CONSTRUCTION.Model.RequestParameters;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommanAPI {
    private static final String TAG = "CommanAPI";
    String MethodName, responceData;
    public OnDataResponceListner onDataResponseListner;


    public CommanAPI(String methodName, OnDataResponceListner onDataResponseListner) {
        MethodName = methodName;
        this.onDataResponseListner = onDataResponseListner;
    }

    public void getResponse(String Url, Map<String, String> params) {
        RetrofitService apiService = RetrofitClient.getRetrofitClient(RetrofitService.class);

        Call<ResponseBody> call = apiService.doGetData(Url, params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        responceData = response.body().string();
                        Log.e(TAG, "onResponse: " + responceData);
                        onDataResponseListner.Response(MethodName, responceData, response.isSuccessful());

                    } catch (IOException e) {
                        Log.e("Exception = ", e.getMessage());
                        onDataResponseListner.Response(MethodName, responceData, response.isSuccessful());
                    }
                }
                else{
                    Log.e("Exception = ", "NotReachable");
                    onDataResponseListner.Response(MethodName, "NotReachable", false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onDataResponseListner.Response(MethodName, "Error:"+t.toString(), false);
            }
        });
    }


    public void postMethod(String url,List<RequestParameters> params){
        RetrofitService apiService = RetrofitClient.getRetrofitClient(RetrofitService.class);
        Map<String, RequestBody> map = new HashMap<>();
        for (RequestParameters parameters : params){
            map.put(parameters.Key, toRequestBody(parameters.value));
        }

        Call<ResponseBody> call = apiService.getResponseData(url, map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.body() != null) {
                    try {
                        responceData = response.body().string();
                        onDataResponseListner.Response(MethodName, responceData, response.isSuccessful());

                    } catch (IOException e) {
                        Log.e("Exception = ", e.getMessage());
                        onDataResponseListner.Response(MethodName, responceData, response.isSuccessful());
                    }
                }
                else{
                    onDataResponseListner.Response(MethodName, "NotReachable", false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onDataResponseListner.Response(MethodName, "xxx", false);
            }
        });
    }

    public static RequestBody toRequestBody (String value) {
        RequestBody body = RequestBody.create(value,MediaType.parse("text/plain"));
        return body ;
    }


//    //Only for OTP
//    public void getUnsafeResponse(String Url, Map<String, String> params) {
//
//        RetrofitService apiService = RetrofitClient.getUnsafeOkHttpClient(RetrofitService.class);
//
//        Call<ResponseBody> call = apiService.doGetData(Url, params);
//        Log.e(TAG, "URL: " + call.request().url().toString() + "...." + params);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.body() != null) {
//                    try {
//                        responceData = response.body().string();
//                        Log.e(TAG, "onResponse: " + responceData);
//                        onDataResponseListner.Response(MethodName, responceData, response.isSuccessful());
//
//                    } catch (IOException e) {
//                        Log.e("Exception = ", e.getMessage());
//                        onDataResponseListner.Response(MethodName, responceData, response.isSuccessful());
//                    }
//                }
//                else{
//                    Log.e("Exception = ", "NotReachable");
//                    onDataResponseListner.Response(MethodName, "NotReachable", false);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                onDataResponseListner.Response(MethodName, "Error:"+t.toString(), false);
//            }
//        });
//    }
}
