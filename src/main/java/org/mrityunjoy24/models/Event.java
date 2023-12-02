package org.mrityunjoy24.models;

import java.util.Date;

public class Event {
    private int id;
    private String name;
    private Date eventDate;
    private String prize;

    public Event(int id,String name, String prize, Date date){
        this.id = id;
        this.name = name;
        this.eventDate = date;
        this.prize = prize;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }


    public Date getEventDate(){
        return eventDate;
    }

    public String getPrize(){
        return prize;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEventDate(Date date){
        this.eventDate = date;
    }

    public void setPrize(String prize){
        this.prize = prize;
    }
}
