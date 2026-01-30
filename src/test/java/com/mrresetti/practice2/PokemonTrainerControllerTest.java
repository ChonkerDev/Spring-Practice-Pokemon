package com.mrresetti.practice2;

import com.mrresetti.practice2.controllers.PokemonTrainerController;
import com.mrresetti.practice2.controllers.requests.PokemonTrainerSaveRequest;
import com.mrresetti.practice2.controllers.responses.PokemonTrainerSaveResponse;
import com.mrresetti.practice2.model.PokemonTrainer;
import com.mrresetti.practice2.repositories.PokemonTrainerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@WebMvcTest(PokemonTrainerController.class)
@ActiveProfiles("test")
public class PokemonTrainerControllerTest {
    @MockitoBean
    private PokemonTrainerRepository pokemonTrainerRepository;

    @Autowired
    private PokemonTrainerController pokemonTrainerController;


    @Test
    public void testGetTrainer_whenValid_ExpectValid() {
        PokemonTrainer dbResponse = new PokemonTrainer();
        dbResponse.setTrainerId(0L);
        dbResponse.setTrainerName("test");
        Mockito.when(pokemonTrainerRepository.findByTrainerName(Mockito.anyString())).thenReturn(dbResponse);
        PokemonTrainer response = pokemonTrainerController.getPokemonTrainerByTrainerName("test");
        Assertions.assertNotNull(response);
    }

    @Test
    public void testGetTrainer_whenInvalid_ExpectInvalid() {
        Mockito.when(pokemonTrainerRepository.findByTrainerName(Mockito.anyString())).thenReturn(null);

        PokemonTrainer response = pokemonTrainerController.getPokemonTrainerByTrainerName("test");
        Assertions.assertNull(response);
    }

    @Test
    public void testSaveTrainer_whenValid_ExpectValid() {
        PokemonTrainer dbResponse = new PokemonTrainer();
        dbResponse.setTrainerId(0L);
        dbResponse.setTrainerName("test");
        Mockito.when(pokemonTrainerRepository.save(Mockito.any())).thenReturn(dbResponse);

        PokemonTrainerSaveRequest request = new PokemonTrainerSaveRequest();
        request.setTrainerName("test");
        PokemonTrainerSaveResponse response = pokemonTrainerController.savePokemonTrainer(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getTrainerId(), dbResponse.getTrainerId());
        Assertions.assertEquals(response.getTrainerName(), dbResponse.getTrainerName());
        Assertions.assertTrue(response.getSuccess());
    }

    @Test
    public void testSaveTrainer_whenExceptionIsThrown_ExpectNotSuccess() {
        Mockito.when(pokemonTrainerRepository.save(Mockito.any())).thenThrow(new RuntimeException());

        PokemonTrainerSaveRequest request = new PokemonTrainerSaveRequest();
        request.setTrainerName("test");
        PokemonTrainerSaveResponse response = pokemonTrainerController.savePokemonTrainer(request);

        Assertions.assertFalse(response.getSuccess());
    }
}
