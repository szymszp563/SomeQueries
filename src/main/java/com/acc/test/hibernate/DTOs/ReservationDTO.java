package com.acc.test.hibernate.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {
    private Long id;
    private LocalDateTime reservationTime;
    private LocalDateTime from;
    private LocalDateTime to;
    private UserInfo userInfo;
    private RoomInfo roomInfo;
    private GameInfo gameInfo;
}
