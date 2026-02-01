package com.mrresetti.practice2.repositories;

import com.mrresetti.practice2.model.Pokemon;
import com.mrresetti.practice2.model.PokemonTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByDisplayName(String name);
}
