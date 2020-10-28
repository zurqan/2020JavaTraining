package com.aspire.training.functional.threading;

import java.util.ArrayList;
import java.util.List;

public class PublicationObject {
    private List<String> list=new ArrayList<>();
    private int count;
    public int getCount(){
        return count;
    }

    public List<String> getListGood(){
        return new ArrayList<>(list);
    }
    public List<String> getListBad(){
        return list;
    }
    public synchronized String  addAndGetLast(String name){
        list.add(name);
        return list.get(list.size() - 1);
    }
    public synchronized void removeLast(){
        list.remove(list.size()-1);
    }
}
