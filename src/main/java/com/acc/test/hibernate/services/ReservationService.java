package com.acc.test.hibernate.services;

import com.acc.test.hibernate.DTOs.ReservationDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

    List<ReservationDTO> findByFromBetween(LocalDateTime from, LocalDateTime to);
}
