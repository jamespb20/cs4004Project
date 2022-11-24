package org.example;

import java.util.ArrayList;

public class Journal implements Comparable<Journal>{

    private String name;
    private String topic;
    private boolean subscription;
    private boolean otherUniAccess;
    private ArrayList<String> volumes;

    private int year;

    public Journal(String name, int year){
        this.name = name;
        this.year = year;

    }

    public Journal(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private String getName(){
        return name;
    }


    public void setOtherUniAccess(boolean pep){
        otherUniAccess = pep;

    }
    @Override
    public int compareTo(Journal o) {
        int compareYear = o.getYear();
        return compareYear - this.year;
    }

    public int getYear() {
        return year;
    }



    @Override
    public String toString() {
        return "Journal: " + getName() + " Year:" + getYear();
    }
}
