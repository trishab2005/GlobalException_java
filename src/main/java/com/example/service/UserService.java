package com.example.service;

import com.example.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto u);
    UserDto getUserByID(int id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    String deleteUser(int id);
    UserDto getUserByEmail(String email);

}