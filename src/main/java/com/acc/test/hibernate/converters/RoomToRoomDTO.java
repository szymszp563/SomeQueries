package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.RoomDTO;
import com.acc.test.hibernate.model.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomToRoomDTO implements Converter<Room, RoomDTO> {

    private final GameToGameDTO gameToGameDTO;
    private final ReservationToReservationDTO reservationToReservationDTO;

    public RoomToRoomDTO(GameToGameDTO gameToGameDTO, ReservationToReservationDTO reservationToReservationDTO) {
        this.gameToGameDTO = gameToGameDTO;
        this.reservationToReservationDTO = reservationToReservationDTO;
    }

    @Override
    public RoomDTO convert(Room source) {
        if(source == null){
            return null;
        }

        final RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(source.getId());
        roomDTO.setLocation(source.getLocation());
        roomDTO.setRoomName(source.getRoomName());
        roomDTO.setGames(source.getGames()
                .stream().map(gameToGameDTO::convert).collect(Collectors.toSet()));
        roomDTO.setReservations(source
                .getReservations().stream().map(reservationToReservationDTO::convert).collect(Collectors.toSet()));

        return roomDTO;
    }
}
