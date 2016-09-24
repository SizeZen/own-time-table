package com.example.vadim.owntimetable.parser;

import com.example.vadim.owntimetable.models.TimeTableDayModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by root on 9/22/16.
 */
public class HtmlParser {

    public ArrayList<TimeTableDayModel> timeTableParser(String html) {
        ArrayList<TimeTableDayModel> timeTables = new ArrayList<>();

        Elements tempDoc = Jsoup.parse(html).select(".container .container .col-md-6");
        for (Element tables: tempDoc) {
            Elements table = tables.select("tr");
            for (Element row: table) {
                Elements td = row.children();
                timeTables.add(new TimeTableDayModel(td.get(0).text(), td.get(1).text()));
            }
        }

        return timeTables;
    }
}
