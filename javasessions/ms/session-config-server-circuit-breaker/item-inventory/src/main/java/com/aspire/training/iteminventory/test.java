package com.aspire.training.iteminventory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class test {

    public static void main(String[] args) {
        double v = BigDecimal.valueOf(3.01).setScale(3, RoundingMode.HALF_UP).doubleValue();

        String format = String.format("%.3f", 3.11152);
        System.out.println("v = " + v);
        System.out.println("format = " + format);
    }
}
