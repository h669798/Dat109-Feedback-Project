package org.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(schema = "Dat109FeedbackProject")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String mobil;
    public String hash;

    @OneToMany(mappedBy = "admin")
    private List<User> users;

    public Admin (){

    }
    public admin(int id, String mobil, String hash) {
        this.id = id;
        this.mobil = mobil;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
        return lectures;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
