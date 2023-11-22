package com.example.demo.DataModel;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "mock_test_details")
public class MockTestInformation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (targetEntity = PaperSet.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "paper_sets",referencedColumnName = "id")
    private PaperSet paperSetId;

    private Long totalTime;

    private Long nofQuestions;

    private Long positiveMarking;

    private Long negativeMarking;

    private Long totalMarks;
}
