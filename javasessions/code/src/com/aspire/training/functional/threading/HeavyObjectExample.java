package com.aspire.training.functional.threading;

import java.util.concurrent.CountDownLatch;

public class HeavyObjectExample {

    private HeavyObj heavyObj = null;

    public HeavyObj instance() {
        if (heavyObj == null) {
            heavyObj = new HeavyObj();
        }
        return heavyObj;
    }

    public static void main(String[] args) throws InterruptedException {
        HeavyObjectExample obj = new HeavyObjectExample();
//        obj.instance();
//        obj.instance();
//        obj.instance();
//        obj.instance();
        CountDownLatch countDownLatch = new CountDownLatch(5000);
        for (int i = 0; i < 5000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {

                    obj.instance();
                }

                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
    }

}
