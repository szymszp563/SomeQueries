package com.acc.test.hibernate.repositories;

import com.acc.test.hibernate.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findById(Long id);

    List<Reservation> findByFromBetween(LocalDateTime from, LocalDateTime to);
}
