package com.example.demo.DataModel;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "mcq_questions")
public class MCQQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<MCQOption> options;

    // Getter and setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<MCQOption> getOptions() {
        return options;
    }

    public void setOptions(List<MCQOption> options) {
        this.options = options;
    }
}
