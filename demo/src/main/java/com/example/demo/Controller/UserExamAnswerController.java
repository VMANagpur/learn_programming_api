package com.example.demo.Controller;

import com.example.demo.DataModel.UserExamAnswer;
import com.example.demo.Service.UserExamAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/exam")
public class UserExamAnswerController {

    private final UserExamAnswerService userExamAnswerService;

    @Autowired
    public UserExamAnswerController(UserExamAnswerService userExamAnswerService) {
        this.userExamAnswerService = userExamAnswerService;
    }

    @PostMapping("/answers")
    public UserExamAnswer submitExamAnswers(@RequestBody UserExamAnswer userExamAnswer) {
        // Save the user's exam answers to the database
        return userExamAnswerService.saveUserExamAnswer(userExamAnswer);
    }


    @PostMapping("/submit-exam")
    public ResponseEntity<String> submitExam(@RequestBody UserExamAnswer userExamAnswer) {
        UserExamAnswer savedAnswer = userExamAnswerService.saveUserExamAnswer(userExamAnswer);

        // Calculate the current time
        LocalDateTime currentTime = LocalDateTime.now();

        // Check if the exam has expired
        if (currentTime.isAfter(savedAnswer.getExamStartTime().plus(savedAnswer.getTimeLimit()))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exam has expired and cannot be submitted.");
        }

        // The exam is still within the time limit, process the exam submission
        // ... (Process the submission and save the answers)

        return ResponseEntity.ok("Exam submitted successfully.");
    }


}
