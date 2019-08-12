package com.acc.test.hibernate.DTOs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomInfo {
    private Long id;
    private String roomName;
    private String location;
}
