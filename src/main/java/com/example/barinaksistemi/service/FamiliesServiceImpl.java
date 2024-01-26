package com.example.barinaksistemi.service;

import com.example.barinaksistemi.dto.FamilyResponse;
import com.example.barinaksistemi.entity.Families;
import com.example.barinaksistemi.repository.FamiliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FamiliesServiceImpl implements FamiliesService{
    private FamiliesRepository familiesRepository;

    @Autowired
    public FamiliesServiceImpl(FamiliesRepository familiesRepository) {
        this.familiesRepository = familiesRepository;
    }

//    @Override
//    public Families getFamilyByAnimalId(long id) {
//        return familiesRepository.getFamilyByAnimalId(id);
//    }

    @Override
    public Families saveFamily(Families family) {
        return familiesRepository.save(family);
    }

    @Override
    public List<Families> getFamilies(long animalId) {
        return familiesRepository.getFamilyByAnimalId(animalId);
    }
}
