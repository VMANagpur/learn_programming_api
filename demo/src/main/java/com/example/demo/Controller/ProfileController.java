package com.example.demo.Controller;


import com.example.demo.Dto.ProfileDto;
import com.example.demo.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{userId}") // Use a path variable to specify the user's ID
    public ResponseEntity<ProfileDto> getUserProfile(@PathVariable Long userId) {
        ProfileDto profile = profileService.getUserProfile(userId);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{userId}")
    public ResponseEntity<ProfileDto> updateUserProfile(@PathVariable Long userId, @RequestBody ProfileDto updatedProfile) {
        ProfileDto updated = profileService.updateUserProfile(userId, updatedProfile);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
