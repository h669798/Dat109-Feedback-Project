package org.example.demo.model;

import jakarta.persistence.*;

@Entity
public class lecturer extends user {

    @OneToMany(mappedBy = "lecturer")
    private List<Lecture> lectures;

    public List<Lecture> getLectures() {
        return lectures;
    }
    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
