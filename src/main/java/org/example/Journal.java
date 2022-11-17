package org.example;

import java.util.ArrayList;

public class Journal implements Comparable<Journal>{

    private String name;
    private String topic;
    private boolean subscription;
    private boolean otherUniAccess;
    private ArrayList<String> volumes;
    private ArrayList<String> topics;

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

    public void setVolumes(ArrayList<String> volumes) {
        this.volumes = volumes;
    }

    public ArrayList<String> getVolumes() {
        return volumes;
    }

    public void setSubscription(boolean subscription){
        this.subscription = subscription;
    }


    private String getName(){
        return name;
    }


    public void setOtherUniAccess(boolean pep){
        otherUniAccess = pep;

    }

    public boolean isOtherUniAccess() {
        return otherUniAccess;
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void addToTopics(String topic){

        topics.add(topic);
    }


    public boolean cancelSubscription(String topic){

        if(topics.contains(topic) || isOtherUniAccess()){
            setSubscription(true);
            return true;
        }
        else
        {
            setSubscription(false);
            return false;
        }
    }


    public boolean searchVolumes(String journal){
        return volumes.contains(journal);
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
