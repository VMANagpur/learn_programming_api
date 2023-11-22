package com.example.demo.Repository;

import com.example.demo.DataModel.UserExamAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExamAnswerRepository extends JpaRepository<UserExamAnswer, Long> {

}
