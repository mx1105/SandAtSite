package com.mn.CONSTRUCTION.Activity;

import android.os.Bundle;

import com.mn.CONSTRUCTION.ApiClient.CommanAPI;
import com.mn.CONSTRUCTION.ApiClient.HttpParams;
import com.mn.CONSTRUCTION.Interfaces.OnDataResponceListner;
import com.mn.CONSTRUCTION.Model.RequestParameters;
import com.mn.CONSTRUCTION.R;
import com.mn.CONSTRUCTION.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

;

public class LoginActivity extends BaseActivity implements OnDataResponceListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CommanAPI commanAPI = new CommanAPI(HttpParams.METHOD_LOGIN,this);
        List<RequestParameters> params = new ArrayList<>();
        params.add(new RequestParameters("email",""));
        if(isNetworkAvailable(this)) {
            commanAPI.postMethod(HttpParams.USER_LOGIN, params);
        }else displayShortToast(getString(R.string.Internet_required));
    }

    @Override
    public void Response(String methodName, String response, boolean isResponse) {
        switch (methodName) {
            case HttpParams.METHOD_LOGIN: {

            }
        }
    }
}