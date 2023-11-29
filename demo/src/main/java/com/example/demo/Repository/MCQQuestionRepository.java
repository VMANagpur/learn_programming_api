package com.example.demo.Repository;

import com.example.demo.DataModel.MCQQuestion;
import com.example.demo.DataModel.MockTestInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface MCQQuestionRepository extends JpaRepository<MCQQuestion, Long> {

    @Query("SELECT v FROM MCQQuestion  v WHERE v.paperSet.id = :PaperSetId")
    List<MCQQuestion> findByPaperSet(@Param("PaperSetId") Long id);

}
