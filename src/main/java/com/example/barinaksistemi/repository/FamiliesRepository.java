package com.example.barinaksistemi.repository;

import com.example.barinaksistemi.entity.Families;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamiliesRepository extends JpaRepository<Families,Long> {
    @Query(value = "select * from barinak.families as f where f.animal_id=:id",nativeQuery = true)
    Families getFamilyByAnimalId(long animalId);
}
