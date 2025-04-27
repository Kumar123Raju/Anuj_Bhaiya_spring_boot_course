package com.example.ubberApp.ubberApp.advice;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiErr {
    private LocalDateTime timeStamp;
    private String error;
    private HttpStatus httpStatus;



    public ApiErr(String error,HttpStatus httpStatus){
        this.timeStamp=LocalDateTime.now();
        this.error=error;
        this.httpStatus=httpStatus;
    }


}
