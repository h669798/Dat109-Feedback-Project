package org.example.demo.repository;

import org.example.demo.model.Feedback;
import org.example.demo.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByLecture(Lecture lecture);
}
