package com.aspire.training.functional.threading;

import java.util.concurrent.CountDownLatch;

public class CheckAndActionExample {

    volatile boolean flag;
//    private boolean flag;
    private int value=0;

//    public  boolean getFlag(){
//        return flag;
//    }

//    public synchronized boolean getFlag(){
//        return flag;
//    }

    public static void main(String[] args) throws InterruptedException {
        CheckAndActionExample obj = new CheckAndActionExample();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(()->{
            while (!obj.flag){
                ;
            }
            System.out.println("obj.value = " + obj.value);
            countDownLatch.countDown();
        }).start();

        Thread.sleep(1000);
        System.out.println("Now Change The value");
        obj.flag=true;
        obj.value=4;
        countDownLatch.await();


    }
}
