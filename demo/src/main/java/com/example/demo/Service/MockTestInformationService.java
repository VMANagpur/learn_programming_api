package com.example.demo.Service;

import com.example.demo.DataModel.MockTestInformation;
import com.example.demo.Repository.MockTestInformationRepository;
import com.example.demo.Response.MockTestInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MockTestInformationService {

    @Autowired
    private MockTestInformationRepository mockTestInformationRepository;

    @Autowired
    private MockTestInformationResponse mockTestInformationResponse;

    public ResponseEntity<?> mockTestInformation(Long mockTestId)
    {
        MockTestInformation mockTestInformation = mockTestInformationRepository.findByPaperSetById(mockTestId);
        if (mockTestInformation != null)
        {
            mockTestInformationResponse.setTotalTime(mockTestInformation.getTotalTime());
            mockTestInformationResponse.setNegativeMarking(mockTestInformation.getNegativeMarking());
            mockTestInformationResponse.setNoOfQuestions(mockTestInformation.getNofQuestions());
            mockTestInformationResponse.setPositiveMarking(mockTestInformation.getPositiveMarking());
            mockTestInformationResponse.setTotalMarks(mockTestInformation.getTotalMarks());
            mockTestInformationResponse.setMockTestId(mockTestInformation.getPaperSetId().getId());

            return new ResponseEntity<>(mockTestInformationResponse,HttpStatus.OK);
        }

        return new ResponseEntity<>("the paper set is not exit",HttpStatus.NOT_FOUND);
    }
}
