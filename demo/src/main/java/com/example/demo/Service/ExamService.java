package com.example.demo.Service;

import com.example.demo.DataModel.MCQQuestion;
import com.example.demo.Repository.MCQQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final MCQQuestionRepository questionRepository;

    @Autowired
    public ExamService(MCQQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<MCQQuestion> getExamQuestions() {

        // Implement the logic to fetch exam questions from the repository (database).

        return questionRepository.findAll();
    }

}
