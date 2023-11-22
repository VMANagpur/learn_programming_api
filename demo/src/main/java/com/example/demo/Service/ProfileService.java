package com.example.demo.Service;

import com.example.demo.DataModel.User;
import com.example.demo.Dto.ProfileDto;
import com.example.demo.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public ProfileDto getUserProfile(Long userId) {
        User user = registrationRepository.findById(userId).orElse(null);
        if (user != null) {
            // Create a ProfileDto and populate it with user information
            ProfileDto profile = new ProfileDto();
            profile.setName(user.getName());
            profile.setEmail(user.getEmail());
            profile.setMobileNumber(String.valueOf(user.getMobileNumber()));
            profile.setUniversity(user.getUniversity());
            // You can add more fields as needed
            return profile;
        } else {
            return null;
        }
    }

    public ProfileDto updateUserProfile(Long userId, ProfileDto updatedProfile) {
        User user = registrationRepository.findById(userId).orElse(null);
        if (user != null) {
            // Update the user's profile information based on the updatedProfile DTO
            user.setName(updatedProfile.getName());
            user.setEmail(updatedProfile.getEmail());
            user.setMobileNumber(Long.parseLong(updatedProfile.getMobileNumber()));
            user.setUniversity(updatedProfile.getUniversity());

            // Save the updated user information
            registrationRepository.save(user);

            // Return the updated profile DTO
            return updatedProfile;
        } else {
            return null; // User not found
        }
    }

}
