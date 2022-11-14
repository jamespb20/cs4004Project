package org.example;

import java.util.ArrayList;

public class Journal {

    private String name;
    private String topic;
    private boolean subscription;
    private boolean otherUniAccess;

    private ArrayList<String> topics;

    public Journal(String name){

        this.name = name;
        topics = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }


    public void setTopic(String topic) {
        this.topic = topic;
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

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public void addToTopics(String topic){

        topics.add(topic);
    }

    public boolean cancelSubscription(String topic){

        if(topics.contains(topic) || isOtherUniAccess() == true){
            setSubscription(true);
            return true;
        }
        else
        {
            setSubscription(false);
            return false;
        }
    }
}
