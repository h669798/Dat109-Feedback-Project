package org.example.demo.service;

import org.example.demo.model.Feedback;
import org.example.demo.model.Lecture;
import org.example.demo.model.Student;
import org.example.demo.repository.FeedbackRepository;
import org.example.demo.repository.LectureRepository;
import org.example.demo.repository.StudentRepository;
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
    private StudentRepository studentRepository;

    // Legg til anonym tilbakemelding
    @Transactional
    public Feedback addAnonymousFeedback(Long lectureId, Feedback feedback) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));
        
        feedback.setLecture(lecture);
        feedback.setStudent(null); // Ingen student = anonym
        return feedbackRepository.save(feedback);
    }

    // Hent tilbakemeldinger for en forelesning
    public List<Feedback> getFeedbackForLecture(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        return feedbackRepository.findByLecture(lecture);
    }

    // Hent tilbakemeldinger for en student
    public List<Feedback> getFeedbackByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return feedbackRepository.findByStudent(student);
    }

    // Slett tilbakemelding
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    // Lagre en tilbakemelding
    @Transactional
    public Feedback submitFeedback(Long lectureId, Long studentId, Feedback feedback) {
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        if (studentId != null) {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new RuntimeException("Student not found"));
            feedback.setStudent(student);
        } else {
            feedback.setStudent(null); // Anonym tilbakemelding
        }

        feedback.setLecture(lecture);
        return feedbackRepository.save(feedback);
    }

    public Feedback submitFeedback(Feedback feedback) {
        if (feedback.getStudent() == null) {
            return addAnonymousFeedback(feedback.getLecture().getId(), feedback);
        } else {
            return feedbackRepository.save(feedback);
        }
    }
    

}
