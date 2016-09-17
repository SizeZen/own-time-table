package com.example.vadim.owntimetable;

import android.util.Log;

import com.example.vadim.owntimetable.Object.TimeTable_day;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vov96 on 12.09.2016.
 */

class HtmlParser {
    Document doc;

    public HtmlParser(Document doc) {
        this.doc = doc;
    }

    public String getTimeTable() {
        Document tempDoc = Jsoup.parse(doc.body().getElementsByClass("col-md-6").toString());

        Log.v("<h1>",tempDoc.body().getElementsByTag("h4").text()); // All Day
        Log.v("tableRow", tempDoc.body().getElementsByTag("table").text()); // All Lessons with date

        return tempDoc.body().getElementsByTag("table").text();
        // examples
        // 08:00-09:20 128 Гладка О.М. Системне програмне забезпечення (Лаб) 09:40-11:00 11:15-12:35
    }
}

public class CreateListLessons {
    List<TimeTable_day> timeTableDays = new ArrayList<>();
    String lessons;

    public CreateListLessons(String lessons) {
        this.lessons = lessons;
    }

    List<TimeTable_day> mainCreateList(){
        getFormatText();

        return pushToList(getFormatText());
    }

    private List<TimeTable_day> pushToList(String[] formatText) {
        for (String lesson : formatText){
            if (lesson.trim().length() < 12) {
                timeTableDays.add(new TimeTable_day(lesson, ""));
            } else {
                System.out.println("writeLessonName-- "+ writeLessonName(lesson));
                timeTableDays.add(new TimeTable_day(writeDate(lesson), writeLessonName(lesson)));
            }
        }
        return timeTableDays;
    }

    private static String writeLessonName(String lesson) {

        char[] lessonName = lesson.toCharArray();
        String lessonString = "";

        for (int i = 12; i<lessonName.length; i++){
            lessonString +=  lessonName[i];
        }
        return lessonString;
    }



    private static String writeDate(String lesson) {
        char[] date = lesson.toCharArray();
        String dataString = "";

        for (int i =0; i<11; i++){
            dataString +=  date[i];
        }
        return dataString;
    }

    private String[] getFormatText() {
        String[] secondArr = lessons.split(" ");
        String formatedText = "";
        String[] formatedTextArr;
        for (int i = 0; i < secondArr.length; i++) {
            //System.out.print(secondArr[i] + " ");
            formatedText += secondArr[i] + " " ;
            if (i + 1 == secondArr.length) {
                formatedTextArr = formatedText.split("\n");
                System.out.println(Arrays.toString(formatedTextArr));
                return formatedTextArr;

            }
            try {
                if (secondArr[i + 1].toCharArray()[2] == ':') {
                    //System.out.println();
                    formatedText += "\n" ;
                }
            } catch (Exception ignored){}
        }
        return null;
    }
}
