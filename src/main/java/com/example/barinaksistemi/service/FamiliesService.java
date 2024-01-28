package com.example.barinaksistemi.service;

import com.example.barinaksistemi.dto.FamilyResponse;
import com.example.barinaksistemi.entity.Families;

import java.util.List;

public interface FamiliesService {
   // Families getFamilyByAnimalId(long id);
    Families saveFamily(Families family);
    Families getFamilyByAnimalId(long id);
}
