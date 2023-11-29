package com.example.demo.Controller;

import com.example.demo.Dto.PrivacyDto;
import com.example.demo.Dto.ProfileDto;
import com.example.demo.Service.PrivacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/privacy")
public class PrivacyController {

    @Autowired
    private PrivacyService privacyService;

    @GetMapping("/{userId}")
    public ResponseEntity<PrivacyDto> getUserPrivacy(@PathVariable Long userId) {
        PrivacyDto privacy = privacyService.getUserPrivacy(userId);
        if (privacy != null) {
            return ResponseEntity.ok(privacy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<PrivacyDto> updateUserPrivacy(@PathVariable Long userId, @RequestBody PrivacyDto updatedPrivacy) {
        PrivacyDto updated = privacyService.updateUserPrivacy(userId, updatedPrivacy);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
