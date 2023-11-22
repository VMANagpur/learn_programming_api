package com.example.demo.Repository;

import com.example.demo.DataModel.MockTestInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface MockTestInformationRepository extends JpaRepository<MockTestInformation,Long> {

    @Query("SELECT v FROM MockTestInformation  v WHERE v.paperSetId.id = :PaperSetId")
    MockTestInformation findByPaperSetById(@Param("PaperSetId") Long id);

}
