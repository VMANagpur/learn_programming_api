package com.example.demo;

public class UserAlredyExitException extends RuntimeException {

    public UserAlredyExitException(String message){
        super(message);
    }

}
