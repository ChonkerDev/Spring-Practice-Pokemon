package com.mrresetti.practice2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @Id
    @Setter(AccessLevel.NONE)
    private Long pokemonId;

    private String displayName;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_ONE")
    private PokemonTypeKind type_one;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_TWO")
    private PokemonTypeKind type_two;

}
