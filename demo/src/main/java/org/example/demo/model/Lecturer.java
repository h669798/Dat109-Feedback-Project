package org.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("LECTURER")
public class Lecturer extends User {

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lecture> lectures = new ArrayList<>();

    // Hent alle forelesninger
    public List<Lecture> getLectures() {
        return lectures;
    }

    // Sett alle forelesninger
    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    // Legg til en individuell forelesning
    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
        lecture.setLecturer(this);
    }

    // Fjern en individuell forelesning
    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
        lecture.setLecturer(null);
    }
}
