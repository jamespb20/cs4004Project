package org.example;

import java.util.ArrayList;

public class Journal {

    private String name;
    private String topic;
    private boolean subscription;
    private boolean otherUniAccess;
    private boolean journalinVolume;

    private ArrayList<String> volumes;
    private ArrayList<String> topics;

    public Journal(String name){

        this.name = name;
        topics = new ArrayList<>();
        volumes = new ArrayList<>();
    }

    public String getTopic() {
        return topic;
    }

    public boolean isJournalinVolume() {
        return journalinVolume;
    }

    public void setJournalinVolume(boolean journalinVolume) {
        this.journalinVolume = journalinVolume;
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

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }


    public void addToVolumes(String journal){

        volumes.add(journal);
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
            if(volumes.contains(journal)){
                setJournalinVolume(true);
                return true;
            }
            else
            {
                setJournalinVolume(false);
                return false;
            }
    }
}
