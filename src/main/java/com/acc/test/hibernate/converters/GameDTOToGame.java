package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.GameDTO;
import com.acc.test.hibernate.model.Game;
import com.acc.test.hibernate.repositories.RoomRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GameDTOToGame implements Converter<GameDTO, Game> {

    private final ReservationDTOToReservation reservationDTOToReservation;
    private final RoomRepository roomRepository;

    public GameDTOToGame(ReservationDTOToReservation reservationDTOToReservation, RoomRepository roomRepository) {
        this.reservationDTOToReservation = reservationDTOToReservation;
        this.roomRepository = roomRepository;
    }

    @Override
    public Game convert(GameDTO source) {
        if(source == null){
            return null;
        }

        final Game game = new Game();
        game.setId(source.getId());
        game.setName(source.getName());
        game.setReservations(source.getReservations()
                .stream().map(reservationDTOToReservation::convert).collect(Collectors.toSet()));
        game.setRoom(roomRepository.findById(source.getRoomInfo().getId()).get());

        return game;
    }
}
