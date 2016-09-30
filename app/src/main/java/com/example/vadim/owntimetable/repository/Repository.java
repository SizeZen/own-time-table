package com.example.vadim.owntimetable.repository;

import android.util.Log;

import com.example.vadim.owntimetable.HttpHtmlAsyncGetter;
import com.example.vadim.owntimetable.models.TimePeriod;
import com.example.vadim.owntimetable.models.TimeTableDayModel;
import com.example.vadim.owntimetable.parser.HtmlParser;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by root on 9/22/16.
 */
public class Repository {
    private List<TimeTableDayModel> listTimeTableDay;
    private HtmlParser htmlParser = new HtmlParser();

    public List<TimeTableDayModel> getListTimeTableDay(TimePeriod period) {
        HttpHtmlAsyncGetter ownapi = new HttpHtmlAsyncGetter(period);
        try {
            String result = ownapi.execute().get();
            listTimeTableDay = htmlParser.timeTableParser(result);
            Log.v("result", String.valueOf(listTimeTableDay.get(0).getLesson_name()));
            return listTimeTableDay;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


}
