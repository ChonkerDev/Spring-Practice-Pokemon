package com.mrresetti.practice2;

import com.mrresetti.practice2.controllers.PokemonController;
import com.mrresetti.practice2.model.Pokemon;
import com.mrresetti.practice2.model.PokemonTypeKind;
import com.mrresetti.practice2.repositories.PokemonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

@WebMvcTest(controllers = PokemonController.class)
@ActiveProfiles("test")
public class PokemonControllerTest {

    @Autowired
    private PokemonController pokemonController;

    @MockitoBean
    private PokemonRepository pokemonRepository;

    private static Pokemon testPokemon;

    @BeforeAll
    static void beforeAll() {
        testPokemon = new Pokemon(1L, "Bulbasaur", PokemonTypeKind.GRASS, PokemonTypeKind.POISON);
    }

    @BeforeEach
    void beforeEach() {
        Mockito.when(pokemonRepository.findById(1L)).thenReturn(Optional.of(testPokemon));
        Mockito.when(pokemonRepository.findByDisplayName("Bulbasaur")).thenReturn(testPokemon);
    }

    @Test
    void testGetPokemonById_WhenValid_ExpectPokemon() {
        Pokemon foundPokemon = pokemonController.findPokemonById(1L);

        Assertions.assertNotNull(foundPokemon);
        Assertions.assertEquals(foundPokemon.getDisplayName(), testPokemon.getDisplayName());
        Assertions.assertEquals(foundPokemon.getType_one(), testPokemon.getType_one());
    }

    @Test
    void testGetPokemonById_WhenInvalid_ExpectNull() {
        Pokemon foundPokemon = pokemonController.findPokemonById(0L);

        Assertions.assertNull(foundPokemon);
    }

    @Test
    void testGetPokemonByName_WhenValid_ExpectPokemon() {
        Pokemon foundPokemon = pokemonController.findPokemonByName("Bulbasaur");

        Assertions.assertNotNull(foundPokemon);
        Assertions.assertEquals(foundPokemon.getDisplayName(), testPokemon.getDisplayName());
        Assertions.assertEquals(foundPokemon.getType_one(), testPokemon.getType_one());
    }

    @Test
    void testGetPokemonByName_WhenInvalid_ExpectNull() {
        Pokemon foundPokemon = pokemonController.findPokemonByName("Bad Name");

        Assertions.assertNull(foundPokemon);
    }
}
