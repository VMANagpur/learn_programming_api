package com.example.demo.Service;

import com.example.demo.DataModel.Feedback;
import com.example.demo.DataModel.User;
import com.example.demo.Repository.FeedbackRepository;
import com.example.demo.Repository.RegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    public Feedback saveFeedback(Long userId, String comment) {
        User user = registrationRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setComment(comment);

        return feedbackRepository.save(feedback);
    }
}
