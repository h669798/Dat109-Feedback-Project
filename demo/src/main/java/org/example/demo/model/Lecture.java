package org.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecture")
public class Lecture {

    // Variabler:
    @Id
    @Column(name = "lecture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "lecturer_phone", referencedColumnName = "phone", nullable = false)
    private User lecturer;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    // Getters og Setters:
    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getLecturer() {
        return lecturer;
    }

    public void setLecturer(User lecturer) {
        this.lecturer = lecturer;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public long countGreenFeedback() {
        return feedbacks.stream().filter(f -> f.getType() == FeedbackType.GREEN).count();
    }

    public long countYellowFeedback() {
        return feedbacks.stream().filter(f -> f.getType() == FeedbackType.YELLOW).count();
    }

    public long countRedFeedback() {
        return feedbacks.stream().filter(f -> f.getType() == FeedbackType.RED).count();
    }
}