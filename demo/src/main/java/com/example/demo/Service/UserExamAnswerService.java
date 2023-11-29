package com.example.demo.Service;

import com.example.demo.DataModel.*;
import com.example.demo.Dto.ListAnswer;
import com.example.demo.Dto.UserSubmittedExam;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserExamAnswerService {

    @Autowired
    private  UserExamAnswerRepository userExamAnswerRepository;

    @Autowired
    private RegistrationRepository userRepository;

    @Autowired
    private PaperSetRepository paperSetRepository;

    @Autowired
    private MCQQuestionRepository mcqQuestionRepository;

    @Autowired
    private OptionRepository optionRepository;

    public ResponseEntity<?> submitUserExam(UserSubmittedExam userExamAnswers)
    {
        Optional<User> user = userRepository.findById(userExamAnswers.getUserId());

        Optional<PaperSet> paperSet = paperSetRepository.findById(userExamAnswers.getPaperSetId());

        if (user.isPresent() && paperSet.isPresent())
        {
             User getUser = user.get();
             PaperSet getPaperSet = paperSet.get();

             UserExamAnswer userAnswer = new UserExamAnswer();
             userAnswer.setPaperSet(getPaperSet);
             userAnswer.setUser(getUser);
             userAnswer.setSubmissionTime(LocalDateTime.now());



              List<Answer> answerList = new ArrayList<>();

             for (ListAnswer listAnswer: userExamAnswers.getAnswers())
             {
                Optional<MCQQuestion> mcqQuestion = mcqQuestionRepository.findById(listAnswer.getQuestionId());
                Optional<MCQOption> mcqOption = optionRepository.findById(listAnswer.getOptionId());

                if (mcqQuestion.isPresent())
                {
                     MCQQuestion getQuestion = mcqQuestion.get();

                     if (mcqOption.isPresent()) {
                         MCQOption getOption = mcqOption.get();

                         Answer answer = new Answer();
                         answer.setQuestion(getQuestion);
                         answer.setCorrectOption(getOption);

                         answerList.add(answer);
                         System.out.println(answer);
                     } else  {
                         Answer answer = new Answer();
                         answer.setQuestion(getQuestion);
                         answer.setCorrectOption(null);
                         answerList.add(answer);
                     }
                }
                else
                {
                    return new ResponseEntity<>("Question is not exit ",HttpStatus.NOT_FOUND);
                }

             }
             userAnswer.setAnswers(answerList);
        //    System.out.println(answerList);
             userExamAnswerRepository.save(userAnswer);

             return new ResponseEntity<>("User Answer Submited",HttpStatus.OK);

        }

            return new ResponseEntity<>("User And Paper Set Not Found",HttpStatus.NOT_FOUND);

    }


    //user we be give attempt at one day only 3
    public String canUserAttemptTest(Long userId, Long paperId)
    {
        try {
         //   List<UserExamAnswer> userGivenTest = userExamAnswerRepository.findByUser(userId);
          //  List<UserExamAnswer> paperGiven = userExamAnswerRepository.findByPaperSet(paperId);

            LocalDate date = LocalDate.now();

            List<UserExamAnswer> userAndPaperSet = userExamAnswerRepository.findByUserAndPaperSet(userId,paperId,date);

            if (userAndPaperSet !=null && userAndPaperSet.size()>=3)
            {
                System.out.println(userAndPaperSet);
                 return "user limit for day is completed";
            }
            else if (userAndPaperSet == null) {
                return "sorry,paper is not exit";
            }

            return "user will eligible for test";
        }
        catch (Exception e)
        {
            return  null;
        }
    }

}
