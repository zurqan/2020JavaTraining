package com.aspire.training.functional.step0;

@FunctionalInterface
public interface BiMyFunction<T,V,U> {

    public U apply(T t,V v);
}
