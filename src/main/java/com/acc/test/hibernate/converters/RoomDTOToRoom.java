package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.RoomDTO;
import com.acc.test.hibernate.model.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomDTOToRoom implements Converter<RoomDTO, Room> {

    private final ReservationDTOToReservation reservationDTOToReservation;
    private final GameDTOToGame gameDTOToGame;

    public RoomDTOToRoom(ReservationDTOToReservation reservationDTOToReservation, GameDTOToGame gameDTOToGame) {
        this.reservationDTOToReservation = reservationDTOToReservation;
        this.gameDTOToGame = gameDTOToGame;
    }

    @Override
    public Room convert(RoomDTO source) {
        if(source == null){
            return null;
        }

        final Room room = new Room();
        room.setId(source.getId());
        room.setLocation(source.getLocation());
        room.setRoomName(source.getRoomName());
        room.setGames(source.getGames()
                .stream().map(gameDTOToGame::convert).collect(Collectors.toSet()));
        room.setReservations(source.getReservations()
                .stream().map(reservationDTOToReservation::convert).collect(Collectors.toSet()));

        return room;
    }
}
