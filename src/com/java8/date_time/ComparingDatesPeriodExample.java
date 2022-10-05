package com.java8.date_time;

import java.time.LocalDate;
import java.time.Period;

public class ComparingDatesPeriodExample {

    //Period is only compatible with LocalDate
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2023,1,1);
        LocalDate endDate = LocalDate.of(2023, 12,31);

        /*
        Period - Until
         */

        //endDate exclusive
        Period period = startDate.until(endDate);

        System.out.println("getDays from period: " + period.getDays()); // 31-1 = 30 days, only consider days difference
        System.out.println("getMonths from period: " + period.getMonths()); // 12-1 = 11 months, only consider months difference
        System.out.println("getYears from period: " + period.getYears()); // 2023-2023 = 0 years, only consider years difference

        Period period1 = Period.ofDays(10);
        System.out.println("getDays from period1: " + period1.getDays());

        //The resulting period will have the specified years. The months and days units will be zero.
        //Creates a period with 20 years, 0 months, 0 days
        Period period2 = Period.ofYears(20);
        System.out.println("getDays from period2: " + period2.getDays());
        System.out.println("getMonths from period2: " + period2.getMonths());
        System.out.println("toTotalMonths from period2: " + period2.toTotalMonths());
        System.out.println("getYears from period2: " + period2.getYears());

        // startDate inclusive, endDate exclusive
        // Works same as LocalDate.until()
        // Period.between() also calls LocalDate.until()
        Period period3 = Period.between(startDate, endDate);
        System.out.println("getDays from period3: " + period3.getDays());
        System.out.println("getMonths from period3: " + period3.getMonths());
        System.out.println("getYears from period3: " + period3.getYears());
    }
}
