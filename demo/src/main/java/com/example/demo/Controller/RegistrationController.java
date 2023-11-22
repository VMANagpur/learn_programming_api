package com.example.demo.Controller;

import com.example.demo.Dto.RegistrationDto;
import com.example.demo.Dto.loginDto;
import com.example.demo.Response.LoginResponse;
import com.example.demo.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @PostMapping("/registration")
     public ResponseEntity<?> createUser(@RequestBody RegistrationDto registrationDto)
     {
         return registrationService.registration(registrationDto);
     }


     @PostMapping("/login")
     public LoginResponse loginUser(@RequestBody loginDto loginDto)
     {
          LoginResponse loginResponse =registrationService.loginUser(loginDto);
          return  loginResponse;
     }


}
