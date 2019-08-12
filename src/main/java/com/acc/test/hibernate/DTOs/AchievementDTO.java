package com.acc.test.hibernate.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AchievementDTO {

    private Long id;
    private String name;
    private Integer points;
}
