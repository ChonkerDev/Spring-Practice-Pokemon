package com.mrresetti.practice2.controllers;

import com.mrresetti.practice2.controllers.requests.PokemonInstanceAddPokemonByNameRequest;
import com.mrresetti.practice2.controllers.requests.PokemonInstanceAddPokemonRequest;
import com.mrresetti.practice2.controllers.responses.PokemonInstanceAddPokemonByNameResponse;
import com.mrresetti.practice2.controllers.responses.PokemonInstanceAddPokemonResponse;
import com.mrresetti.practice2.model.Pokemon;
import com.mrresetti.practice2.model.PokemonInstance;
import com.mrresetti.practice2.model.PokemonTrainer;
import com.mrresetti.practice2.repositories.PokemonInstanceRepository;
import com.mrresetti.practice2.repositories.PokemonRepository;
import com.mrresetti.practice2.repositories.PokemonTrainerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="pokemonInstance")
public class PokemonInstanceController {

    @Autowired
    private PokemonInstanceRepository pokemonInstanceRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonTrainerRepository pokemonTrainerRepository;


    @PostMapping(value = "addPokemonById")
    public PokemonInstanceAddPokemonResponse savePokemonInstanceByPokemonId(@RequestBody PokemonInstanceAddPokemonRequest req) {
        PokemonInstanceAddPokemonResponse response = new PokemonInstanceAddPokemonResponse();
        response.setSuccess(false);

        PokemonInstance pokemonInstance = new PokemonInstance();
        try {
            Pokemon pokemon = pokemonRepository.findById(req.getPokemonId())
                    .orElseThrow(() -> new EntityNotFoundException("Pokemon not found"));

            PokemonTrainer trainer = pokemonTrainerRepository.findById(req.getTrainerId())
                    .orElseThrow(() -> new EntityNotFoundException("Trainer not found"));

            pokemonInstance.setPokemonId(pokemon);
            pokemonInstance.setTrainerId(trainer);
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }

        PokemonInstance dbRes = savePokemonInstance(pokemonInstance);

        if (dbRes != null) {
            response.setSuccess(true);
            response.setPokemonInstance(dbRes);
        }


        return response;
    }

    @PostMapping(value = "addPokemonByName")
    public PokemonInstanceAddPokemonByNameResponse savePokemonInstanceByPokemonName(@RequestBody PokemonInstanceAddPokemonByNameRequest req) {
        PokemonInstanceAddPokemonByNameResponse response = new PokemonInstanceAddPokemonByNameResponse();
        response.setSuccess(false);

        PokemonInstance pokemonInstance = new PokemonInstance();
        try {
            Pokemon pokemon = pokemonRepository.findByDisplayName(req.getPokemonDefaultName());

            if (pokemon == null) {
                throw new EntityNotFoundException("Pokemon not found");
            }

            PokemonTrainer trainer = pokemonTrainerRepository.findById(req.getTrainerId())
                    .orElseThrow(() -> new EntityNotFoundException("Trainer not found"));

            pokemonInstance.setPokemonId(pokemon);
            pokemonInstance.setTrainerId(trainer);

        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }

        PokemonInstance dbRes = savePokemonInstance(pokemonInstance);

        if (dbRes != null) {
            response.setSuccess(true);
            response.setPokemonInstance(dbRes);
        }

        return response;
    }

    private PokemonInstance savePokemonInstance(PokemonInstance pokemonInstance) {
        PokemonInstance dbRes = null;
        try {
            dbRes = pokemonInstanceRepository.save(pokemonInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dbRes;
    }
}
