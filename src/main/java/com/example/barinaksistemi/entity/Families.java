package com.example.barinaksistemi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "families",schema = "barinak")
public class Families {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tckn")
    private String tckn;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "history")
    private String history;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "animal_family",schema = "barinak",joinColumns = @JoinColumn(name = "family_id"),inverseJoinColumns =
    @JoinColumn(name = "animal_id"))
    private List<Animals> animals;

    public void addAnimal(Animals animal){
        if(animals==null){
            animals=new ArrayList<>();
        }
        animals.add(animal);
    }

}
