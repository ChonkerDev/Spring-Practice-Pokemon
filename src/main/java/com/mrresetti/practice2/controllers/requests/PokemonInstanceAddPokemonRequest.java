package com.mrresetti.practice2.controllers.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonInstanceAddPokemonRequest {
    private Long pokemonId;
    private Long trainerId;
}
