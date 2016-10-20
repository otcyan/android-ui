package com.example.learn.lyy.androidui.calendar.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/20.
 */

public class RetrofitManger {

    private static Retrofit mRetrofit = null;

    private RetrofitManger() {

    }

    public static Retrofit getInstance() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().baseUrl("http://news-at.zhihu.com/").
                    addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;
    }
}
