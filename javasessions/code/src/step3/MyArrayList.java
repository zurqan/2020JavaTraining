package step3;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.arraycopy;
import static java.util.Arrays.copyOf;
import static java.util.Optional.empty;

public class MyArrayList<E> {

    private static final int DEFAULT_ARRAY_SIZE = 10;
    private Object[] data;

    private int size;

    public MyArrayList(Object[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public MyArrayList() {
        this(new Object[DEFAULT_ARRAY_SIZE],0);
    }

    public MyArrayList(int initialArraySize) {
        this(new Object[initialArraySize],0);
    }

    public static <E> MyArrayList<E> of(E... data){
        return new MyArrayList<E>(data, data.length);
    }


    public void set(int index,E element){
        //you need to expand array if index >= array size
        expandIfNeeded(index);

        data[index]=element;

        size=size>index+1?size:index+1;
    }

    public Optional<E> get(int index){

        return (index<0 || index >=size)
                ? empty()
                :Optional.of((E)data[index]);

    }

    public void addFirst(E element){
        expandIfNeeded(size);
        arraycopy(data,0,data,1,size++);
        data[0]=element;
    }
    public void addLast(E element){

        set(size,element);
    }

    public <U> MyArrayList<U> map(Function<? super E,? extends U> mapper){
        MyArrayList<U> uMyArrayList = new MyArrayList<>(data.length);
        Iterator<E> iterate = iterate();
        while (iterate.hasNext()){
            E elem = iterate.next();
            U mappedElem = mapper.apply(elem);
            uMyArrayList.addLast(mappedElem);
        }
        return uMyArrayList;
    }

    public <U> MyArrayList<U> flatMap(Function<? super E,MyArrayList<? extends U>> flatter){
        MyArrayList<U> uMyArrayList = new MyArrayList<>();
        Iterator<E> iterate = iterate();
        while(iterate.hasNext()){
            E element = iterate.next();
            MyArrayList<? extends U> flatted = flatter.apply(element);
            uMyArrayList.addAll(flatted);
        }
        return uMyArrayList;
    }

    public void addAll(MyArrayList<? extends E> another) {
        expandIfNeeded(size+another.size);
        Iterator<? extends E> iterate = another.iterate();
        while (iterate.hasNext()){
            addLast(iterate.next());
        }
    }

    public boolean contains(E data){
        Iterator<E> iterate = iterate();
        while (iterate.hasNext()){
            E element = iterate.next();
            if(element.equals(data)){
                return true;
            }
        }

        return false;
    }

    public MyArrayList<E> filter(Predicate<? super E> filter){
        //TODO
        return null;
    }

    //TODO filter, nonMatch, anyMatch..etc

    public Optional<E> remove(int index){
        if(index<0 || index>=size)return empty();

        E datum = (E)data[index];
        arraycopy(data,index+1,data,index,--size-index);
        data[size]=null;
        return Optional.of(datum);
    }

    private void expandIfNeeded(int targetIndex) {
        if(targetIndex<data.length)return;
//        int newArraySize= data.length <<1;//size * 2
        System.out.println("We will increase the Array Size");
        int newArraySize= data.length * 2;
        newArraySize=newArraySize<targetIndex?targetIndex:newArraySize;

         data= copyOf(data, newArraySize);
    }

    public int size(){
        return size;
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


    private Iterator<E> iterate() {
        return new MyArrayListIterator(data, size);
    }

    public static void main(String[] args) {
        MyArrayList<String> names = MyArrayList.of("Mohammad", "Ahmad", "Mosa");
        System.out.println("names = " + names);
        MyArrayList<Integer> testInteger = new MyArrayList<>();
        for (int i = 0; i <15; i++) {
            System.out.println("i = " + i);
            testInteger.set(i,i);
        }
        System.out.println("testInteger = " + testInteger);

        MyArrayList<Integer> lengthOfName = names.map(name -> name.length());
        System.out.println("lengthOfName = " + lengthOfName);

//        MyArrayList<Integer> numbers = new MyArrayList<>();
//        MyArrayList<Integer> numbersReversed = new MyArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            numbersReversed.addFirst(i);
//            numbers.addLast(i);
//        }
//        System.out.println("numbersReversed = " + numbersReversed);
//        System.out.println("numbers = " + numbers);
    }

    private class MyArrayListIterator implements Iterator<E>{

        private final Object[] data;
        private final int size;
        private int index=0;

        public MyArrayListIterator(Object[] data, int size) {
            this.data = data;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public E next() {
            //add validation
            if(index <0 || index >= size){
                throw new ArrayIndexOutOfBoundsException();
            }
            return (E)data[index++];
        }
    }
}
