package com.example.demo.Repository;

import com.example.demo.DataModel.MCQQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface MCQQuestionRepository extends JpaRepository<MCQQuestion, Long> {

}
