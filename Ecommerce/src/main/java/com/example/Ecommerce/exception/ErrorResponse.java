package com.example.Ecommerce.exception;


import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    public ErrorResponse(int status,String message){
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
