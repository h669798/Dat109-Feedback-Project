package org.example.demo.repository;

import org.example.demo.model.Lecturer;
import org.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student, Long> {
Lecturer findByUsername(String username);

}
