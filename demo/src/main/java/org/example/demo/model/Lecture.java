package org.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "Dat109FeedbackProject")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    // Getters and Setters


    public void setId(long id){
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    // Feedback counting helpers

    public long countGreenFeedback() {
        return feedbacks.stream()
                .filter(f -> f.getType() == FeedbackType.GREEN)
                .count();
    }

    public long countYellowFeedback() {
        return feedbacks.stream()
                .filter(f -> f.getType() == FeedbackType.YELLOW)
                .count();
    }

    public long countRedFeedback() {
        return feedbacks.stream()
                .filter(f -> f.getType() == FeedbackType.RED)
                .count();
    }
}
