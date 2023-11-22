package com.example.demo.Repository;

import com.example.demo.DataModel.UserExamScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserExamScoreRepository extends JpaRepository<UserExamScore, Long> {
    UserExamScore findByUserId(Long userId);

}
