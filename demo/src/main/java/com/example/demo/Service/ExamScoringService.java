package com.example.demo.Service;

import com.example.demo.DataModel.MCQOption;
import com.example.demo.DataModel.MCQQuestion;
import com.example.demo.DataModel.UserExamAnswer;
import com.example.demo.DataModel.UserExamScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamScoringService {

    @Autowired
    private MCQQuestionService questionService;
    @Autowired
    private UserExamAnswerService userExamAnswerService;
    @Autowired
    private UserExamScoreService userExamScoreService; // Add this field

    public int calculateUserScore(Long userId, List<UserExamAnswer> userAnswers) {
        // Fetch correct answers from the database or another source
        List<MCQQuestion> questions = questionService.getAllQuestions();

        // Initialize a variable to keep track of the user's score
        int userScore = 0;

        for (UserExamAnswer userAnswer : userAnswers) {
            // Find the corresponding question for the user's answer
            Optional<MCQQuestion> questionOptional = questions.stream()
                    .filter(q -> q.getId().equals(userAnswer.getQuestion().getId()))
                    .findFirst();

            if (questionOptional.isPresent()) {
                MCQQuestion question = questionOptional.get();
                // Compare the user's selected option with the correct answer
                Long correctOptionId = question.getOptions().stream()
                        .filter(MCQOption::isCorrect)
                        .map(MCQOption::getId)
                        .findFirst()
                        .orElse(null);

                if (correctOptionId != null && correctOptionId.equals(userAnswer.getSelectedOptionId())) {
                    // Increase the user's score for a correct answer
                    userScore += 1; // You can assign different scores for different questions
                }
            }
        }

        // Store the user's score in the database or wherever you track exam results
        UserExamScore userExamScore = new UserExamScore();
        userExamScore.setUserId(userId);
        userExamScore.setScore(userScore);
        userExamScoreService.saveUserExamScore(userExamScore);

        return userScore;
    }

}
