package step3;

import java.util.Optional;

import static java.util.Optional.empty;

public class MyLinkedList<E> {

    private int size;
    private Node first;
    private Node last;

    public Optional<E> first(){
        return first==null? empty():Optional.of(first.data);
    }

    public Optional<E> last(){
        return last==null?empty():Optional.of(last.data);
    }

    public void push(E data){
        addFirst(data);
    }

    public void addFirst(E data){
        Node oldFirst = first;
        Node newNode=new Node(null,oldFirst,data);
        first=newNode;
        if(oldFirst==null){
            last=newNode;
        }else{
            oldFirst.previous=newNode;
        }
        size++;
    }

    public void add(E data){
        addLast(data);
    }
    public void addLast(E data){
        Node oldLast = last;
        Node newNode= new Node(oldLast,null,data);
        last=newNode;
        if(oldLast==null){
            first=newNode;
        }else{
            oldLast.next=newNode;
        }
        size++;
    }
    public int size(){
        return size;
    }



    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }

    private class Node {
        private Node previous;
        private Node next;
        private E data;

        public Node(Node previous,Node next,E data){
            this.previous=previous;
            this.next=next;
            this.data=data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> numbers=new MyLinkedList<>();
//        numbers.addFirst(10);
//        numbers.addFirst(2);
        numbers.add(10);
        numbers.add(2);
        System.out.println("numbers = " + numbers);
    }
}
