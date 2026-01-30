package com.mrresetti.practice2;

import com.mrresetti.practice2.model.PokemonTrainer;
import com.mrresetti.practice2.repositories.PokemonTrainerRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
public class PokemonTrainerRepositoryTest {

    @Autowired
    private PokemonTrainerRepository pokemonTrainerRepository;

    @BeforeEach
     void setupDb() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer();
        pokemonTrainer.setTrainerName("Pokemon Trainer");
        pokemonTrainerRepository.save(pokemonTrainer);
    }

    @AfterEach
    void tearDownDb() {
        pokemonTrainerRepository.deleteAll();
    }

    @Test
    void testSaveTrainer_expectNonNullTrainer() {
        PokemonTrainer trainer = new PokemonTrainer();
        trainer.setTrainerName("Red");

        PokemonTrainer saved = pokemonTrainerRepository.save(trainer);

        Assertions.assertNotNull(saved);
        Assertions.assertEquals(saved.getTrainerName(), trainer.getTrainerName());
        Assertions.assertEquals(saved.getTrainerId(), trainer.getTrainerId());
    }

    @Test
    void testFindTrainer_expectTrainerNotNull() {
        PokemonTrainer trainer = pokemonTrainerRepository.findByTrainerName("Pokemon Trainer");

        Assertions.assertNotNull(trainer);
    }

    @Test
    void testFindTrainer_expectTrainerNull() {
        PokemonTrainer trainer = pokemonTrainerRepository.findByTrainerName("red");

        Assertions.assertNull(trainer);
    }
}
