package com.aspire.training.functional.step0;

import java.util.ArrayList;

public class MainApplicationSession2 {

    public static void main(String[] args) {

        MyPredicate<Integer> checkIfEven=x->x%2==0;

        System.out.println("checkIfEven.test(10) = " + checkIfEven.test(10));
        System.out.println("checkIfEven.test(21) = " + checkIfEven.test(21));

        MySupplier<ArrayList> arrayListCreator = ()->new ArrayList();

        ArrayList list = arrayListCreator.supply();
        list.add("Test");
        System.out.println("list = " + list);

        MyConsumer<Object> printIt = x->{
            System.out.println(x);
        };
        printIt.consume(list);

        //(x,y)->...
        BiMyFunction<Integer,Integer,String> add=(x,y)->"The Answer is: "+(x+y);

        System.out.println("add.apply(10,20) = " + add.apply(10, 20));

        //x->y->use add function....
        MyFunction<Integer,MyFunction<Integer,String>> addCurring
                =x->y->
                add.apply(x,y);

        MyFunction<Integer, String> f1 = addCurring.apply(10);
        System.out.println("f1.apply(20) = " + f1.apply(20));

        System.out.println("addCurring.apply(10).apply(20) = "
                + addCurring.apply(10).apply(20));


    }
}
