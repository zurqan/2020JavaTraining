package com.aspire.training.functional.step2;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExample {

    public static void main(String[] args) {


        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);

        ZonedDateTime austNow = now.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
        System.out.println("austNow = " + austNow);
    }
}
