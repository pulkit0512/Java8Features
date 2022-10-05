package com.java8.date_time;

import java.time.*;

public class ZonedDateTimeExample {

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zonedDateTime);

        System.out.println("Zone Offset: " + zonedDateTime.getOffset());
        System.out.println("Zone Id: " + zonedDateTime.getZone());

        // Get all supported time zones in Java
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        System.out.println("No. of Available Zones: " + ZoneId.getAvailableZoneIds().size());

        //America/Chicago, CST
        //America/Detroit, EST
        //America/Los_Angeles, PST
        //America/Denver, MST

        //Using ZoneId
        System.out.println("Chicago CST: " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
        System.out.println("Detroit EST: " + ZonedDateTime.now(ZoneId.of("America/Detroit")));
        System.out.println("LosAngeles PST: " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
        System.out.println("Denver MST: " + ZonedDateTime.now(ZoneId.of("America/Denver")));

        //Using Clock
        System.out.println("ZonedDateTime using clock: " + ZonedDateTime.now(Clock.system(ZoneId.of("America/Denver"))));

        System.out.println("LocalDateTime of machine: " + LocalDateTime.now());
        System.out.println("LocalDateTime using ZoneId: " + LocalDateTime.now(ZoneId.of("America/Chicago")));
        //Represents time in UTC
        System.out.println("LocalDateTime using Clock: " + LocalDateTime.now(Clock.systemUTC()));

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("America/Detroit"));
        System.out.println("LocalDateTime using Instant and Zone: " + localDateTime);

        //Convert LocalDateTime to ZonedDateTime
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println("localDateTime2: " + localDateTime2);

        //Just adds zone info to the localDate
        ZonedDateTime zonedDateTime1 = LocalDateTime.now().atZone(ZoneId.of("Europe/Bratislava"));
        System.out.println("zonedDateTime1: " + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("Europe/Bratislava"));
        System.out.println("zonedDateTime2: " + zonedDateTime2);

        //Just adds offset to localDate
        OffsetDateTime offsetDateTime = localDateTime2.atOffset(ZoneOffset.ofHours(-6));
        System.out.println("offsetDateTime: " + offsetDateTime);
    }
}
