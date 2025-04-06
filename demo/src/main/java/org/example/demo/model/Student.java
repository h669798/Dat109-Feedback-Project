package org.example.demo.model;

import jakarta.persistence.*;

import java.util.List;


@Entity

@DiscriminatorValue("STUDENT")
public class Student extends User {

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbackList;

    public List<Feedback> getFeedbackList() { 
        return feedbackList; 
    }

    public void setFeedbackList(List<Feedback> feedbackList) { 
        this.feedbackList = feedbackList; 
    }
}

