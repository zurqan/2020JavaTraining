package com.aspire.training.functional.threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LatchExample {
    private int count;
    public static void main(String[] args) throws InterruptedException {
        LatchExample obj = new LatchExample();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch startLatch = new CountDownLatch(1);
        new Thread(()->{

            try {
                System.out.println("Started But waiting");
                //initialization resources
                startLatch.await();
                System.out.println("Start Processing");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
            obj.count++;
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            try {
                System.out.println("Started But waiting");
                startLatch.await();
                System.out.println("Start Processing");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done");
            obj.count++;
            countDownLatch.countDown();
        }).start();

        Thread.sleep(5000);
        startLatch.countDown();
        countDownLatch.await(6, TimeUnit.SECONDS);
        System.out.println(obj.count);
        System.out.println("Exit");
    }
}
