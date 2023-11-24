package com.example.demo.Service;

import com.example.demo.DataModel.User;
import com.example.demo.Dto.PrivacyDto;
import com.example.demo.Dto.ProfileDto;
import com.example.demo.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PrivacyService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public PrivacyDto getUserPrivacy(Long userId) {
        User user = registrationRepository.findById(userId).orElse(null);
        if (user != null) {
            // Create a ProfileDto and populate it with user information
            PrivacyDto privacy = new PrivacyDto();
            privacy.setEmail(user.getEmail());
            privacy.setPassword(user.getPassword());
            // You can add more fields as needed
            return privacy;
        } else {
            return null;
        }
    }

    public PrivacyDto updateUserPrivacy(Long userId, PrivacyDto updatedPrivacy) {
        User user = registrationRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setEmail(updatedPrivacy.getEmail());
//            user.setPassword(updatedPrivacy.getPassword());
           user.setPassword(passwordEncoder.encode(updatedPrivacy.getPassword()));
            registrationRepository.save(user);

            return updatedPrivacy;
        } else {
            return null;
        }
    }


}
