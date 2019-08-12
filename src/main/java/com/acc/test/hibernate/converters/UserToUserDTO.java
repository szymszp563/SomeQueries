package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.UserDTO;
import com.acc.test.hibernate.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserToUserDTO implements Converter<User, UserDTO> {

    private final ReservationToReservationDTO reservationToReservationDTO;
    private final AchievementToAchievementDTO achievementToAchievementDTO;

    public UserToUserDTO(ReservationToReservationDTO reservationToReservationDTO, AchievementToAchievementDTO achievementToAchievementDTO) {
        this.reservationToReservationDTO = reservationToReservationDTO;
        this.achievementToAchievementDTO = achievementToAchievementDTO;
    }

    @Override
    public UserDTO convert(User source) {
        if(source == null){
            return null;
        }

        final UserDTO userDTO = new UserDTO();
        userDTO.setId(source.getId());
        userDTO.setAchievements(source.getAchievements()
                .stream().map(achievementToAchievementDTO::convert).collect(Collectors.toSet()));
        userDTO.setFirstName(source.getFirstName());
        userDTO.setLastName(source.getLastName());
        userDTO.setReservations(source.getReservations()
                .stream().map(reservationToReservationDTO::convert).collect(Collectors.toSet()));

        return userDTO;
    }
}
