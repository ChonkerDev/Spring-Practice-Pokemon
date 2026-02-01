package com.mrresetti.practice2.repositories;

import com.mrresetti.practice2.model.PokemonInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonInstanceRepository extends JpaRepository<PokemonInstance, Long> {


}
