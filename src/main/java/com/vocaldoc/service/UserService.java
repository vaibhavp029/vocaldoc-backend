package com.vocaldoc.service;

import com.vocaldoc.dto.LoginRequestDTO;
import com.vocaldoc.dto.UserRequestDTO;
import com.vocaldoc.dto.UserResponseDTO;
import com.vocaldoc.model.User;
import com.vocaldoc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponseDTO addUser(UserRequestDTO dto){

        if(userRepository.existsByEmail(dto.getEmail())){
            UserResponseDTO response = new UserResponseDTO();
            response.setMessage("Email already exists");
            response.setEmail(dto.getEmail());
            return response;
        }
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User savedUser = userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();

        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setMessage("User created successfully");

        return response;
    }

    public List<UserResponseDTO> getUsers(){

        List<User> users = userRepository.findAll();

        List<UserResponseDTO> responseList = new ArrayList<>();

        for(User user : users){

            UserResponseDTO dto = new UserResponseDTO();

            dto.setId(user.getId());
            dto.setEmail(user.getEmail());

            responseList.add(dto);
        }

        return responseList;
    }

    public UserResponseDTO login(String email, String password){

        UserResponseDTO response = new UserResponseDTO();
        User user = userRepository.findByEmail(email);

        if(user == null){
            response.setMessage("User not Found");
            return response;
        }

        if(!user.getPassword().equals(password)){
            response.setMessage("Wrong Password");
            return response;
        }
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setMessage("Login Successful");
        return response;

    }

}

