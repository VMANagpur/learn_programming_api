package com.example.demo.DataModel;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user_exam_answers")

public class UserExamAnswer {
    // Getter and setter methods for 'id'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Getter and setter methods for 'question'
    @ManyToOne
    @JoinColumn(name = "question_id")
    private MCQQuestion question; // Link to the corresponding question

    // Getter and setter methods for 'userId'
    private Long userId; // Store the user's ID
    // Getter and setter methods for 'selectedOptionId'
    private Long selectedOptionId; // Store the ID of the selected answer option

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(MCQQuestion question) {
        this.question = question;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setSelectedOptionId(Long selectedOptionId) {
        this.selectedOptionId = selectedOptionId;
    }






    private LocalDateTime examStartTime;

    private Duration timeLimit; // Store the time limit for the exam

    // Getter and setter methods for the new fields

    public LocalDateTime getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(LocalDateTime examStartTime) {
        this.examStartTime = examStartTime;
    }

    public Duration getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Duration timeLimit) {
        this.timeLimit = timeLimit;
    }





}
