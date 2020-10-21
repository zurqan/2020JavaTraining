package step3;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentDeQueue {

    public static void main(String[] args) throws InterruptedException {
//        Queue<Integer> numbers = new LinkedList<>();
        Queue<Integer> numbers = new LinkedBlockingQueue<>();

        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    numbers.add(10);
                }

                countDownLatch.countDown();
            }
            ).start();
        }

        countDownLatch.await(20, TimeUnit.SECONDS);
        System.out.println("numbers.size() = " + numbers.size());
    }
}
