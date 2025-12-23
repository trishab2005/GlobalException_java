package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailException extends RuntimeException{
    private  String message;
    public EmailException(String message) {
        super(message);
    }
}