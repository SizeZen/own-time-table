package com.example.vadim.owntimetable.repository;

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
    private List<TimeTableDayModel> Objects = null;
    private HtmlParser htmlParser = new HtmlParser();

    public Repository() {
        this.Update();
    }

    public List<TimeTableDayModel> getAll(){
        return this.Objects;
    }

    private void Update() {
        HttpHtmlAsyncGetter ownapi = new HttpHtmlAsyncGetter(new TimePeriod("13.09.2016", "30.09.2016"));
        try {
            String result = ownapi.execute().get();
            this.Objects = htmlParser.timeTableParser(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
