package com.example.demo.Controller;

import com.example.demo.DataModel.MCQQuestion;
import com.example.demo.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @GetMapping("/questions")
    public List<MCQQuestion> getExamQuestions() {
        return examService.getExamQuestions();
    }


    @GetMapping("/{mocktestquestion}")
    public List<MCQQuestion> getExamQuestionByMockTestId(@PathVariable Long mocktestquestion)
    {
       return  examService.getExamQuestionByMockTestId(mocktestquestion);

    }

}
