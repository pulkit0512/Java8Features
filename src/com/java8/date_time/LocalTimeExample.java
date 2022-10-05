package com.java8.date_time;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime: " + localTime);

        LocalTime localTime1 = LocalTime.of(22, 10);
        System.out.println("LocalTime of hour, minute: " + localTime1);

        LocalTime localTime2 = LocalTime.of(22, 13, 2);
        System.out.println("LocalTime of hour, minute, seconds: " + localTime2);

        LocalTime localTime3 = LocalTime.of(22, 1,15,4535);
        System.out.println("LocalTime of hour, minute, seconds, nanoOfSecond: " + localTime3);

        /*
        Getting values from LocalTime
         */
        // All these return new LocalTime instance, Since LocalTime is immutable
        System.out.println("getHour: " + localTime.getHour());
        System.out.println("getSecond: " + localTime.getSecond());
        //localTime.getHour() and localTime.get(ChronoField.HOUR_OF_DAY) returns same result.
        System.out.println("ChronoField.HOUR_OF_DAY: " + localTime.get(ChronoField.HOUR_OF_DAY));
        System.out.println("toSecondOfDay: " + localTime.toSecondOfDay());

        /*
        Modifying LocalTime
         */
        System.out.println("Minus Hours: " + localTime.minusHours(2));
        System.out.println("Minus Hours using ChronoUnit: " + localTime.minus(2, ChronoUnit.HOURS));
        System.out.println("Modify LocalTime using with: " + localTime.with(LocalTime.MIDNIGHT));
        System.out.println("Modify using ChronoUnit: " + localTime.with(ChronoField.HOUR_OF_DAY, 22));
        System.out.println("Plus Hours: " + localTime.plusHours(2));
        System.out.println("Plus: " + localTime.plus(2, ChronoUnit.MINUTES));
        System.out.println("withHour: " + localTime.withHour(22));
    }
}
