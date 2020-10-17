package com.aspire.training.functional.step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhyGeneric {

    public static void printNumbersAfterAdding5(List numbers){
        for (Object numberObj : numbers) {
            int number = (Integer) numberObj;
            number+=5;
            System.out.println("number = " + number);
        }
    }

    public static void printNumbersAfterAdding5V2(List<Integer> numbers){
        for (Integer number : numbers) {
            number+=5;
            System.out.println("number = " + number);
        }
    }

    public static void add(List<Number> numbers){
        numbers.add(5.5);
        numbers.add(3);

    }

    public static void read(List<? extends Number> numbers){
        //Read .. get.. => we will use extends
        Number number = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
    }

    public static void addObj(List<? super Number> list){

        list.add(3);
        list.add(3);

    }

    public static void readAndAdd(List<Number> numbers){
        //Read and add use what?
        Number number = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        numbers.add(3);
        numbers.add(3);
    }

    public static void print(List<? extends Object> list){
        for (Object o : list) {
            String str = o.toString();
            System.out.println("to String : "+str);
        }

    }

    public static void printRest(List<Object> list){
        for (Object o : list) {
            String str = o.toString();
            System.out.println("to String : "+str);
        }

    }

    public static void main(String[] args) {
//        List numbers = Arrays.asList(1, 2, 3,"R");
//        printNumbersAfterAdding5(numbers);
//        ArrayList<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(2);
//        numbers.add(3);
//        numbers.add("R");

//        Integer integer = new Integer(1);//boxing
//        int y = integer+1;
        List<Integer> integers = Arrays.asList(1, 2, 3);
//        printNumbersAfterAdding5V2(integers);
//        add(integers);

//        List<Number> n = integers; // compile time error
        read(integers);

        List<Object> obj = new ArrayList<>();
        obj.add(5);
        List<Number> n = new ArrayList<>();
        n.add(1);
        //addObj I can call it with wither List<Number> or List<Object>


        print(n);
//        printRest(n);//compilation error
    }
}
