package com.aspire.training.functional.step2;

import com.aspire.training.functional.step0.MyFunction;

public class CompositeFunctionExampleWithGenericBound {

    private static final MyFunction<Object,String> toStr= x->x.toString();
    private static final MyFunction<String,String> mapStr=x->"Result: "+x;

    public static void main(String[] args) {

        // T IS Object
        // g mapStr -> the output String
        MyFunction<String, String> compose = toStr.compose(mapStr);
        System.out.println("compose.apply(\"Test\") = " + compose.apply("Test"));
    }
}
