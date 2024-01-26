package com.example.barinaksistemi.repository;

import com.example.barinaksistemi.dto.FamilyResponse;
import com.example.barinaksistemi.entity.Families;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FamiliesRepository extends JpaRepository<Families,Long> {
    @Query(value = "select f.id, f.name, f.surname, f.phone from barinak.families as f where f.id=(select af.family_id from barinak.animal_family as af where af.animal_id=:animalId)",nativeQuery = true)
    List<Families> getFamilyByAnimalId(long animalId);
}
