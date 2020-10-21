package step3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public Iterator<E> iterate(){
        return new MyLinkedListIterator(first);
    }

    public void addAll(MyLinkedList<? extends E> listToBeAdded){
        Iterator<? extends E> iterate = listToBeAdded.iterate();
        while (iterate.hasNext()){
            E next = iterate.next();
            add(next);
        }

    }
    public <U> MyLinkedList<U> map(Function<? super E,? extends U> mapper){
        MyLinkedList<U> newList = new MyLinkedList<>();
        Iterator<E> iterate = iterate();
        while (iterate.hasNext()){
            E next = iterate.next();
            U mappedElement = mapper.apply(next);
            newList.add(mappedElement);
        }
        return newList;

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

    public Optional<E> get(int index){
        if(index <0 || index>=size) return empty();
        Node node = node(index);
        return Optional.of(node.data);
    }

    public Optional<E> removeFirst(){
        return first == null ? empty() : Optional.of(removeNode(first));
    }

    public Optional<E> removeLast(){
        return last == null ? empty() : Optional.of(removeNode(last));
    }

    public Optional<E> remove(int index){
        if(index <0 || index>=size) return empty();

        Node nodeThatNeedToBeRemoved = node(index);
        E data = removeNode(nodeThatNeedToBeRemoved);
        return Optional.of(data);
    }
    public void removeByValue( E dataToBeRemoved){
        Node node = first;
        int _s = this.size;
        for (int i = 0; i < _s; i++) {
            if(node == null) break;
            Node nextNodeToCheck = node.next;
            if(node.data.equals(dataToBeRemoved)){
                removeNode(node);
            }
            node= nextNodeToCheck;
        }
    }

    private E removeNode(Node nodeThatNeedToBeRemoved) {
        Node previousNode = nodeThatNeedToBeRemoved.previous;
        Node nextNode = nodeThatNeedToBeRemoved.next;

        if(previousNode==null){
            first = nextNode;
        }else{
            previousNode.next=nextNode;
        }

        if(nextNode==null){
            last=previousNode;
        }else{
            nextNode.previous=previousNode;
        }
        E data = nodeThatNeedToBeRemoved.data;
        nodeThatNeedToBeRemoved.previous=null;
        nodeThatNeedToBeRemoved.next=null;
        nodeThatNeedToBeRemoved.data=null;
        size--;
        return data;
    }

    private Node node(int index) {
        Node nav= first;
        for (int i = 0; i <size ; i++) {
            if(i == index){
                return nav;
            }
            nav=nav.next;
        }
        return null;
    }

    public <U> MyLinkedList<U> flatMap(Function<? super E,MyLinkedList<? extends U>> flatter){
        MyLinkedList<U> newList = new MyLinkedList<>();
        Iterator<E> iterate = iterate();
        while (iterate.hasNext()){
            E next = iterate.next();
            MyLinkedList<? extends U> subList = flatter.apply(next);
            newList.addAll(subList);
        }
        return newList;
    }

    public <U> U reduceLeft(U seed,BiFunction<U,E,U> reducerFunction){
        //(acc,e)->acc
        return reduceLeft(seed,acc->e->reducerFunction.apply(acc,e));
    }
    public <U> U reduceLeft(U seed,Function<? super U,Function<? super E,? extends U>> reducerFunction){
        //acc->e->acc
        U accum = seed;
        Iterator<E> iterate = iterate();
        while (iterate.hasNext()){
            E next = iterate.next();
            accum = reducerFunction.apply(accum).apply(next);
        }
        return accum;
    }

    // e->acc->acc
    public <U> U reduceRight(U seed,Function<? super E,Function<? super U,? extends U>> reducerFunction){
      return null;//TODO
    }

    public MyLinkedList<E> filter(Predicate<? super E> filter){
        return reduceLeft(new MyLinkedList<>(),
                acc->e->{
                    boolean test = filter.test(e);
                    if(test){
                        acc.add(e);
                    }
                    return acc;
                });
    }

    public boolean allMatch(Predicate<? super E> condition){
        Iterator<E> iterate = iterate();
        boolean passed=false;
        while (iterate.hasNext()){
            E next = iterate.next();
            passed=condition.test(next);
            if(passed==false)return false;
        }
        return passed;
    }

    public boolean anyMatch(Predicate<? super E> condition){
        return  false;//TODO implementation
    }

    public boolean nonMatch(Predicate<? super E> condition){
        return  false;//TODO implementation
    }

    public MyLinkedList<E> revers(){
        return reduceLeft(new MyLinkedList<E>(),acc->e->{
            acc.addFirst(e);
            return acc;
        });
    }




    @Override
    public String toString() {
        Iterator<E> iterate = iterate();
        if(iterate.hasNext() == false)return "[]";

        StringBuffer toStr = new StringBuffer();
        toStr.append("[");
        while(iterate.hasNext()){
            E next = iterate.next();
            toStr.append(next);
            if(iterate.hasNext()){
                toStr.append(",");
            }
        }
        toStr.append("]");
        return toStr.toString();
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

        Iterator<Integer> iterator = numbers.iterate();
        while (iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }

        //x->x*4
        MyLinkedList<Integer> mapped = numbers.map(x -> x * 4);
        System.out.println("mapped = " + mapped);

        MyLinkedList<String> mapped2 = numbers.map(x -> "Number is " + x);
        System.out.println("mapped2 = " + mapped2);

        MyLinkedList<Integer> flattedLinkedList = numbers.flatMap(x -> {
            MyLinkedList<Integer> subList = new MyLinkedList<>();
            subList.add(x - 1);
            subList.add(x);
            subList.add(x + 1);
            return subList;
        });

        System.out.println("flattedLinkedList = " + flattedLinkedList);

        System.out.println("numbers.get(0) = " + numbers.get(0));
        System.out.println("numbers.get(1) = " + numbers.get(1));
        System.out.println("numbers.get(2) = " + numbers.get(2));

//        numbers.remove(0);
//        System.out.println("numbers = " + numbers);
//        numbers.remove(0);
//        System.out.println("numbers = " + numbers);
//        numbers.add(10);
//        numbers.removeByValue(10);
//        System.out.println("numbers = " + numbers);

//        numbers.removeFirst();
//        System.out.println("numbers = " + numbers);

        Integer sum = numbers.reduceLeft(0, acc -> e -> acc + e);
        System.out.println("sum = " + sum);

        LinkedList<Integer> javaList = numbers.reduceLeft(new LinkedList<Integer>(), acc -> e -> {
            acc.add(e);
            return acc;
        });
        System.out.println("javaList = " + javaList);

        String data = numbers.reduceLeft("", acc -> e -> acc + "," + e);
        System.out.println("data = " + data);

        MyLinkedList<Integer> reversedList = numbers.revers();
        System.out.println("reversedList = " + reversedList);

        MyLinkedList<Integer> filteredList = numbers.filter(x -> x > 5);
        System.out.println("filteredList = " + filteredList);

        boolean isEven = numbers.allMatch(x -> x % 2 == 0);

        boolean allGraterThan5 = numbers.allMatch(x -> x > 5);
        System.out.println("isEven = " + isEven);
        System.out.println("allGraterThan5 = " + allGraterThan5);
    }

    private class MyLinkedListIterator implements Iterator<E> {

        private Node currentNode;
        private Node lastAccessedNode;

        public MyLinkedListIterator(Node currentNode){
            this.currentNode = currentNode;
        }
        @Override
        public boolean hasNext() {
            return currentNode!=null;
        }

        @Override
        public E next() {
            lastAccessedNode = currentNode;
            currentNode=currentNode.next;
            return lastAccessedNode.data;
        }
    }
}
