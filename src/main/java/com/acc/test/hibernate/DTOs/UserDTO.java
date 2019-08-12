package com.acc.test.hibernate.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<ReservationDTO> reservations;
    private Set<AchievementDTO> achievements;
}
