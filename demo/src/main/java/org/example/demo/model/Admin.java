package org.example.demo.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(schema = "Dat109FeedbackProject")
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String mobil;
    public String hash;

    @OneToMany(mappedBy = "admin")
    private List<User> users;

    @OneToOne(mappedBy = "admin")

    private List<User> lecturer;

    public Admin (){

    }
    public Admin(long id, String mobil, String hash) {
        this.id = id;
        this.mobil = mobil;
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
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
        return lecturer;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
