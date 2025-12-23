package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProperlyData(ResourceNotFoundException r, WebRequest req)
    {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                r.getMessage(),
                req.getDescription(true),
                "!!!!!ORACLE23 AI USER_NOT_FOUND_FROM_DB!!!!!!"
        );
        return   new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorDetails> handleProperlyTest(EmailException r, WebRequest req)
    {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                r.getMessage(),
                req.getDescription(true),
                "!!!!!Duplicate Email from Oracle 23AI!!!!!!"
        );
        return   new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                e.getMessage(),
                webRequest.getDescription(true),
                "!!!!!-------------------OTHER EXCEPTIONS-----------!!!!!!"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}