package models.users;

import javax.persistence.*;


public abstract class User {
    private int id;
    private String name;
    private String username;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
