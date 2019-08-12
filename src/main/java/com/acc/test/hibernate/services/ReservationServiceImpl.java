package com.acc.test.hibernate.services;

import com.acc.test.hibernate.DTOs.ReservationDTO;
import com.acc.test.hibernate.converters.ReservationToReservationDTO;
import com.acc.test.hibernate.model.Reservation;
import com.acc.test.hibernate.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationToReservationDTO reservationToReservationDTO;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationToReservationDTO reservationToReservationDTO) {
        this.reservationRepository = reservationRepository;
        this.reservationToReservationDTO = reservationToReservationDTO;
    }

    @Override
    public List<ReservationDTO> findByFromBetween(LocalDateTime from, LocalDateTime to) {
        List<Reservation> reservations = reservationRepository.findByFromBetween(from, to);

        return reservations.stream()
                .map(reservationToReservationDTO::convert)
                .collect(Collectors.toList());
    }
}
