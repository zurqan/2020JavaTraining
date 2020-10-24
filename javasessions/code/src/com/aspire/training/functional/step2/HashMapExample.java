package com.aspire.training.functional.step2;

import java.util.HashMap;

public class HashMapExample {

    public static void main(String[] args) {
//        [MyLinkedList<Tuple<Integer,String>>]
        // TODO try to implement your HashMap
        HashMap<Integer,String> idsNames = new HashMap<Integer,String>() {{

            put(1,"Mohammad");
            put(2,"Ahmad");
            put(3,"Mosa");
        }};

        System.out.println("idsNames.get(1) = " + idsNames.get(1));
        System.out.println("idsNames.get(10) = " + idsNames.get(10));

        System.out.println("idsNames.getOrDefault(10,\"Not Found\") = " + idsNames.getOrDefault(10, "Not Found"));
        System.out.println("idsNames.getOrDefault(1,\"Not Found\") = " + idsNames.getOrDefault(1, "Not Found"));

        String savedName = idsNames.computeIfAbsent(0, key -> "Ali");
        System.out.println("savedName = " + savedName);
        System.out.println("savedName = " + idsNames.get(0));

        //grouping by course students using reduce <Stream> assigmenet
//        coursesMap.computeIfAbsent(corse,new ArrayList()).add(student);

        idsNames.compute(1,(key,value)->value +" Updated");
        System.out.println("idsNames = " + idsNames);
        idsNames.compute(100,(key,value)->"New Name");
        System.out.println("idsNames = " + idsNames);
        idsNames.compute(2,(key,value)->null);
        System.out.println("idsNames = " + idsNames);
    }
}
