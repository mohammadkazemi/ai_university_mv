package com.example.web;

import com.android.volley.VolleyError;

public interface WebConsumer<T> {

//    call back request response

    void success(T t);
    void error(VolleyError error);
}
