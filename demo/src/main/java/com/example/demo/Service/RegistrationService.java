package com.example.demo.Service;

import com.example.demo.DataModel.User;
import com.example.demo.DataModel.Verification;
import com.example.demo.Dto.ProfileDto;
import com.example.demo.Dto.RegistrationDto;
import com.example.demo.Dto.loginDto;
import com.example.demo.Repository.OtpRepository;
import com.example.demo.Repository.RegistrationRepository;
import com.example.demo.Response.LoginResponse;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<String> registration(RegistrationDto registrationDto) {
        User user = registrationRepository.findByEmail(registrationDto.getEmail());
        if (user != null) {
            return ResponseEntity.ok("user already Exit");
        }
        User newUser = new User(registrationDto.getId(), registrationDto.getName(), registrationDto.getEmail(),
                this.passwordEncoder.encode(registrationDto.getPassword()),
                registrationDto.getMobileNumber(),
                registrationDto.getUniversity());


        registrationRepository.save(newUser);

        Long id = newUser.getId();

        Verification verification = new Verification();
        verification.setVerificationtoken(UUID.randomUUID().toString());
        if (newUser !=  null) {
            verification.setUser_id(newUser);
        }

        verification.setIsenable(false);
        otpRepository.save(verification);

        String verificationlink = "http://192.168.29.112:8084/learn_programming/api/verify?token=" + verification.getVerificationtoken();


        emailService.sendEmail(newUser.getEmail(), "Verify Email Address for Learn Programming",
                "Click the link below to verify your email \n" + verificationlink);

        return ResponseEntity.ok("Registration Successful");
    }

    public LoginResponse loginUser(loginDto loginDto) {
        String msg = "";
        User user = registrationRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodePassword = user.getPassword();

            Long user_id = user.getId();

            Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
            if (isPwdRight) {
                Optional <User> user1 = registrationRepository.findByEmailAndPassword(loginDto.getEmail(),
                        loginDto.getPassword());

                Verification User_id = otpRepository.findByUser_id(user_id);

                Boolean isEnable = User_id.getIsenable();



                if (user1 != null && isEnable) {

                    return new LoginResponse("login Suceesful",true,user);

                }
              else if (isEnable == false) {
                    return new LoginResponse("Please verify your email address for login",false);
                }

           } else {
                return new LoginResponse("Password is invalid",false);
            }

      }
       else {
           return new LoginResponse("Email is not exit",false);
            }

        return null;

    }


}
