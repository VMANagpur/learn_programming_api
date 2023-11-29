package com.example.demo.Controller;

import com.example.demo.Dto.UserSubmittedExam;
import com.example.demo.Service.UserExamAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserExamAnswerController {

    @Autowired
    private  UserExamAnswerService userExamAnswerService;

    @PostMapping("/submitUserAnswer")
    public ResponseEntity<?> submitedUserExam(@RequestBody UserSubmittedExam userExamAnswers)
    {
       return userExamAnswerService.submitUserExam(userExamAnswers);

    }


    @GetMapping("/canAttempt")
    public String canUserAttemptTheTestOrNot(@RequestParam Long userId, @RequestParam Long paperId)
    {
            return userExamAnswerService.canUserAttemptTest(userId,paperId);
    }


}
