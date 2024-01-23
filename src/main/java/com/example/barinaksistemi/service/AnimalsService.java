package com.example.barinaksistemi.service;

import com.example.barinaksistemi.entity.Animals;

import java.util.List;

public interface AnimalsService {
    Animals getAnimalById(long id);

    List<Animals> getAnimals();

    Animals saveAnimal(Animals animal);

    Animals updateAnimalInfo(long id, Animals animal);

    Animals deleteAnimal(long id);
}
