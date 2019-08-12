package com.acc.test.hibernate.services;

import com.acc.test.hibernate.DTOs.UserDTO;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    List<Object[]> findAllByAchievementPoints(Long max, Long min, Sort sort);

    List<UserDTO> findSpecificUserFromSpecificRoom(String s, Long roomId);
}
