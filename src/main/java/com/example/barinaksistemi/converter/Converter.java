package com.example.barinaksistemi.converter;

import com.example.barinaksistemi.dto.AnimalResponse;
import com.example.barinaksistemi.dto.FamilyResponse;
import com.example.barinaksistemi.dto.FamilyResponseWithAnimals;
import com.example.barinaksistemi.entity.Animals;
import com.example.barinaksistemi.entity.Families;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<FamilyResponse> findFamilies(List<Families> families) {
        List<FamilyResponse> responses = new ArrayList<>();
        List<AnimalResponse> animalResponses=new ArrayList<>();
        for (Families family : families) {
            responses.add(new FamilyResponse(family.getId(), family.getName(), family.getSurname(),
                    family.getPhone()));
        }
        return responses;
    }
    public static FamilyResponse findFamily(Families family){
        return new FamilyResponse(family.getId(), family.getName(),family.getSurname(), family.getPhone());
    }

    public static AnimalResponse findAnimal(Animals animal){
        return new AnimalResponse(animal.getId(), animal.getIsSterile(), animal.getGender(), animal.getGenus(), animal.getAge(),
                animal.getExtraInfo(), animal.getState(), animal.getType(), animal.getButtonText());
    }

    public static List<AnimalResponse> findAnimals(List<Animals> animals) {
        List<AnimalResponse> responses = new ArrayList<>();
        for (Animals animal : animals) {
            responses.add(new AnimalResponse(animal.getId(), animal.getIsSterile(), animal.getGender(), animal.getGenus(),
                    animal.getAge(),animal.getExtraInfo(), animal.getState(), animal.getType(), animal.getButtonText()));
        }
        return responses;
    }

}
