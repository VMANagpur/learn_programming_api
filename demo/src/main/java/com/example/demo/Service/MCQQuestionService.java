package com.example.demo.Service;

import com.example.demo.DataModel.MCQOption;
import com.example.demo.DataModel.MCQQuestion;
import com.example.demo.Repository.MCQQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MCQQuestionService {
    private final MCQQuestionRepository questionRepository;

    @Autowired
    public MCQQuestionService(MCQQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<MCQQuestion> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<MCQQuestion> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public MCQQuestion createQuestion(MCQQuestion question) {
        return questionRepository.save(question);
    }

    public MCQQuestion updateQuestion(MCQQuestion question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
