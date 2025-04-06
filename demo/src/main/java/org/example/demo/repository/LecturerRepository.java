package org.example.demo.repository;

import org.example.demo.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    Lecturer findByUsername(String username);

}
