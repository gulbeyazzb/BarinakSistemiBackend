package com.example.barinaksistemi.controller;

import com.example.barinaksistemi.entity.Animals;
import com.example.barinaksistemi.service.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalsController {

    private AnimalsService animalsService;

    @Autowired
    public AnimalsController(AnimalsService animalsService) {
        this.animalsService = animalsService;
    }

    @PostMapping
    public void saveAnimal(@RequestBody Animals animal){
        animalsService.saveAnimal(animal);
    }

    @GetMapping
    public List<Animals> getAll(){
        return animalsService.getAnimals();
    }

    @GetMapping("/{id}")
    public Animals getAnimalById(@PathVariable long id){
        return animalsService.getAnimalById(id);
    }

    @PutMapping("/{id}")
    public Animals editAnimalInfo(@PathVariable long id, @RequestBody Animals animal){
        return animalsService.updateAnimalInfo(id,animal);
    }
}
