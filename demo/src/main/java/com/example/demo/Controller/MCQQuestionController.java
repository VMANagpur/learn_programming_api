package com.example.demo.Controller;

import com.example.demo.DataModel.MCQQuestion;
import com.example.demo.Service.MCQQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class MCQQuestionController {

    private final MCQQuestionService questionService;

    @Autowired
    public MCQQuestionController(MCQQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<MCQQuestion> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public MCQQuestion getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id)
                .orElse(null);
    }

    @PostMapping
    public MCQQuestion createQuestion(@RequestBody MCQQuestion question) {
        return questionService.createQuestion(question);
    }

    @PutMapping
    public MCQQuestion updateQuestion(@RequestBody MCQQuestion question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

}
