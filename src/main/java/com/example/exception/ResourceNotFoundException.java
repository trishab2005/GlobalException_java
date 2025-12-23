package com.example.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)


public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Integer fieldValue;

    public ResourceNotFoundException(String resourceName) {
    }

    public ResourceNotFoundException(String resourceName,String fieldName, Integer fieldValue ) {
        super(String.format("%s not found with %s : '%s' ",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }
}