package com.java8.date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormattingLocalDateExample {

    // Input string should match the DateTimeFormatter else it will give DateTimeParseException
    // If we are not sure that every time string will have same format we should handle above exception in code
    // We can't use #, {, } in DateTimeFormatter context since these are reserved for future use.
    public static void parseLocalDate() {
        //Converts String -> LocalDate
        String date = "2022-10-08";
        //by default, it uses DateTimeFormatter.ISO_LOCAL_DATE
        LocalDate localDate = LocalDate.parse(date);
        System.out.println("localDate: " + localDate);

        // We can specify the predefined formatter also as per our need.
        LocalDate localDate1 = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate1: " + localDate1);

        String date2 = "20221008";
        LocalDate localDate2 = LocalDate.parse(date2, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDate2: " + localDate2);

        //Custom DateTimeFormatter
        String date3 = "2022|12|05";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate3 = LocalDate.parse(date3, dateTimeFormatter);
        System.out.println("localDate3: " + localDate3);

        String date4 = "10*12*2022";
        //If we want to use '#' in our formatter then we will get IllegalArgumentException, since it is reserved.
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("dd*MM*yyyy");
        LocalDate localDate4 = LocalDate.parse(date4, dateTimeFormatter1);
        System.out.println("localDate4: " + localDate4);
    }

    public static void formatLocalDate() {
        //Converts LocalDate -> String
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate localDate = LocalDate.now();
        String formattedDate = localDate.format(dateTimeFormatter);
        System.out.println("formattedDate: " + formattedDate);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MMM/dd/yyyy");
        LocalDate localDate1 = LocalDate.now();
        String formattedDate1 = localDate1.format(dateTimeFormatter1);
        System.out.println("formattedDate1: " + formattedDate1);
    }

    public static void main(String[] args) {
        parseLocalDate();
        formatLocalDate();
    }
}
