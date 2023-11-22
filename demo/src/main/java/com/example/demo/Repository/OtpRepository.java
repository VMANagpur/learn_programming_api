package com.example.demo.Repository;

import com.example.demo.DataModel.User;
import com.example.demo.DataModel.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OtpRepository extends JpaRepository<Verification,Long> {

    Verification findByVerificationtoken(String token);

    @Query("SELECT v FROM Verification v WHERE v.user_id.id = :userId")
    Verification findByUser_id(@Param("userId") Long user_id);
}
