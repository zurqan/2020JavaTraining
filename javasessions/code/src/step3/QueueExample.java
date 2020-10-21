package step3;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(10);
        queue.add(5);
        queue.add(3);
        System.out.println("queue = " + queue);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.remove() = " + queue.remove());

    }
}
