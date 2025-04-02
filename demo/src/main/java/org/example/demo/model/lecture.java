package org.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private LocalDateTime time;
    private String location;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private User lecturer;

    @OneToMany(mappedBy = "lecture")
    private List<Feedback> feedbacks;

    public Lecture() {

    }

    public Lecture(String name, LocalDateTime time, String location) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.location = location;

        public long getId() { return id; }
        public void setId(long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getLocalDateTime() { return LocalDateTime; }
        public void setLocalDateTime(LocalDateTime time) { this.LocalDateTime = LocalDateTime; }
        public String getlocation() { return location; }
        public void setLocation() { this.location = location; }
        public User getLecturer() { return lecturer; }
        public void setLecturer(User lecturer) { this.lecturer = lecturer; }
        public List<Feedback> getFeedbacks() { return feedbacks; }
        public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }
    }
}
