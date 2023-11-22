package com.example.demo.Service;

import com.example.demo.DataModel.PaperSet;
import com.example.demo.Repository.PaperSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaperSetService {

    private final PaperSetRepository paperSetRepository;

    @Autowired
    public PaperSetService(PaperSetRepository paperSetRepository) {
        this.paperSetRepository = paperSetRepository;
    }

    public List<PaperSet> getAllPaperSets() {
        return paperSetRepository.findAll();
    }

    public Optional<PaperSet> getPaperSetById(Long id) {
        return paperSetRepository.findById(id);
    }

    public PaperSet createPaperSet(PaperSet paperSet) {
        return paperSetRepository.save(paperSet);
    }

    public PaperSet updatePaperSet(PaperSet paperSet) {
        return paperSetRepository.save(paperSet);
    }



    // Add methods for adding/removing questions to/from a paper set if needed


}
