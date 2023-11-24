package com.example.demo.Dto;

public class PrivacyDto {

    private String email;
    private String password;

    public PrivacyDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public PrivacyDto() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
