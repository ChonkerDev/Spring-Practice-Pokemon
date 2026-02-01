package com.mrresetti.practice2.controllers.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonInstanceAddPokemonByNameRequest {
    private String pokemonDefaultName;
    private Long trainerId;
}
