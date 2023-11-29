package com.example.demo.Response;


import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class MockTestInformationResponse {


    private Time totalTime;

    private Long NoOfQuestions;

    private Long positiveMarking;

    private Long negativeMarking;

    private Long totalMarks;

    private Long  mockTestId;


}
