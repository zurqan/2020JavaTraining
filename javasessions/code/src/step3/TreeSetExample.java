package step3;

import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        TreeSet<Integer> numbers=new TreeSet<>();//asc
//        TreeSet<Integer> numbers=new TreeSet<>((a,b)->b.compareTo(a));//desc

        numbers.add(10);
        numbers.add(20);
        numbers.add(15);
        numbers.add(30);
        numbers.add(0);

        for (Integer number : numbers) {
            System.out.println("number = " + number);
        }

        System.out.println("numbers.ceiling(16) = " + numbers.ceiling(16));

        System.out.println("numbers.floor(16) = " + numbers.floor(16));

        System.out.println("numbers.tailSet(16) = " + numbers.tailSet(16));

        System.out.println("numbers.headSet(16) = " + numbers.headSet(16));

        System.out.println("numbers.subSet(3,false,24,true) = " + numbers.subSet(10, true, 24, true));

    }
}
