package com.example.barinaksistemi.dto;

import jakarta.persistence.Column;

public record AnimalResponse(long id,String isSterile,String gender, String genus, String age,
                             String extraInfo, String state, String type,String buttonText){

}
