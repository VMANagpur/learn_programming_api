package com.example.demo.Repository;

import com.example.demo.DataModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface RegistrationRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);


}
