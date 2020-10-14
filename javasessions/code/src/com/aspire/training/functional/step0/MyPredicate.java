package com.aspire.training.functional.step0;

@FunctionalInterface
public interface MyPredicate<T> {

    public boolean test(T t);
}
