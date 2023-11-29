package com.example.demo.DataModel;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_exam_answer")
public class UserExamAnswer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "paper_sets")
    PaperSet paperSet;

    @ManyToOne
    @JoinColumn(name = "userdetail")
    User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_answer_id")
    List<Answer>answers;

    LocalDateTime submissionTime;
}
