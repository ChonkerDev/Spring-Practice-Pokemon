package com.mrresetti.practice2.controllers;

import com.mrresetti.practice2.controllers.requests.PokemonTrainerSaveRequest;
import com.mrresetti.practice2.controllers.responses.PokemonTrainerSaveResponse;
import com.mrresetti.practice2.model.PokemonTrainer;
import com.mrresetti.practice2.repositories.PokemonTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PokemonTrainerController {

    @Autowired
    private PokemonTrainerRepository pokemonTrainerRepository;

    @GetMapping(value = "trainer/{trainerName}")
    public PokemonTrainer getPokemonTrainerByTrainerName(@PathVariable String trainerName) {
        PokemonTrainer res =  pokemonTrainerRepository.findByTrainerName(trainerName);
        return res;
    }

    @PostMapping(value = "trainer/savetrainer")
    public PokemonTrainerSaveResponse savePokemonTrainer(@RequestBody PokemonTrainerSaveRequest request) {
        PokemonTrainer saveTrainer = new PokemonTrainer();
        saveTrainer.setTrainerName(request.getTrainerName());
        PokemonTrainerSaveResponse response = new PokemonTrainerSaveResponse();
        try {
            PokemonTrainer T = pokemonTrainerRepository.save(saveTrainer);
            response.setTrainerId(T.getTrainerId());
            response.setTrainerName(T.getTrainerName());
            response.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            response = new PokemonTrainerSaveResponse();
            response.setSuccess(false);
        }

        return response;
    }
}
