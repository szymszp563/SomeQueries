package com.acc.test.hibernate.converters;

import com.acc.test.hibernate.DTOs.UserDTO;
import com.acc.test.hibernate.model.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserDTOToUser implements Converter<UserDTO, User> {

    private final ReservationDTOToReservation reservationDTOToReservation;
    private final AchievementDTOToAchievement achievementDTOToAchievement;

    public UserDTOToUser(ReservationDTOToReservation reservationDTOToReservation, AchievementDTOToAchievement achievementDTOToAchievement) {
        this.reservationDTOToReservation = reservationDTOToReservation;
        this.achievementDTOToAchievement = achievementDTOToAchievement;
    }

    @Synchronized
    @Nullable
    @Override
    public User convert(UserDTO source) {
        if(source == null){
            return null;
        }

        final User user = new User();
        user.setId(source.getId());
        user.setAchievements(source.getAchievements()
                .stream().map(achievementDTOToAchievement::convert).collect(Collectors.toSet()));
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setReservations(source.getReservations()
                .stream().map(reservationDTOToReservation::convert).collect(Collectors.toSet()));

        return user;
    }
}
