package com.example.learn.lyy.androidui.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.learn.lyy.androidui.R;
import com.kelin.calendarlistview.library.CalendarHelper;
import com.kelin.calendarlistview.library.CalendarListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/10/20.
 */

public class CalendarActivity extends AppCompatActivity {

    public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat YEAR_MONTH_FORMAT = new SimpleDateFormat("yyyy年MM月");

    private CalendarListView clv_activity_calendar;
    private DayNewsListAdapter dayNewsListAdapter;
    private CalendarItemAdapter calendarItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        clv_activity_calendar = (CalendarListView) findViewById(R.id.clv_activity_calendar);

        //initCalendarListView
        dayNewsListAdapter = new DayNewsListAdapter(this);
        calendarItemAdapter = new CalendarItemAdapter(this);
        clv_activity_calendar.setCalendarListViewAdapter(calendarItemAdapter, dayNewsListAdapter);

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

        //时间被点击
        clv_activity_calendar.setOnCalendarViewItemClickListener(new CalendarListView.OnCalendarViewItemClickListener() {
            @Override
            public void onDateSelected(View View, String selectedDate, int listSection, SelectedDateRegion selectedDateRegion) {
                Toast.makeText(CalendarActivity.this, selectedDate, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
