package com.acc.test.hibernate.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO {
    private Long id;
    private String roomName;
    private String location;
    private Set<ReservationDTO> reservations;
    private Set<GameDTO> games;
}
