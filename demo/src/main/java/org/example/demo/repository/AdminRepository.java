package org.example.demo.repository;

import org.example.demo.model.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Int> {
    Optional<Admin> findByMobil(String mobil);
    Admin findByUsername(String username);
}
