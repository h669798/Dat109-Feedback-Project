package org.example.demo.repository;

import java.util.Optional;

import org.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

Optional<User> findById(Long id);


}
