package step3;

import java.util.Deque;
import java.util.LinkedList;

public class DeQueueExample {

    public static void main(String[] args) {
        Deque<Integer> deque=new LinkedList<>();
//        Deque<Integer> deque=new ArrayDeque<>();

        deque.push(10);
        deque.push(5);
        deque.push(3);
        deque.push(2);

        System.out.println("deque.getFirst() = " + deque.getFirst());
        System.out.println("deque.getLast() = " + deque.getLast());

//        System.out.println("deque.poll() = " + deque.pollFirst());
//        System.out.println("deque.poll() = " + deque.poll());
//        System.out.println("deque.poll() = " + deque.poll());
//        System.out.println("deque.poll() = " + deque.pollLast());


//        deque.removeIf(x->x%2==0);
//        System.out.println("deque.peek() = " + deque.peek());
//
//
        Deque<Character> chars= new LinkedList<>();
        for (char c: "(()()())".toCharArray()){
            if(c == '('){
                chars.push(c);
            }else{
                Character polledData = chars.poll();
                if(polledData ==null || polledData !='('){
                    throw new RuntimeException("Not Valid String");
                }
            }
        }
        if(chars.size()!=0){
            throw new RuntimeException("Not Valid String");
        }
    }
}
