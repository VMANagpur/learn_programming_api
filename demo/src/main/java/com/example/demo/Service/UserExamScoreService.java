package com.example.demo.Service;

import com.example.demo.DataModel.UserExamScore;
import com.example.demo.Repository.UserExamScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserExamScoreService {


    private final UserExamScoreRepository userExamScoreRepository;

    @Autowired
    public UserExamScoreService(UserExamScoreRepository userExamScoreRepository) {
        this.userExamScoreRepository = userExamScoreRepository;
    }

    public UserExamScore saveUserExamScore(UserExamScore userExamScore) {
        return userExamScoreRepository.save(userExamScore);
    }

    public UserExamScore getUserScoreByUserId(Long userId) {
        // Implement the logic to retrieve the user's score by their user ID
        return userExamScoreRepository.findByUserId(userId);
    }

    // Add any other methods you need for managing user exam scores

}
