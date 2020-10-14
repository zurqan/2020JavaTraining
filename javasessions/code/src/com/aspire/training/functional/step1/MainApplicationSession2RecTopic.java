package com.aspire.training.functional.step1;

public class MainApplicationSession2RecTopic {

    public static void main(String[] args) {
        int add1 = add(10, 20);
        System.out.println("add1 = " + add1);

        int add2 = add(40000, 4);
        System.out.println("add2 = " + add2);
    }

    private static int add(int x,int y){
//        return x+y;
        return x==0?y:add(x-1,y+1);
    }
}
