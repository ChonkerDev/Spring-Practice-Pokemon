WHENEVER SQLERROR EXIT FAILURE ROLLBACK; -- if one fails, all should fail

INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (1, 'Bulbasaur', 'GRASS', 'POISON');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (2, 'Ivysaur', 'GRASS', 'POISON');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (3, 'Venusaur', 'GRASS', 'POISON');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (4, 'Charmander', 'FIRE', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (5, 'Charmeleon', 'FIRE', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (6, 'Charizard', 'FIRE', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (7, 'Squirtle', 'WATER', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (8, 'Wartortle', 'WATER', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (9, 'Blastoise', 'WATER', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (10, 'Caterpie', 'BUG', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (11, 'Metapod', 'BUG', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (12, 'Butterfree', 'BUG', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (13, 'Weedle', 'BUG', 'POISON');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (14, 'Kakuna', 'BUG', 'POISON');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (15, 'Beedrill', 'BUG', 'POISON');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (16, 'Pidgey', 'NORMAL', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (17, 'Pidgeotto', 'NORMAL', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (18, 'Pidgeot', 'NORMAL', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (19, 'Rattata', 'NORMAL', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (20, 'Raticate', 'NORMAL', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (21, 'Spearow', 'NORMAL', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (22, 'Fearow', 'NORMAL', 'FLYING');
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (23, 'Ekans', 'POISON', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (24, 'Arbok', 'POISON', NULL);
INSERT INTO pokemon (pokemon_id, display_name, type_one, type_two) VALUES (25, 'Pikachu', 'ELECTRIC', NULL);

COMMIT;
