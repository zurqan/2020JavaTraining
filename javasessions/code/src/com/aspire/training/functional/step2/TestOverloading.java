package com.aspire.training.functional.step2;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

public class TestOverloading {

    public static int sum2(List<Integer> numbers){
        int sum =0;
        for (Integer number : numbers) {
            sum+=number;
        }
        return sum;
    }

    public static String sum(List<String> strs){
        StringBuffer sum = new StringBuffer();
        for (String str : strs) {
            sum.append(str);
        }
        return sum.toString();
    }

    public static void main(String[] args) {
        Method[] methods = TestOverloading.class.getDeclaredMethods();

        Stream.of(methods)

                .filter(m->m.getName().startsWith("sum"))
                .map(m->m.toGenericString())
                .forEach(System.out::println);

    }




}
