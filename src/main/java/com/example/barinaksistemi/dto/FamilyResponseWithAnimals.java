package com.example.barinaksistemi.dto;

import com.example.barinaksistemi.entity.Animals;

import java.util.ArrayList;
import java.util.List;

public record FamilyResponseWithAnimals(long id, String name, String surname, String phone, String address,List<AnimalResponse> animalResponse) {
}
