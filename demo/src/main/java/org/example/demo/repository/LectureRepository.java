package org.example.demo.repository;

import org.example.demo.model.Lecture;
import org.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findByLecturer(User lecturer);
}