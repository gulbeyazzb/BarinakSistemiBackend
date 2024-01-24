package com.example.barinaksistemi.service;

import com.example.barinaksistemi.entity.Families;

import java.util.List;

public interface FamiliesService {
    Families getFamilyByAnimalId(long id);
    Families saveFamily(Families family);
    List<Families> getFamilies();
}
