package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.GameDTO;
import com.acc.test.hibernate.DTOs.RoomInfo;
import com.acc.test.hibernate.model.Game;
import com.acc.test.hibernate.model.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GameToGameDTO implements Converter<Game, GameDTO> {

    private final ReservationToReservationDTO reservationToReservationDTO;

    public GameToGameDTO(ReservationToReservationDTO reservationToReservationDTO) {
        this.reservationToReservationDTO = reservationToReservationDTO;
    }

    @Override
    public GameDTO convert(Game source) {
        if(source == null){
            return null;
        }

        final GameDTO gameDTO = new GameDTO();
        Room room = source.getRoom();
        gameDTO.setId(source.getId());
        gameDTO.setName(source.getName());
        gameDTO.setReservations(source.getReservations()
                .stream().map(reservationToReservationDTO::convert).collect(Collectors.toSet()));
        gameDTO.setRoomInfo(RoomInfo.builder()
                .id(room.getId()).location(room.getLocation()).roomName(room.getRoomName()).build());

        return gameDTO;
    }
}
