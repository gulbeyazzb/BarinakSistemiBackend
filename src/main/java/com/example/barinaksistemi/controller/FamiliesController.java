package com.example.barinaksistemi.controller;

import com.example.barinaksistemi.converter.Converter;
import com.example.barinaksistemi.dto.FamilyResponse;
import com.example.barinaksistemi.entity.Animals;
import com.example.barinaksistemi.entity.Families;
import com.example.barinaksistemi.service.AnimalsService;
import com.example.barinaksistemi.service.FamiliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


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

    @GetMapping("/{animalId}")
    public FamilyResponse getFamilyByAnimalId(@PathVariable long animalId) {
        return Converter.findFamily(familiesService.getFamilyByAnimalId(animalId));
    }

    @PostMapping("/{animalId}")
    public FamilyResponse saveFamily(@RequestBody Families family, @PathVariable long animalId) {
        Animals animal = animalsService.getAnimalById(animalId);
        animal.setButtonText("Çocuğu Geri Al");
        LocalDate date = LocalDate.now();
        animal.setState(family.getName() + " tarafından" + date + " tarihinde sahiplenildi");
        family.addAnimal(animal);

        return Converter.findFamily(familiesService.saveFamily(family));
    }

}
