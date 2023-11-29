package com.example.demo.DataModel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "mcq_questions")
    MCQQuestion question;

    @ManyToOne
    @JoinColumn(name = "mcq_options")
    MCQOption correctOption;



}
