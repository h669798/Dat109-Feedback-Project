package org.example.demo.repository;

import org.example.demo.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findByMobil(String mobil);
   
}
