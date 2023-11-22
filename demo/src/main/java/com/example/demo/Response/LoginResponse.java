package com.example.demo.Response;

import com.example.demo.DataModel.User;
import com.example.demo.DataModel.UserExamAnswer;

public class LoginResponse {

    String message;
    Boolean status;

     User user;



    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginResponse(String message, boolean status, User user) {
        this.message = message;
        this.status = status;
        this.user = user;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
