package com.tutal.ahmet.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AppRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ROLE_NAME", nullable = false)
    private String rolename;

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> users;

    @ManyToMany
    @JoinTable(
            name = "roles_contacts",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "id"))
    private List<AppContact> contacts;

    public AppRole() {
    }

    public AppRole(String rolename) {
        this.rolename = rolename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<AppUser> getUsers() {
        return users;
    }

    public void setUsers(List<AppUser> users) {
        this.users = users;
    }

    public List<AppContact> getContacts() {
        return contacts;
    }

    public void setContacts(List<AppContact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "AppUser [id=" + id + ", rolename=" + rolename + "]";
    }

}
