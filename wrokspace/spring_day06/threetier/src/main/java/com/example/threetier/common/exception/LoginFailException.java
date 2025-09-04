package com.example.threetier.common.exception;

import org.springframework.stereotype.Component;

public class LoginFailException extends RuntimeException{
    public LoginFailException(){;}
    public LoginFailException(String message){
        super(message);
    }
}
