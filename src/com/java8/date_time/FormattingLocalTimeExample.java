package com.java8.date_time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalTimeExample {

    public static void parseTime() {
        String time = "14:54";
        LocalTime localTime = LocalTime.parse(time);
        System.out.println("localTime: " + localTime);

        String time1 = "14:54:13.104";
        LocalTime localTime1 = LocalTime.parse(time1, DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("localTime1: " + localTime1);

        //Custom DateTimeFormatter
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH$mm");
        String time2 = "23$43";
        LocalTime localTime2 = LocalTime.parse(time2, dateTimeFormatter);
        System.out.println("localTime2: " + localTime2);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH$mm&ss");
        String time3 = "23$44&13";
        LocalTime localTime3 = LocalTime.parse(time3, dateTimeFormatter1);
        System.out.println("localTime3: " + localTime3);
    }

    public static void formatTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH$mm$ss");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("HH|mm|ss");
        LocalTime localTime = LocalTime.now();
        System.out.println("Current LocalTime: " + localTime);
        String formattedTime = localTime.format(dateTimeFormatter);
        System.out.println("Formatted Time: " + formattedTime);
        String formattedTime1 = localTime.format(dateTimeFormatter1);
        System.out.println("Formatted Time1: " + formattedTime1);
    }

    public static void main(String[] args) {
        parseTime();
        formatTime();
    }
}
