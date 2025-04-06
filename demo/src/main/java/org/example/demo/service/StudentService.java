package org.example.demo.service;

import org.example.demo.model.Feedback;
import org.example.demo.model.Lecture;
import org.example.demo.model.Student;
import org.example.demo.repository.FeedbackRepository;
import org.example.demo.repository.LectureRepository;
import org.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final FeedbackRepository feedbackRepository;
    private final LectureRepository lectureRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, FeedbackRepository feedbackRepository, LectureRepository lectureRepository) {
        this.studentRepository = studentRepository;
        this.feedbackRepository = feedbackRepository;
        this.lectureRepository = lectureRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void giveFeedback(Long studentId, Long lectureId, Feedback feedback) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        feedback.setStudent(student);
        feedback.setLecture(lecture);

        feedbackRepository.save(feedback);
    }

    
    
}
