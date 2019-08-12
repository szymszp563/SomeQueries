package com.acc.test.hibernate.DTOs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameInfo {
    private Long id;
    private String name;
}
