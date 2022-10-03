package com.java8.date_time;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate: " + localDate);

        LocalDate localDate1 = LocalDate.of(2022, Month.DECEMBER, 5);
        System.out.println("LocalDate1: " + localDate1);

        LocalDate localDate2 = LocalDate.ofYearDay(2022, 354);
        System.out.println("LocalDate2: " + localDate2);

        /*
        Get values from Local Date
         */

        System.out.println("getDayOfWeek: " + localDate.getDayOfWeek());
        System.out.println("getMonth: " + localDate.getMonth());
        System.out.println("getMonthValue: " + localDate.getMonthValue());
        System.out.println("getDayOfYear: " + localDate.getDayOfYear());
        System.out.println("Day of month using get: " + localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("getDayOfMonth: " + localDate.getDayOfMonth());

        /*
        Modifying Local Date
         */
        // All these return a new LocalDate since LocalDate objects are immutable.
        System.out.println("plusDays: " + localDate.plusDays(2));
        System.out.println("plusMonths: " + localDate.plusMonths(2));
        System.out.println("minusDays: " + localDate.minusDays(3));
        System.out.println("withYear: " + localDate.withYear(2024));
        System.out.println("with ChronoField: " + localDate.with(ChronoField.YEAR, 2023));
        System.out.println("with TemporalAdjusters: " + localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        // For many methods we have alternate approach, ultimately it gives same result.
        System.out.println("minusYears: " + localDate.minusYears(1));
        System.out.println("ChronoUnit Minus: " + localDate.minus(1, ChronoUnit.YEARS));

        /*
        Additional Support Methods
         */

        System.out.println("2022 isLeapYear: " + localDate.isLeapYear());
        System.out.println("2024 isLeapYear: " + localDate.withYear(2024).isLeapYear());

        //LocalDate: 2022-10-04
        //LocalDate1: 2022-12-05
        //LocalDate2: 2022-12-20
        System.out.println("isEqual: " + localDate.isEqual(localDate1));
        System.out.println("isBefore: " + localDate.isBefore(localDate1));
        System.out.println("isAfter: " + localDate2.isAfter(localDate));

        /*
        Unsupported Method
         */

        //It gives error, since we can't delete minutes from date
        //System.out.println("ChronoUnit Minus: " + localDate.minus(1, ChronoUnit.MINUTES));

        //To verify if a method is supported or not we can use isSupported
        System.out.println("ChronoUnit.MINUTES isSupported: " + localDate.isSupported(ChronoUnit.MINUTES));
        System.out.println("ChronoUnit.DAYS isSupported: " + localDate.isSupported(ChronoUnit.DAYS));
    }
}
