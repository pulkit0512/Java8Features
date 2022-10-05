package com.java8.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeExample {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime: " + localDateTime);

        LocalDateTime localDateTime1 =
                LocalDateTime.of(2023, Month.DECEMBER,5,12,8,0,12);
        System.out.println("LocalDateTime using of: " + localDateTime1);

        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("LocalDateTime using LocalDate and LocalTime: " + localDateTime2);

        /*
        Getting Date and Time from DataTime Instance
         */

        System.out.println("getMinute: " + localDateTime.getMinute());
        System.out.println("getDay: " + localDateTime1.getDayOfMonth());
        System.out.println("getHour: " + localDateTime.get(ChronoField.HOUR_OF_DAY));

        /*
        Modifying LocalDateTime
         */
        //All these return new instance of LocalDateTime, since this is Final class hence immutable.
        System.out.println("plusDays: " + localDateTime.plusDays(3));
        System.out.println("minusDays: " + localDateTime.minusDays(1));
        System.out.println("withMonth: " + localDateTime.withMonth(12));
        System.out.println("with: " + localDateTime.with(ChronoField.DAY_OF_MONTH, 8));
        System.out.println("firstDayOfNextMonth: " + localDateTime.with(TemporalAdjusters.firstDayOfNextMonth()));

        //Converting LocalDate, LocalTime to LocalDateTime
        LocalDate localDate = LocalDate.of(2023,2,10);
        LocalDateTime localDateTimeFromLocalDate = localDate.atTime(10, 39,12);
        System.out.println("localDateTimeFromLocalDate: " + localDateTimeFromLocalDate);

        LocalTime localTime = LocalTime.of(12,58,18,20014);
        LocalDateTime localDateTimeFromLocalTime = localTime.atDate(localDate);
        System.out.println("localDateTimeFromLocalTime: " + localDateTimeFromLocalTime);

        //Converting LocalDateTime to LocalDate and LocalTime
        System.out.println("LocalDate from LocalDateTime: " + localDateTimeFromLocalTime.toLocalDate());
        System.out.println("LocalTime from LocalDateTime: " + localDateTimeFromLocalTime.toLocalTime());
    }
}
