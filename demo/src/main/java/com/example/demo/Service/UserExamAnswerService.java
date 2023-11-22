package com.example.demo.Service;

import com.example.demo.DataModel.UserExamAnswer;
import com.example.demo.Repository.UserExamAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class UserExamAnswerService {

    private final UserExamAnswerRepository userExamAnswerRepository;

    @Autowired
    public UserExamAnswerService(UserExamAnswerRepository userExamAnswerRepository) {
        this.userExamAnswerRepository = userExamAnswerRepository;
    }

    public UserExamAnswer saveUserExamAnswer(UserExamAnswer userExamAnswer) {
        return userExamAnswerRepository.save(userExamAnswer);
    }


    public UserExamAnswer startExam(UserExamAnswer userExamAnswer, Duration timeLimit) {
        userExamAnswer.setExamStartTime(LocalDateTime.now());
        userExamAnswer.setTimeLimit(timeLimit);
        return userExamAnswerRepository.save(userExamAnswer);
    }


}
