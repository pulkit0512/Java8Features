package com.java8.date_time;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {

    public static void main(String[] args) {
        Instant instant = Instant.now(); // Represents the date and time in unix timestamp in a machine-readable format.
        System.out.println("Print Instant in readable format: " + instant);

        // What is EPOCH ? -> equal to Jan. 1st 1970, 1 day == 86400 seconds
        // Number of seconds from 0 second of 1st Jan 1970 to current second
        System.out.println("Current Epoch value: " + instant.getEpochSecond());

        Instant instant1 = Instant.ofEpochSecond(0);
        System.out.println("instant1: " + instant1);

        Instant instant2 = Instant.now();
        Duration duration = Duration.between(instant, instant2);
        System.out.println("Nano duration difference: " + duration.getNano());
    }
}
