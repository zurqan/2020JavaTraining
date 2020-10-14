package com.aspire.training.functional.step0;

@FunctionalInterface
public interface IntFunction {

    public int apply(int x);

    default IntFunction compose(IntFunction firstFunction){

        return x -> apply(firstFunction.apply(x));
    }

}
