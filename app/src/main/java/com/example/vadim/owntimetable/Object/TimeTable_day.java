package com.example.vadim.owntimetable.Object;

/**
 * Created by vov96 on 12.09.2016.
 */
public class TimeTable_day {
    String lesson_time;
    String lesson_name;

    public TimeTable_day(String lesson_time, String lesson_name) {
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
