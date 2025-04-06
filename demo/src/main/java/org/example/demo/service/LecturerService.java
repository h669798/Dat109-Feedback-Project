package org.example.demo.service;

import org.example.demo.model.Feedback;
import org.example.demo.model.Lecture;
import org.example.demo.model.Lecturer;
import org.example.demo.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> getLecturesByLecturer(Lecturer lecturer) {
        return lectureRepository.findByLecturer(lecturer);
    }

    public List<Feedback> getFeedbackForLecture(Lecture lecture) {
        return lecture.getFeedbacks(); // Assuming the relationship is set correctly in the model
    }

    public void addLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
