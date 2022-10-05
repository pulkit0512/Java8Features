package com.java8.date_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateToLocalDateExample {

    public static void main(String[] args) {

        System.out.println("Converting java.util.Date -> java.time.LocalDate and vice-versa");
        Date date = new Date();
        System.out.println("date: " + date);

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("localDate: " + localDate);

        Date date1 = Date.from(localDate.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("date1: " + date1);

        System.out.println("Converting java.sql.Date -> java.time.LocalDate and vice-versa");
        //converts LocalDate to sql.Date
        java.sql.Date date2 = java.sql.Date.valueOf(localDate);
        System.out.println("date2: " + date2);

        //converts sql.Date to LocalDate
        LocalDate localDate1 = date2.toLocalDate();
        System.out.println("localDate1: " + localDate1);
    }
}
