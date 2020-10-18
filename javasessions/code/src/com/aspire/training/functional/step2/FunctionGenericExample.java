package com.aspire.training.functional.step2;

import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionGenericExample {

    public static void main(String[] args) {
        int result = mathOperations(1,
                x -> x + 1,
                x -> x * x,
                x -> 5 - x
        );
        System.out.println(result);

        int result3 = mathOperations2(1,
                x -> 5 - x,
                x -> x * x,
                x -> x + 1
        );
        System.out.println(result3);

        int result2 = mathOperations2(1,
                x -> x + 1,
                x -> x * x,
                x -> 5 - x
        );
        System.out.println("result2 = " + result2);




    }

    @SafeVarargs
    public static int mathOperations(int seed, Function<Integer,Integer>... funcitons){
//        Object[] functionsObj = funcitons;
//        Supplier<Integer> supplier = ()->2;
//        functionsObj[0]=supplier;
        Function<Integer, Integer> reduce = Stream
                .of(funcitons)
                .reduce(x -> x, (acc, x) -> acc.andThen(x));

        return reduce.apply(seed);
    }

    @SafeVarargs
    public static int mathOperations2(int seed, Function<Integer,Integer>... funcitons){
        Function<Integer, Integer> reduce = Stream
                .of(funcitons)
                .reduce(x -> x, (acc, x) -> acc.compose(x));

        return reduce.apply(seed);
    }
}
