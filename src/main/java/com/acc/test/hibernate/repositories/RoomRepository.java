package com.acc.test.hibernate.repositories;

import com.acc.test.hibernate.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findById(Long id);
}
