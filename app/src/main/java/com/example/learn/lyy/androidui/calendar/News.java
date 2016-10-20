package com.example.learn.lyy.androidui.calendar;

import java.util.List;

/**
 * Created by Administrator on 2016/10/20.
 */

public class News {
    private String date;

    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }
}
