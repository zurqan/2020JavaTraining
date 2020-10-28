package com.aspire.training.functional.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AnotherCounterThreadSafe {

    private AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        AnotherCounterThreadSafe obj = new AnotherCounterThreadSafe();
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {

                    obj.counter.incrementAndGet();

                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("obj.counter = " + obj.counter);
    }
}
