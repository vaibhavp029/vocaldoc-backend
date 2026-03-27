package com.vocaldoc.controller;

import com.vocaldoc.dto.UserRequestDTO;
import com.vocaldoc.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.vocaldoc.model.User;
import com.vocaldoc.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO dto){

        return userService.addUser(dto);

    }

    @GetMapping("/users")
    public List<UserResponseDTO> getUsers(){

        return userService.getUsers();

    }

}