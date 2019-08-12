package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.GameInfo;
import com.acc.test.hibernate.DTOs.ReservationDTO;
import com.acc.test.hibernate.DTOs.RoomInfo;
import com.acc.test.hibernate.DTOs.UserInfo;
import com.acc.test.hibernate.model.Game;
import com.acc.test.hibernate.model.Reservation;
import com.acc.test.hibernate.model.Room;
import com.acc.test.hibernate.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReservationToReservationDTO implements Converter<Reservation, ReservationDTO> {
    @Override
    public ReservationDTO convert(Reservation source) {
        if(source == null){
            return null;
        }

        final ReservationDTO reservationDTO = new ReservationDTO();
        User userData = source.getUser();
        Room roomData = source.getRoom();
        Game gameData = source.getGame();
        UserInfo userInfo = UserInfo.builder()
                .id(userData.getId()).firstName(userData.getFirstName()).lastName(userData.getLastName()).build();
        RoomInfo roomInfo = RoomInfo.builder()
                .id(roomData.getId()).roomName(roomData.getRoomName()).location(roomData.getLocation()).build();
        GameInfo gameInfo = GameInfo.builder()
                .id(gameData.getId()).name(gameData.getName()).build();
        reservationDTO.setId(source.getId());
        reservationDTO.setRoomInfo(roomInfo);
        reservationDTO.setGameInfo(gameInfo);
        reservationDTO.setUserInfo(userInfo);
        reservationDTO.setFrom(source.getFrom());
        reservationDTO.setTo(source.getTo());
        reservationDTO.setReservationTime(source.getReservationTime());

        return reservationDTO;
    }
}
