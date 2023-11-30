package com.example.demo.Controller;

import com.example.demo.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/feedback")
@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(
            @RequestParam Long userId,
            @RequestParam String comment) {
        feedbackService.saveFeedback(userId, comment);
        return ResponseEntity.ok("Feedback submitted successfully");
    }
}
