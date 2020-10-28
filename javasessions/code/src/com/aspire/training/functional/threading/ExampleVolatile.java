package com.aspire.training.functional.threading;

import java.util.concurrent.CountDownLatch;

public class ExampleVolatile {

//     private int count;
    volatile private int count;

    public static void main(String[] args) throws InterruptedException {
        ExampleVolatile exampleVolatile = new ExampleVolatile();

        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {

                    exampleVolatile.count++;
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println(exampleVolatile.count);
    }
}
