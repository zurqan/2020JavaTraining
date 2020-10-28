package com.aspire.training.functional.threading;

import java.util.concurrent.*;

public class FutureTaskExample {

    private final FutureTask<Integer> future=
            new FutureTask<>(()->{
                Thread.sleep(10000);
                return 100;
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTaskExample obj = new FutureTaskExample();
        new Thread(obj.future).start();

        //Future and Complet //TODO
//        Integer integer = obj.future.get();
        Integer integer = obj.future.get(6, TimeUnit.SECONDS);
        System.out.println("integer = " + integer);
        System.out.println("Exit");
    }
}
