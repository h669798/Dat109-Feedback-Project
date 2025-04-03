package org.example.demo.repository;

import org.example.demo.model.stats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Statistics findByLectureId(Long lectureId);
}
