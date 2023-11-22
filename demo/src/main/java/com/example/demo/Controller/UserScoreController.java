package com.example.demo.Controller;

import com.example.demo.DataModel.UserExamScore;
import com.example.demo.Service.UserExamScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user-scores")
public class UserScoreController {


    @Autowired
    private UserExamScoreService userExamScoreService;

//     Define an endpoint to check the user's score by user ID
    @GetMapping("/check")
    public UserExamScore checkUserScore(@RequestParam Long userId) {
        // Call the service to retrieve the user's score by user ID

        return userExamScoreService.getUserScoreByUserId(userId);
    }

}
