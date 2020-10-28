package com.aspire.training.functional.threading;

import java.util.concurrent.CountDownLatch;

public class SimpleCounter {


    private int count;
    private static int staticCounter = 0;

    //    public synchronized void inc(){
//        count++;
//    }
    public void inc() {
        synchronized (this) {
//        synchronized (SimpleCounter.class) {
            count++;
        }
        //another operations that doesn't need any synch
        //write additional code
        System.out.println("print this");
        //call another long method
    }

    public synchronized void dec() {
        count--;
    }

    public synchronized static void incStatic() {
        staticCounter++;
    }

    public static void incStaticBlock() {
        synchronized (SimpleCounter.class) {
            staticCounter++;
        }
    }

    public void incAndDec() {
        inc();
        dec();
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleCounter simpleCounter = new SimpleCounter();
//        for (int i = 0; i < 2; i++) {
//            simpleCounter.inc();
//            simpleCounter.dec();
//        }
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    simpleCounter.inc();
                    simpleCounter.dec();
//                    simpleCounter.incAndDec();
                    if (simpleCounter.count != 0) {
                        System.out.println("Strange..it should be zero");
                    }
                }
                countDownLatch.countDown();

            }).start();
        }


        countDownLatch.await();
        System.out.println("simpleCounter.count = " + simpleCounter.count);
    }
}
