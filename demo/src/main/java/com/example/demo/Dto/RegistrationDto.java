package com.example.demo.Dto;


import java.util.Date;

public class RegistrationDto {

    private Long id;

    private String name;
    private String email;
    private String password;
    private Long MobileNumber;
    private  String university;

    public RegistrationDto() {
    }

    public RegistrationDto(Long id, String name, String email, String password, Long mobileNumber, String university) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        MobileNumber = mobileNumber;
        this.university = university;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public RegistrationDto(String name, String email, String password, Long mobileNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        MobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", MobileNumber=" + MobileNumber +
                ", university='" + university + '\'' +
                '}';
    }
}
