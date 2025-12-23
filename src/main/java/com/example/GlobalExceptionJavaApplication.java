package com.example;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor

public class GlobalExceptionJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalExceptionJavaApplication.class, args);
    }

    private final UserRepository userRepository;

    @Bean
    public ModelMapper createMap()
    {
        return new ModelMapper();
    }

    @PostConstruct
    void amitava()
    {
        userRepository.saveAll(
                List.of(UserEntity.builder().firstName("a").lastName("b").email("b@gmail.com").build(),
                        UserEntity.builder().firstName("aa").lastName("bb").email("bb@gmail.com").build(),
                        UserEntity.builder().firstName("aaa").lastName("bbb").email("bbb@gmail.com").build(),
                        UserEntity.builder().firstName("aaaa").lastName("bbbb").email("bbbb@gmail.com").build()));
        IO.println("-----------------------------------");
    }
}
