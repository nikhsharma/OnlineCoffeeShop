package models.users;

import models.basket.Basket;

import javax.persistence.*;


public abstract class User {
    private String name;
    private String username;
    private Basket basket;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        this.basket = basket;

    }

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
