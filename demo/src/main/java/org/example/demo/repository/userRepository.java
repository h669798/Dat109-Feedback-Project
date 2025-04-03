package org.example.demo.repository;

import org.example.demo.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Int> {
    Optional<User> findByMobil(String mobil);
}
