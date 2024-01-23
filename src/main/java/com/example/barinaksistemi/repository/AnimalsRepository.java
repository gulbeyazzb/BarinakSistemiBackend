package com.example.barinaksistemi.repository;

import com.example.barinaksistemi.entity.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalsRepository extends JpaRepository<Animals,Long> {
    @Query(value = "SELECT * FROM barinak.animals as a WHERE a.id=:id",nativeQuery = true)
    Animals getAnimalById(long id);

}
