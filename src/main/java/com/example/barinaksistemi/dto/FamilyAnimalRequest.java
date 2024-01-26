package com.example.barinaksistemi.dto;

import com.example.barinaksistemi.entity.Animals;
import com.example.barinaksistemi.entity.Families;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class FamilyAnimalRequest {
    private Families family;
    private List<Animals> animals;
}
