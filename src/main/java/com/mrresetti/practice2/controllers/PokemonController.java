package com.mrresetti.practice2.controllers;

import com.mrresetti.practice2.model.Pokemon;
import com.mrresetti.practice2.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping(value = "pokemon/id/{id}")
    public Pokemon findPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.orElse(null);
    }

    @GetMapping(value = "pokemon/name/{name}")
    public Pokemon findPokemonByName(@PathVariable String name) {
        return pokemonRepository.findByDisplayName(name);
    }
}
