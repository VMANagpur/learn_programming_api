package com.example.demo.Controller;

import com.example.demo.DataModel.MockTestInformation;
import com.example.demo.DataModel.PaperSet;
import com.example.demo.Service.MockTestInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MockTestInformationController {

    @Autowired
    private MockTestInformationService mockTestInformationService;


    @GetMapping("/{mockTestId}")
    public ResponseEntity<?> mockTestDetails(@PathVariable Long mockTestId)
    {
        return mockTestInformationService.mockTestInformation(mockTestId);
    }
}
