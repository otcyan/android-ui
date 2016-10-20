package com.example.learn.lyy.androidui.calendar;

/**
 * Created by Administrator on 2016/10/20.
 */

public class ExtraField {
    private boolean isHeader;
    private String date;

    public ExtraField(boolean isHeader, String date) {
        this.isHeader = isHeader;
        this.date = date;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
