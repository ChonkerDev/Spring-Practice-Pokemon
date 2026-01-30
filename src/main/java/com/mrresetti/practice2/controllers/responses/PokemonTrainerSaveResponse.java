package com.mrresetti.practice2.controllers.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonTrainerSaveResponse {
    private String trainerName;
    private Long trainerId;
    private Boolean success;
}
