package com.example.barinaksistemi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animals", schema = "barinak")
public class Animals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "is_sterile")
    private boolean isSterile;

    @Column(name = "genus")
    private String genus;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "extra_info")
    private String extraInfo;

    @Column(name = "image")
    private String image;

    @Column(name = "state")
    private String state;

    @Column(name = "type")
    private String type;
}
