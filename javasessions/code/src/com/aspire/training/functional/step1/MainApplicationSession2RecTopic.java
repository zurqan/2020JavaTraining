package com.aspire.training.functional.step1;

import com.aspire.training.functional.step2.TailCall;

public class MainApplicationSession2RecTopic {

    public static void main(String[] args) {
//        int add1 = add(10, 20);
//        System.out.println("add1 = " + add1);
//
//        int add2 = add(40000, 4);
//        System.out.println("add2 = " + add2);

        TailCall<Integer> integerTailCall = addTail(0, 5);
        System.out.println("integerTailCall.eval() = " + integerTailCall.eval());
        System.out.println("integerTailCall.isSuspend() = " + integerTailCall.isSuspend());
        TailCall<Integer> integerTailCall2 = addTail(400000, 5);
        System.out.println("integerTailCall2.isSuspend() = " + integerTailCall2.isSuspend());
        System.out.println("integerTailCall2.eval() = " + integerTailCall2.eval());
    }

    private static int add(int x,int y){
//        return x+y;
        //We need to use TCE or TCO
        return x==0?y:add(x-1,y+1);
    }

    private static TailCall<Integer> addTail(int x,int y){
        return x==0
                ? TailCall.result(y)
                : TailCall.suspend(()->addTail(x-1,y+1));
    }
}
