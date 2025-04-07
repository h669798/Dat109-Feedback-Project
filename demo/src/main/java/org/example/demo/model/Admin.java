package org.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
@Entity

@DiscriminatorValue("ADMIN")
public class Admin extends User {

    private String mobil;
    private String hash;

    @OneToMany(mappedBy = "admin")
    private List<User> users;

    public Admin() {}

    public Admin(String mobil, String hash) {
        this.mobil = mobil;
        this.hash = hash;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
