package org.example.demo.repository;

import org.example.demo.model.feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByLectureId(Long lectureId);
}