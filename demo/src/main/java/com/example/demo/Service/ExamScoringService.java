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


}
