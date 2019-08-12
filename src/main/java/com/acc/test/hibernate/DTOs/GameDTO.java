package com.acc.test.hibernate.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String name;
    private Set<ReservationDTO> reservations;
    private RoomInfo roomInfo;
}
