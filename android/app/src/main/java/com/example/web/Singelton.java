package com.example.web;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class Singelton {


//    i use this class to use volley easier


    private static final Singelton ourInstance = new Singelton();
    private static RequestQueue queue;

    static Singelton getInstance() {
        return ourInstance;
    }

    public RequestQueue queue(Context context){
        if(queue==null)
            queue= Volley.newRequestQueue(context);
        return queue;
    }

}
