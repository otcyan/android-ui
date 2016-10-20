package com.example.learn.lyy.androidui;

import com.example.learn.lyy.androidui.calendar.News;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/20.
 */

public interface NewsService {
    @GET("/api/4/news/before/{date}")
    public Observable<News> getNewsList(@Path("date") String date);
}
