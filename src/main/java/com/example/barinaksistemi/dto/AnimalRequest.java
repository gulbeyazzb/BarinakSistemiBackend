package com.example.barinaksistemi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnimalRequest {
    private long id;

    private String isSterile;

    private String genus;

    private String age;

    private String gender;

    private String extraInfo;

    private String type;
}
