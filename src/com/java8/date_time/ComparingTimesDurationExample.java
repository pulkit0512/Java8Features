package com.java8.date_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class ComparingTimesDurationExample {

    //Compatible with LocalTime and LocalDateTime
    public static void main(String[] args) {

        LocalTime startTime = LocalTime.of(9,50);
        LocalTime endTime = LocalTime.of(10,55);

        // endTime exclusive
        long minuteDiff = startTime.until(endTime, ChronoUnit.MINUTES);
        System.out.println("minuteDiff: " + minuteDiff);

        Duration duration = Duration.ofHours(3);
        System.out.println("seconds: " + duration.toSeconds());

        // endTime exclusive
        Duration duration1 = Duration.between(startTime, endTime);
        System.out.println("Hours: " + duration1.toHours());

        Duration duration2 = Duration.ofMinutes(3);
        System.out.println("millis: " + duration2.toMillis());

        //LocalDateTime
        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.of(2022, Month.DECEMBER, 31,23,59,59);
        Duration duration3 = Duration.between(startDateTime, endDateTime);
        System.out.println("toDays: " + duration3.toDays());

        //LocalDate not supported
        //Below line gives runtime exception, of type UnsupportedTemporalTypeException
        //Duration duration4 = Duration.between(LocalDate.now(), LocalDate.now().plusDays(20));
    }
}
