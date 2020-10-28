package com.aspire.training.functional.threading;

import java.util.Vector;

public class VectorExampleDontUseIt {
    public static Integer getLast(Vector<Integer> v) {
        synchronized (v) {
            int lastIndex = v.size() - 1;
            return v.get(lastIndex);
        }
    }

    public static void deleteLast(Vector<Integer> v) {
        synchronized (v) {
            int lastIIndex = v.size() - 1;
            v.remove(lastIIndex);
        }
    }

    //th1 getlast , th2 delete
}
