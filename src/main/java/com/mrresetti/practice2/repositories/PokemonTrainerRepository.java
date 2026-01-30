package com.mrresetti.practice2.repositories;

import com.mrresetti.practice2.model.PokemonTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonTrainerRepository extends JpaRepository<PokemonTrainer, Long> {

    PokemonTrainer findByTrainerName(String name);
}
