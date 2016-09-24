package com.example.vadim.owntimetable.models;

/**
 * Created by vov96 on 24.09.2016.
 */

public class TimePeriod {
    private String beginning_of_period;
    private String end_of_period;

    public TimePeriod(String beginning_of_period, String end_of_period) {
        this.beginning_of_period = beginning_of_period;
        this.end_of_period = end_of_period;
    }

    public String getBeginning_of_period() {
        return beginning_of_period;
    }

    public String getEnd_of_period() {
        return end_of_period;
    }
}
