package com.example.vadim.owntimetable.models;

/**
 * Created by root on 9/22/16.
 */
public class TimeTableDayModel {
    String lesson_time;
    String lesson_name;

    public TimeTableDayModel() {}

    public TimeTableDayModel(String lesson_time, String lesson_name) {
        this.lesson_time = lesson_time;
        this.lesson_name = lesson_name;
    }

    public String getLesson_time() {
        return lesson_time;
    }

    public String getLesson_name() {
        return lesson_name;
    }
}
