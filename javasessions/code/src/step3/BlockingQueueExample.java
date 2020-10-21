package step3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue
                =new LinkedBlockingDeque<>();
        new Thread(()->{
            //sleep for 6 sec
            sleep();
            //then add element
            blockingQueue.add(5);
        }).start();

        for (int i = 0; i <3 ; i++) {

            Integer poll = blockingQueue.poll(5, TimeUnit.SECONDS);
            System.out.println("poll = " + poll);
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
