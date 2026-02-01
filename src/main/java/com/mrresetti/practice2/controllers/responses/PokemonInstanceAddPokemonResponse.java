package com.mrresetti.practice2.controllers.responses;

import com.mrresetti.practice2.model.PokemonInstance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonInstanceAddPokemonResponse {
    private PokemonInstance pokemonInstance;
    private Boolean success;
}
