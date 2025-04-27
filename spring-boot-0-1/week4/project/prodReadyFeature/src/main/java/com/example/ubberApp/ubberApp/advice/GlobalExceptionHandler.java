package com.example.ubberApp.ubberApp.advice;

import com.example.ubberApp.ubberApp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErr> handledResourceNotFoundException(ResourceNotFoundException exception){
        ApiErr apiErr=new ApiErr(exception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiErr,HttpStatus.NOT_FOUND);
    }
}
