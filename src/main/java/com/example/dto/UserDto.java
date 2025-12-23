package com.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}