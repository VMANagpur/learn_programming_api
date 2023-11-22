package com.example.demo.Controller;

import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learn_programming")
public class EmailController {

    @Autowired
    private EmailService emailService;



    @GetMapping("/api/verify")
    public String verifyEmail(@RequestParam("token") String token)
    {

        boolean verified = emailService.verifyByToken(token);
        if (verified)
        {
            return  "Your Account is verified";
        }

        return "please check url";
   }

}
