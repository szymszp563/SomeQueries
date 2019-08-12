package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.ReservationDTO;
import com.acc.test.hibernate.model.Reservation;
import com.acc.test.hibernate.repositories.GameRepository;
import com.acc.test.hibernate.repositories.RoomRepository;
import com.acc.test.hibernate.repositories.UserRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReservationDTOToReservation implements Converter<ReservationDTO, Reservation> {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final GameRepository gameRepository;

    public ReservationDTOToReservation(UserRepository userRepository, RoomRepository roomRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Reservation convert(ReservationDTO source) {
        if(source == null){
            return null;
        }

        final Reservation reservation = new Reservation();
        reservation.setId(source.getId());
        reservation.setRoom(roomRepository
                .findById(source.getRoomInfo().getId()).get());
        reservation.setGame(gameRepository
                .findById(source.getGameInfo().getId()).get());
        reservation.setUser(userRepository
                .findById(source.getUserInfo().getId()).get());
        reservation.setFrom(source.getFrom());
        reservation.setTo(source.getTo());
        reservation.setReservationTime(source.getReservationTime());

        return reservation;
    }
}
