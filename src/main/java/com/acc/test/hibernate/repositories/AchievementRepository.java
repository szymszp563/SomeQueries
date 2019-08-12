package com.acc.test.hibernate.repositories;

import com.acc.test.hibernate.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    Optional<Achievement> findById(Long id);
}
