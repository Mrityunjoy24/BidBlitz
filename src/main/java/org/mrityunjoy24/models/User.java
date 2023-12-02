package org.mrityunjoy24.models;


public class User {
    private int id;
    private String name;
    private int superCoins;

    public User(int id,String name, int superCoins){
        this.id = id;
        this.name = name;
        this.superCoins = superCoins;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getSuperCoins(){
        return superCoins;
    }

    public void setSuperCoins(int superCoins){
        this.superCoins = superCoins;
    }
}

