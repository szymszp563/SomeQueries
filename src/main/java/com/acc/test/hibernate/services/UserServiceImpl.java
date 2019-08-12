package com.acc.test.hibernate.services;

import com.acc.test.hibernate.DTOs.UserDTO;
import com.acc.test.hibernate.converters.UserDTOToUser;
import com.acc.test.hibernate.converters.UserToUserDTO;
import com.acc.test.hibernate.model.User;
import com.acc.test.hibernate.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserDTO userToUserDTO;
    private final UserDTOToUser userDTOToUser;

    public UserServiceImpl(UserRepository userRepository, UserToUserDTO userToUserDTO, UserDTOToUser userDTOToUser) {
        this.userRepository = userRepository;
        this.userToUserDTO = userToUserDTO;
        this.userDTOToUser = userDTOToUser;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userToUserDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<Object[]> findAllByAchievementPoints(Long max, Long min, Sort sort) {
       return userRepository.findAllByAchievementPoints(max, min, sort);
    }

    @Override
    public List<UserDTO> findSpecificUserFromSpecificRoom(String s, Long roomId) {
        List<User> users = userRepository.findSpecificUserFromSpecificRoom(s, roomId);

        return users.stream()
                .map(userToUserDTO::convert)
                .collect(Collectors.toList());
    }


}
