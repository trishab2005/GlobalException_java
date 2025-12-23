package com.example.service.impl;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.exception.EmailException;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper mapper;
    @Override
    public UserDto createUser(UserDto u) {
        Optional<UserEntity> o=userRepository.findByEmail(u.getEmail());
        if(o.isPresent()){
            throw new EmailException("dupilcate email can not save....");
        }

        UserEntity ue=mapper.map(u, UserEntity.class );
        return mapper.map( userRepository.save(ue), UserDto.class );
    }

    @Override
    public UserDto getUserByID(int id) {
        userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        return mapper.map( userRepository.findById(id).get(), UserDto.class );
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(e -> mapper.map(e, UserDto.class))
                .toList();
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        // assuming userDto contains the id
        Integer id = userDto.getId();

        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        existing.setFirstName(userDto.getFirstName());
        existing.setEmail(userDto.getEmail());
        // set other fields from userDto to existing

        UserEntity updated = userRepository.save(existing);
        return mapper.map(updated, UserDto.class);
    }

    @Override
    public String deleteUser(int id) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userRepository.delete(existing);
        return "User deleted successfully with id " + id;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email " + email));

        return mapper.map(user, UserDto.class);
    }

}