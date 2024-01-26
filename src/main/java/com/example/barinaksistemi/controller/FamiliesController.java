package com.example.barinaksistemi.controller;

import com.example.barinaksistemi.converter.Converter;
import com.example.barinaksistemi.dto.FamilyResponse;
import com.example.barinaksistemi.dto.FamilyResponseWithAnimals;
import com.example.barinaksistemi.entity.Animals;
import com.example.barinaksistemi.entity.Families;
import com.example.barinaksistemi.service.AnimalsService;
import com.example.barinaksistemi.service.FamiliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/family")
public class FamiliesController {

    private FamiliesService familiesService;
    private AnimalsService animalsService;

    @Autowired
    public FamiliesController(FamiliesService familiesService, AnimalsService animalsService) {
        this.familiesService = familiesService;
        this.animalsService = animalsService;
    }

//    @GetMapping("/{id}")
//    public Families getFamilyByAnimalId(@PathVariable long id) {
//        return familiesService.getFamilyByAnimalId(id);
//    }

    @PostMapping("/{animalId}")
    public FamilyResponse saveFamily(@RequestBody Families family, @PathVariable long animalId) {
        Animals animal = animalsService.getAnimalById(animalId);
        animal.setButtonText("Çocuğu Geri Al");
        animal.setState(family.getName() + " tarafından sahiplenildi");
        family.addAnimal(animal);
        return Converter.findFamily(familiesService.saveFamily(family));
    }

    @GetMapping("/{animalId}")
    public List<FamilyResponse> getFamilies(@PathVariable long animalId) {
        return Converter.findFamilies(familiesService.getFamilies(animalId));
    }

}
