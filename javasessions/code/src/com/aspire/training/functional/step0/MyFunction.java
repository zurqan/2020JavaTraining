package com.aspire.training.functional.step0;

@FunctionalInterface
public interface MyFunction<T,V> {

    public V apply(T t);

    default  <W> MyFunction<W,V> compose(MyFunction< ? super W, ? extends T> g){


        return x->apply(g.apply(x));
    }

    default <W> MyFunction<T,W> andThen(MyFunction<? super V,? extends W> nextFunction){
        return x->nextFunction.apply(apply(x));
    }
}
