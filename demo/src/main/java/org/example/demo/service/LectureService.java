package org.example.demo.service;

import org.example.demo.model.Lecture;
import org.example.demo.model.Lecturer;
import org.example.demo.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public Lecture updateLecture(Long id, Lecture updatedLecture) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));

        lecture.setTopic(updatedLecture.getTopic());
        lecture.setDate(updatedLecture.getDate());
        lecture.setLecturer(updatedLecture.getLecturer());

        return lectureRepository.save(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }

    public List<Lecture> getLecturesByLecturer(Lecturer lecturer) {
        return lectureRepository.findByLecturer(lecturer);
    }

    public Lecture getLectureById(Long id) {
        return lectureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecture not found"));
    }
}
