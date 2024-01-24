package com.example.barinaksistemi.controller;

import com.example.barinaksistemi.entity.Families;
import com.example.barinaksistemi.service.FamiliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/family")
public class FamiliesController {

    private FamiliesService familiesService;
@Autowired
    public FamiliesController(FamiliesService familiesService) {
        this.familiesService = familiesService;
    }

    @GetMapping("/{id}")
    public Families getFamilyByAnimalId(@PathVariable long id){
    return familiesService.getFamilyByAnimalId(id);
    }

    @PostMapping("/")
    public Families saveFamily(@RequestBody Families family){
    return familiesService.saveFamily(family);
    }

    @GetMapping("/all")
    public List<Families> getFamilies(){
    return familiesService.getFamilies();
    }
}
