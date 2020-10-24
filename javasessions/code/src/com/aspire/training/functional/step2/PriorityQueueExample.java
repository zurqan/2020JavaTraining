package com.aspire.training.functional.step2;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        Queue<String> names= new PriorityQueue<>();
        names.add("Mohammad");
        names.add("Ahmad");
        names.add("Zurqan");
        System.out.println("names = " + names);

    }
}
