CREATE INDEX idx_pokemon_name
    ON POKEMON (Display_Name);

--CREATE INDEX idx_pokemon_id
   -- ON POKEMON (Pokemon_Id); --primary key is auto indexed

CREATE BITMAP INDEX idx_pokemon_type_one
ON POKEMON (Type_One);

CREATE BITMAP INDEX idx_pokemon_type_two
ON POKEMON (Type_Two);

COMMIT;