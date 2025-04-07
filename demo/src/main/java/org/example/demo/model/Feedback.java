package org.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity

@Table(schema = "Dat109FeedbackProject")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeedbackType type;

    private String comment;

    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    // Student er valgfritt for anonymitet
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Konstruktør uten student (anonym)
    public Feedback(FeedbackType type, String comment, Lecture lecture) {
        this.type = type;
        this.comment = comment;
        this.lecture = lecture;
    }

    // Konstruktør med student
    public Feedback(FeedbackType type, String comment, Lecture lecture, Student student) {
        this.type = type;
        this.comment = comment;
        this.lecture = lecture;
        this.student = student;
    }

    public Feedback() {} // Tom konstruktør kreves av JPA

    public Long getId() {
         return id; }

    public FeedbackType getType() { 
        return type; 
    }

    public void setType(FeedbackType type) { 
        this.type = type; 
    }

    public String getComment() {
         return comment;
     }

    public void setComment(String comment) { 
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
     }

    public void setTimestamp(LocalDateTime timestamp) { 
        this.timestamp = timestamp;
     }

    public Lecture getLecture() {
         return lecture; 
        }

    public void setLecture(Lecture lecture) { 
        this.lecture = lecture; 
    }

    public Student getStudent() { 
        return student; 
    }

    public void setStudent(Student student) { 
        this.student = student; 
    }
}
