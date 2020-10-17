package com.aspire.training.functional.step2;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjusterExample {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime firstDay = now
                .with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDay = " + firstDay);
    }
}
