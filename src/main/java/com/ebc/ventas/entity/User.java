package com.ebc.ventas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(unique= true)
    private String username;
    private String password;
    private int visits;
    private boolean deleted;

    public User() {
        super();
    }

    public User(String name, String username, String password, int visits, boolean deleted) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
        this.visits = visits;
        this.deleted = deleted;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getVisits() {
        return visits;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setVisits(int visits) {
        this.visits = visits;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}