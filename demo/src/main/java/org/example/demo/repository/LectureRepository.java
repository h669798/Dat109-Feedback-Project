package org.example.demo.repository;

import org.example.demo.model.lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LectureRepository extends JpaRepositoryLlecture, Long> {
    List<Lecture> findById(long id);

     List<Lecture> findByLecturer(Lecturer lecturer);

}
