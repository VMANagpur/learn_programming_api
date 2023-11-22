package com.example.demo.Response;


import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class MockTestInformationResponse {


    private Long totalTime;

    private Long NoOfQuestions;

    private Long positiveMarking;

    private Long negativeMarking;

    private Long totalMarks;



}
