package step3;

public class MyHashSet<E> {

    final static int DEFAULT_ARRAY_SIZE = 10;
    final Object[] data;
    int size;

    public MyHashSet() {
        this(DEFAULT_ARRAY_SIZE);
    }

    public MyHashSet(int arraySize) {
        this.data = new Object[arraySize];
    }

    public void add(E element) {
        int position = getPosition(element);
        MyLinkedList<E> bucket = (MyLinkedList<E>) data[position];
        if (bucket == null) {
            bucket = new MyLinkedList<>();
            bucket.addLast(element);
            data[position] = bucket;
            size++;
            return;
        }
        boolean founded = bucket.anyMatch(e -> (element==null&& e==null)||e.equals(element));
        if(founded)return;
        bucket.addLast(element);
        size++;

    }

    public int getPosition(E element){
        if(element ==null) return 0;
        int hashCode = Math.abs( element.hashCode());
        int position = hashCode % data.length;
        return hashCode % data.length;
    }

    public boolean contains(E element){
        int position = getPosition(element);
        MyLinkedList<E> bucket = (MyLinkedList<E>) data[position];
        return bucket==null?false:bucket.anyMatch(e->(element==null&& e==null)||e.equals(element));
    }

    public void debug(){
        for (int i = 0; i < data.length; i++) {
            MyLinkedList<E> sub = (MyLinkedList<E>)data[i];
            if(sub==null){
                System.out.printf("%d value is Empty %n",i);
            }else{
                System.out.printf("%d value is %s %n ",i,sub);
            }
        }
    }

    public static void main(String[] args) {
        String[] names=new String[]{
                "Mohammad","Ahmad","Mosa","Ruba","Najwan","Ala'a","Ali","Dana","Dena"
        };

        MyHashSet<String> namesSet = new MyHashSet<String>();
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s -> hashCode -> %d %n",names[i],names[i].hashCode());
            namesSet.add(names[i]);
        }

        namesSet.debug();
        System.out.println("namesSet.contains(\"Mohammad\") = " + namesSet.contains("Mohammad"));
        System.out.println("namesSet.contains(\"Yousef\") = " + namesSet.contains("Yousef"));


    }
}
