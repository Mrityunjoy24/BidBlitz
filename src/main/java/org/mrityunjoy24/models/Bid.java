package org.mrityunjoy24.models;

import java.util.Date;
import java.util.List;

public class Bid {
    private int id;
    private User user;
    private Event event;
    private List<Integer> bidAmounts;
    private Date createdAt;

    public Bid(int id, User user, Event event, List<Integer> bidAmounts, Date date){
        this.id = id;
        this.user = user;
        this.event = event;
        this.bidAmounts = bidAmounts;
        this.createdAt = date;
    }

    public int getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public Event getEvent(){
        return event;
    }

    public List<Integer> getBidAmounts(){
        return bidAmounts;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public void setBidAmounts(List<Integer> bidAmounts){
        this.bidAmounts = bidAmounts;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
