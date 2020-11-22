package com.example.web;//package com.example.web;


import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.models.CreateUserResponseModel;
import com.example.models.CreateVoteResponseModel;
import com.example.models.LoginResponseModel;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WebService {

        private final String BASE_URL                         = "http://85.208.184.49:1399";
//    private final String BASE_URL = "http://localhost:8000";
    private final String LOGIN_URL = "/login/";
    private final String CREATE_USER_URL = "/user/";


    public static WebService getInstance() {
        return new WebService();
    }

    public void postLoginData(Map<String, String> params, Context context, WebConsumer<LoginResponseModel> callBack) {
        String url = BASE_URL + LOGIN_URL;
        JSONObject object = new JSONObject(params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object,
                response -> {
                    LoginResponseModel map = new Gson().fromJson(response.toString(), LoginResponseModel.class);
                    callBack.success(map);
                }, error -> {

            if (error.networkResponse != null) {
                Toast.makeText(context, error.networkResponse.statusCode + "", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }
        };
        Singelton.getInstance().queue(context).add(request);
    }

    public void postSignUpData(Map<String, String> params, Context context, WebConsumer<CreateUserResponseModel> callBack) {
        String url = BASE_URL + CREATE_USER_URL;
        JSONObject object = new JSONObject(params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object,
                response -> {
                    CreateUserResponseModel map = new Gson().fromJson(response.toString(), CreateUserResponseModel.class);
                    callBack.success(map);
                }, error -> {
            if (error.networkResponse != null) {
                Toast.makeText(context, error.networkResponse.statusCode + "", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }
        };
        Singelton.getInstance().queue(context).add(request);
    }

    public void postVoteData(Map<String, String> params,String userId, Context context, WebConsumer<CreateVoteResponseModel> callBack) {
        String url = BASE_URL + "/user/" + userId + "/"+"votes/";
        JSONObject object = new JSONObject(params);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, object,
                response -> {
                    CreateVoteResponseModel map = new Gson().fromJson(response.toString(), CreateVoteResponseModel.class);
                    callBack.success(map);
                }, error -> {


            if (error.networkResponse != null) {
                Toast.makeText(context, error.networkResponse.statusCode + "", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                return super.parseNetworkResponse(response);
            }
        };
        Singelton.getInstance().queue(context).add(request);
    }


}