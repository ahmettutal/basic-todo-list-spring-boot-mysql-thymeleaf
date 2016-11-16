package com.tutal.ahmet.springboot.entity;

import javax.persistence.*;

/**
 * Created by ismail on 16.11.2016.
 */

@Entity
public class Todos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private boolean complated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Todos() {
    }

    public Todos(String name, boolean complated) {
        this.name = name;
        this.complated = complated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isComplated() {
        return complated;
    }

    public void setComplated(boolean complated) {
        this.complated = complated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
