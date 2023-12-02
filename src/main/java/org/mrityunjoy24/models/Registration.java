package org.mrityunjoy24.models;

public class Registration {
    private int id;
    private Event event;
    private User user;

    public Registration(int id, Event event, User user){
        this.id = id;
        this.event = event;
        this.user = user;
    }

    public int getId(){
        return id;
    }

    public Event getEvent(){
        return event;
    }

    public User getUser(){
        return user;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public void setUser(User user){
        this.user = user;
    }
}
