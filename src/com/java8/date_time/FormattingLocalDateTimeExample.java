package com.java8.date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateTimeExample {

    public static void parseLocalDateTime() {
        String dateTime = "2022-10-06T00:01:10";
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
        System.out.println("LocalDateTime: " + localDateTime);

        String dateTime1 = "2022-10-06T00:02:12.432";
        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime1, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("LocalDateTime1: " + localDateTime1);

        //Custom Date Time Formatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'$'HH|mm|ss");
        String dateTime2 = "2022-10-07$23|45|29";
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime2, dateFormatter);
        System.out.println("LocalDateTime2: " + localDateTime2);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy'abc'HH$mm$ss");
        String dateTime3 = "10/08/2022abc13$28$58";
        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTime3, dateTimeFormatter1);
        System.out.println("LocalDateTime3: " + localDateTime3);
    }

    public static void formatLocalDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy'T'HH$mm$ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Current Local Date Time: " + localDateTime);
        String formattedDateTime = localDateTime.format(dateTimeFormatter);
        System.out.println("Formatted Date Time: " + formattedDateTime);
    }

    public static void main(String[] args) {
        parseLocalDateTime();
        formatLocalDateTime();
    }
}
