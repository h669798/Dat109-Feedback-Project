package org.example.demo.service;

import org.example.demo.model.Feedback;
import org.example.demo.model.Lecture;
import org.example.demo.model.User;
import org.example.demo.repository.FeedbackRepository;
import org.example.demo.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private UserService userService;

    // 1. Lag anonym tilbakemelding
    @Transactional
    public Feedback addAnonymousFeedback(Long lectureId, Feedback feedback) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        feedback.setLecture(lecture);
        feedback.setStudent(null); // anonym
        return feedbackRepository.save(feedback);
    }

    // 2. Lag tilbakemelding med bruker
    @Transactional
    public Feedback submitFeedback(Long lectureId, String phone, Feedback feedback) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        if (phone != null) {
            User student = userService.getUserByPhone(phone);
            feedback.setStudent(student);
        } else {
            feedback.setStudent(null); // anonym
        }

        feedback.setLecture(lecture);
        return feedbackRepository.save(feedback);
    }

    // 3. Hent tilbakemeldinger for én forelesning
    public List<Feedback> getFeedbackForLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        return feedbackRepository.findByLecture(lecture);
    }

    // 4. Hent alle tilbakemeldinger
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // 5. Hent alle tilbakemeldinger gitt av én student
    public List<Feedback> getFeedbackByStudent(String phone) {
        User student = userService.getUserByPhone(phone);
        return feedbackRepository.findByStudent(student);
    }

    // 6. Slett tilbakemelding
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
