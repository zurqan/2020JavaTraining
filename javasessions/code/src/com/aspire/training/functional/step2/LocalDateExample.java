package com.aspire.training.functional.step2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {


    public static void main(String[] args) {

        LocalDate nowDate =LocalDate.now();
        System.out.println("nowDate = " + nowDate);

        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);

        LocalDateTime currentDateTime=
                LocalDateTime.now();
        System.out.println("currentDateTime = " + currentDateTime);

        DateTimeFormatter dateTimeFormatter=
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedCurrentDateTime = dateTimeFormatter.format(currentDateTime);
        System.out.println("formattedCurrentDateTime = " + formattedCurrentDateTime);

        LocalDateTime localDateTime = currentDateTime.withDayOfMonth(2)
                .withMonth(9);

        System.out.println("localDateTime = " + localDateTime);

    }
}
