package com.aspire.training.functional.step2;

public class ArraysAndGeneric {

    public static void main(String[] args) {
        testArray();
    }
    public static void testArray(){

        Integer[] ints = new Integer[]{4,5,6};
        Number[] c=ints;
        c[0]=5.5;
    }
}
