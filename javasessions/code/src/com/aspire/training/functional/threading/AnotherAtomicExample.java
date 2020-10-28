package com.aspire.training.functional.threading;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AnotherAtomicExample {

    private AtomicInteger number = new AtomicInteger(0);
    private AtomicReference<Integer[]> array =
            new AtomicReference<>(new Integer[10]);

    public void fill(int i) {
        number.set(i);
        Integer[] _tempArray = new Integer[10];
        Arrays.fill(_tempArray, i);
        array.set(_tempArray);
//        int lastNumber = number.get();
//        Integer[] lastArray = array.get();
//        if(lastArray[0]!=lastNumber){
//            System.out.printf( "It is not the same number is %d while array " +
//                    "filled with %d \n",lastNumber,lastArray[0]);
//        }
    }

    //    public synchronized AtomicInteger getNumber(){
//        return number;
//    }
//
//    public synchronized AtomicReference<Integer[]> getArray(){
//        return array;
//    }
    public static void main(String[] args) throws InterruptedException {
        AnotherAtomicExample obj = new AnotherAtomicExample();

        CountDownLatch countDownLatch = new CountDownLatch(1000);

        for (int i = 0; i < 1000; i++) {
            int f = i;
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (obj) {
                        obj.fill(f);
                        int lastNumber = obj.number.get();
                        Integer[] lastArray = obj.array.get();
                        if (lastArray[0] != lastNumber) {
                            System.out.printf("It is not the same number is %d while array " +
                                    "filled with %d \n", lastNumber, lastArray[0]);
                        }
                    }
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        //do another operation
    }
}
