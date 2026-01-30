package com.mrresetti.practice2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PokemonTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long trainerId;

    public String trainerName;
}
