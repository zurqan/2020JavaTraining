package com.aspire.training.functional.step2;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodAndDuration {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate future = LocalDate.of(2021, Month.DECEMBER, 12);
        Period b1 = Period.between(now, future);
        System.out.println("b1 = " + b1);

        LocalDate f1 = now.plus(1, ChronoUnit.DAYS);
        System.out.println("f1 = " + f1);

        LocalTime currentTime = LocalTime.now();
        LocalTime plus = currentTime.plus(Duration.of(1, ChronoUnit.HOURS));
        System.out.println("plus = " + plus);
        Duration between = Duration.between(currentTime, plus);
        System.out.println(between);
    }
}
