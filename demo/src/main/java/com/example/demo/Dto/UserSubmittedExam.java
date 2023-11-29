package com.example.demo.Dto;

import com.example.demo.DataModel.Answer;
import com.example.demo.DataModel.PaperSet;
import com.example.demo.DataModel.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSubmittedExam {

    private Long userId;
    private Long paperSetId;

    private List<ListAnswer>answers;


}
