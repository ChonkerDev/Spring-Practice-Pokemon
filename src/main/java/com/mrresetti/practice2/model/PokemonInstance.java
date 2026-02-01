package com.mrresetti.practice2.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PokemonInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long instanceId;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemonId;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private PokemonTrainer trainerId;



}
