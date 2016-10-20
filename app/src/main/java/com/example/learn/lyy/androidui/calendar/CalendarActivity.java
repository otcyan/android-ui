package com.example.learn.lyy.androidui.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.learn.lyy.androidui.NewsService;
import com.example.learn.lyy.androidui.R;
import com.example.learn.lyy.androidui.calendar.net.RetrofitManger;
import com.kelin.calendarlistview.library.CalendarHelper;
import com.kelin.calendarlistview.library.CalendarListView;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import rx.Notification;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/10/20.
 */

public class CalendarActivity extends RxAppCompatActivity {

    public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat YEAR_MONTH_FORMAT = new SimpleDateFormat("yyyy年MM月");

    private CalendarListView clv_activity_calendar;
    private DayNewsListAdapter dayNewsListAdapter;
    private CalendarItemAdapter calendarItemAdapter;
    private Observable<Notification<News>> newsListOb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        clv_activity_calendar = (CalendarListView) findViewById(R.id.clv_activity_calendar);

        //initCalendarListView
        dayNewsListAdapter = new DayNewsListAdapter(this);
        calendarItemAdapter = new CalendarItemAdapter(this);
        clv_activity_calendar.setCalendarListViewAdapter(calendarItemAdapter, dayNewsListAdapter);

        //initData
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -6);

        //format(calendar.getTime()) 20160420
        loadNewsList(DAY_FORMAT.format(calendar.getTime()));

        //月份改变
        clv_activity_calendar.setOnMonthChangedListener(new CalendarListView.OnMonthChangedListener() {
            @Override
            public void onMonthChanged(String yearMonth) {
                Calendar calendar = CalendarHelper.getCalendarByYearMonth(yearMonth);
//                actionBar.setTitle(YEAR_MONTH_FORMAT.format(calendar.getTime()));
//                loadCalendarData(yearMonth);
                Toast.makeText(CalendarActivity.this, YEAR_MONTH_FORMAT.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        });

        //日期被点击
        clv_activity_calendar.setOnCalendarViewItemClickListener(new CalendarListView.OnCalendarViewItemClickListener() {
            @Override
            public void onDateSelected(View View, String selectedDate, int listSection, SelectedDateRegion selectedDateRegion) {
                Toast.makeText(CalendarActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //加载数据
    private void loadNewsList(String date) {
        //calendar.getTime() : Wed Apr 20 00:00:00 EDT 2016
        Calendar calendar = getCalendarByYearMonthDay(date);
        //key 2016-04
        String key = CalendarHelper.YEAR_MONTH_FORMAT.format(calendar.getTime());

        // just not care about how data to create.
        Random random = new Random();
        final List<String> set = new ArrayList<>();
        while (set.size() < 5) {
            int i = random.nextInt(29);
            if (i > 0) {
                if (!set.contains(key + "-" + i)) {
                    if (i < 10) {
                        set.add(key + "-0" + i);
                    } else {
                        set.add(key + "-" + i);
                    }
                }
            }
        }

//        Observable<Notification<News>> newsListOb =  RetrofitManger.getInstance().create(NewsService.class).getNewsList(date)
//                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).compose(bindToLifecycle()).materialize().share();

    }

    public static Calendar getCalendarByYearMonthDay(String yearMonthDay) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(DAY_FORMAT.parse(yearMonthDay).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }
}
