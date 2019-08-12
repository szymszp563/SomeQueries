package com.acc.test.hibernate.controllers;

import com.acc.test.hibernate.services.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/usersa")
    public ResponseEntity<Object> getAllUsersArch(@RequestParam(required = true) Long max,
                                                  @RequestParam(required = true) Long min,
                                                  Sort sort){
        return new ResponseEntity<>(userService.findAllByAchievementPoints(max, min, sort), HttpStatus.OK);
    }

    @GetMapping("/usersr")
    public ResponseEntity<Object> findSpecUserFromSpecRoom(@RequestParam(required = true) String s,
                                                           @RequestParam(required = true) Long roomId){

        return new ResponseEntity<>(userService.findSpecificUserFromSpecificRoom(s, roomId), HttpStatus.OK);
    }
}
