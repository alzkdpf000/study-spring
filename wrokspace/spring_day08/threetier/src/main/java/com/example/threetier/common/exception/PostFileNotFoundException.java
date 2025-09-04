package com.example.threetier.common.exception;

public class PostFileNotFoundException extends RuntimeException{
    public PostFileNotFoundException(){;}
    public PostFileNotFoundException(String message){
        super(message);
    }
}
