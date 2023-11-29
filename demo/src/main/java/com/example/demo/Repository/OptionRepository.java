package com.example.demo.Repository;

import com.example.demo.DataModel.MCQOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OptionRepository extends JpaRepository<MCQOption,Long> {
}
