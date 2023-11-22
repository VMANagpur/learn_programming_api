package com.example.demo.Controller;

import com.example.demo.DataModel.PaperSet;
import com.example.demo.Service.PaperSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paper-sets")
public class PaperSetController {

    private final PaperSetService paperSetService;

    @Autowired
    public PaperSetController(PaperSetService paperSetService) {
        this.paperSetService = paperSetService;
    }

    @GetMapping
    public List<PaperSet> getAllPaperSets() {
        return paperSetService.getAllPaperSets();
    }

    @GetMapping("/{id}")
    public Optional<PaperSet> getPaperSetById(@PathVariable Long id) {
        return paperSetService.getPaperSetById(id);
    }

    @PostMapping
    public PaperSet createPaperSet(@RequestBody PaperSet paperSet) {
        return paperSetService.createPaperSet(paperSet);
    }

    @PutMapping
    public PaperSet updatePaperSet(@RequestBody PaperSet paperSet) {
        return paperSetService.updatePaperSet(paperSet);
    }



    // Implement additional endpoints for managing questions in paper sets if needed

}
