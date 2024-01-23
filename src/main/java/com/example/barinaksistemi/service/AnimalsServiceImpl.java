package com.example.barinaksistemi.service;

import com.example.barinaksistemi.entity.Animals;
import com.example.barinaksistemi.repository.AnimalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnimalsServiceImpl implements AnimalsService {
    private AnimalsRepository animalsRepository;

    @Autowired
    public AnimalsServiceImpl(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Override
    public Animals getAnimalById(long id) {
        Animals animal=new Animals();
        Optional<Animals> animalsOptional= animalsRepository.findById(id);
        if(animalsOptional.isPresent()){
            animal=animalsOptional.get();
        }
        return animal;
    }

    @Override
    public List<Animals> getAnimals() {
        return animalsRepository.findAll();
    }

    @Override
    public Animals saveAnimal(Animals animal) {
       return animalsRepository.save(animal);
    }

    @Override
    public Animals updateAnimalInfo(long id, Animals animal) {
        Animals foundAnimal=new Animals();
        Optional<Animals> animalsOptional=animalsRepository.findById(id);
        if(animalsOptional.isPresent()){
            foundAnimal=animalsOptional.get();
        }
        animalsRepository.delete(foundAnimal);
        return animalsRepository.save(animal);
    }

    @Override
    public Animals deleteAnimal(long id) {
        Animals foundAnimal=new Animals();
        Optional<Animals> animalsOptional= animalsRepository.findById(id);
        if(animalsOptional.isPresent()){
            foundAnimal=animalsOptional.get();
        }
        animalsRepository.delete(foundAnimal);
        return foundAnimal;
    }
}
