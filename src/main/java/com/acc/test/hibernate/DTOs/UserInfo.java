package com.acc.test.hibernate.DTOs;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfo {
    private Long id;
    private String firstName;
    private String lastName;
}
