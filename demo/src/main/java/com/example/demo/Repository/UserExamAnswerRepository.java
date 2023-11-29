package com.example.demo.Repository;

import com.example.demo.DataModel.UserExamAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserExamAnswerRepository extends JpaRepository<UserExamAnswer, Long> {

    @Query("SELECT v FROM UserExamAnswer v WHERE v.paperSet.id= :PaperSet")
    List<UserExamAnswer> findByUser(@Param("PaperSet") Long userId);

    @Query("SELECT v FROM UserExamAnswer v WHERE v.user.id= :User")
    List<UserExamAnswer> findByPaperSet(@Param("User") Long paperId);



    @Query("SELECT v FROM UserExamAnswer v WHERE v.user.id= :User AND v.paperSet.id= :PaperSet AND DATE(v.submissionTime)= :date")
    List<UserExamAnswer> findByUserAndPaperSet(@Param("User")Long userId, @Param("PaperSet")Long paperId, @Param("date")LocalDate date);

}
