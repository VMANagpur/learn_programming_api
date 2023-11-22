package com.example.demo.Service;

import com.example.demo.DataModel.Verification;
import com.example.demo.Repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmailService  {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OtpRepository otpRepository;

    public void sendEmail(String to,String subject,String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
         message.setTo(to);
         message.setSubject(subject);
         message.setText(body);

         javaMailSender.send(message);
    }

    public Boolean verifyByToken(String token)
    {
        Verification verificationToken = otpRepository.findByVerificationtoken(token);

       String token1 = verificationToken.getVerificationtoken();


        if (verificationToken != null)
        {
            verificationToken.setIsenable(true);
            otpRepository.save(verificationToken);
            return true;
        }

        return  false;

    }
}
