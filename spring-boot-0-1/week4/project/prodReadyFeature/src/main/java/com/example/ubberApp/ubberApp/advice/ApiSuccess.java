package com.example.ubberApp.ubberApp.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiSuccess {
    private LocalDateTime timeStamp;
    private String message;
    private HttpStatus httpStatus;
    private Object data; // Optional: To include data returned by the API

//   when you want to use this formate if value is not available for give post id
    public ApiSuccess(String message, HttpStatus httpStatus) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = null; // Initialize data as null by default
    }

    public ApiSuccess(String message, HttpStatus httpStatus, Object data) {
        this.timeStamp = LocalDateTime.now();
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
    }
}
