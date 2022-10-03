package com.java8.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class NewDateTimeExample {

    public static void main(String[] args) {
        //Local Date : implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        //Local Time : implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime: " + localTime);

        //Local Date Time : implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate>, Serializable
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);
    }
}
