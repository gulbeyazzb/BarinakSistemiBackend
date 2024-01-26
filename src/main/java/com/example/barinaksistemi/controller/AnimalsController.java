package com.example.barinaksistemi.controller;

import com.example.barinaksistemi.converter.Converter;
import com.example.barinaksistemi.dto.AnimalRequest;
import com.example.barinaksistemi.dto.AnimalResponse;
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
    public AnimalResponse saveAnimal(@RequestBody AnimalRequest animalRequest){
        Animals animal=new Animals();
        animal.setId(animalRequest.getId());
        animal.setState("Barınakta");
        animal.setAge(animalRequest.getAge());
        animal.setGender(animalRequest.getGender());
        animal.setType(animalRequest.getType());
        animal.setGenus(animalRequest.getGenus());
        animal.setIsSterile(animalRequest.getIsSterile());
        animal.setExtraInfo(animalRequest.getExtraInfo());
        animal.setButtonText("Sahiplen");
        return Converter.findAnimal(animalsService.saveAnimal(animal));
    }

    @GetMapping
    public List<AnimalResponse> getAll(){
        return Converter.findAnimals(animalsService.getAnimals());
    }

    @GetMapping("/{id}")
    public AnimalResponse getAnimalById(@PathVariable long id){
        return Converter.findAnimal(animalsService.getAnimalById(id));
    }

    @PutMapping("/{id}")
    public Animals editAnimalInfo(@PathVariable long id, @RequestBody Animals animal){
        return animalsService.updateAnimalInfo(id,animal);
    }
}
