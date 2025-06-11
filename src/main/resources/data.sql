--INSERTS PARA POSTGRESQL
--CONTINENTES
INSERT INTO public.continents(
    id, bonus, name)values
                        (1, 5, 'AMÉRICA DEL NORTE'),
                        (2, 3,'AMÉRICA DEL SUR'),
                        (3, 5,'EUROPA'),
                        (4, 3,'ÁFRICA'),
                        (5, 7, 'ASIA'),
                        (6, 2,'OCEANÍA');




--PAISES
insert into countries
values(1, 'ALASKA',1),
    (2, 'YUKÓN',1),
    (3, 'CANADÁ',1),
    (4, 'GROENLANDIA',1),
    (5, 'LABRADOR',1),
    (6, 'TERRANOVA',1),
    (7, 'NUEVA YORK',1),
    (8, 'OREGÓN',1),
    (9, 'CALIFORNIA',1),
    (10, 'MÉXICO',1),
    (11, 'COLOMBIA',2),
    (12, 'PERU',2),
    (13, 'CHILE',2),
    (14, 'ARGENTINA',2),
    (15, 'URUGUAY',2),
    (16, 'BRASIL',2),
    (17, 'ISLANDIA',3),
    (18, 'SUECIA',3),
    (19, 'RUSIA',3),
    (20, 'POLONIA',3),
    (21, 'ALEMANIA',3),
    (22, 'ITALIA',3),
    (23, 'FRANCIA',3),
    (24, 'ESPAÑA',3),
    (25, 'GRAN BRETAÑA',3),
    (26, 'SAHARA',4),
    (27, 'EGIPTO',4),
    (28, 'ETIOPÍA',4),
    (29, 'ZAIRE',4),
    (30, 'SUDÁFRICA',4),
    (31, 'MADAGASCAR',4),
    (32, 'TURQUÍA',5),
    (33, 'ISRAEL',5),
    (34, 'ARABIA',5),
    (35, 'INDIA',5),
    (36, 'MALASIA',5),
    (37, 'IRÁN',5),
    (38, 'ARAL',5),
    (39, 'CHINA',5),
    (40, 'GOBÍ',5),
    (41, 'MONGOLIA',5),
    (42, 'SIBERIA',5),
    (43, 'TARTARIA',5),
    (44, 'TAYMIR',5),
    (45, 'KAMCHATKA',5),
    (46, 'JAPÓN',5),
    (47, 'SUMATRA',6),
    (48, 'BORNEO',6),
    (49, 'JAVA',6),
    (50, 'AUSTRALIA',6);



--LIMITES
insert into limits
--Alaska
values(1,2),
    (1,8),
    (1,45),
--Yukon
    (2,3),
    (2,8),
--Canada
    (3,8),
    (3,7),
    (3,6),
--groenlandia
    (4,7),
    (4,5),
    (4,17),
--labrador
    (5,6),
--terranova
    (6,7),
--nueva york
    (7,8),
    (7,9),
--oregon
    (8,9),
--california
    (9,10),
--mexico
    (10,11),
--colombia
    (11,12),
    (11,16),
--peru
    (12,13),
    (12,14),
    (12,16),
--chile
    (13,14),
    (13,50),
--argentina
    (14,15),
    (14,16),
--uruguay
    (15,16),
--brasil
    (16,26),
--islandiA
    (17,18),
    (17,25),
--suecia
    (18,19),
--rusia
    (19,20),
    (19,32),
    (19,37),
    (19,38),
--polonia
    (20,32),
    (20,27),
--alemania
    (21,22),
    (21,27),
    (21,25),
    (21,23),
--italia
    (22,23),
--francia
    (23,24),
--espana
    (24,25),
    (24,26),
--sahara
    (26,27),
    (26,28),
    (26,29),
--egipto
    (27,28),
    (27,31),
    (27,32),
    (27,33),
--etiopia
    (28,29),
    (28,30),
--zaire
    (29,30),
    (29,31),
--sudafrica
--madagascar
--turquia
    (32,33),
    (32,34),
    (32,37),
--israel
    (33,34),
--arabia
--india
    (35,36),
    (35,37),
    (35,39),
    (35,47),
--malasia
    (36,39),
    (36,48),
--iran
    (37,38),
    (37,39),
    (37,40),
    (37,41),
--aral
    (38,41),
    (38,42),
    (38,43),
--china
    (39,40),
    (39,41),
    (39,42),
    (39,45),
    (39,46),
--gobi
    (40,41),
--mongolia
    (41,42),
--siberia
    (42,43),
    (42,44),
    (42,45),
--tartaria
    (43,44),
--taymir
--kamchatka
    (45,46),
--japon
--sumatra
    (47,50),
--borneo
    (48,50),
--java
    (49,50)
--australia



--COLORES
    INSERT INTO COLORS(id, color) VALUES (6, 'VERDE');
INSERT INTO COLORS(id, color) VALUES (5, 'ROJO');
INSERT INTO COLORS(id, color) VALUES (4, 'NEGRO');
INSERT INTO COLORS(id, color) VALUES (3, 'MAGENTA');
INSERT INTO COLORS(id, color) VALUES (2, 'AZUL');
INSERT INTO COLORS(id, color) VALUES (1, 'AMARILLO');

--TIPOS DE CARTA
INSERT INTO CARD_TYPES(id, card_type) VALUES (4, 'JOKER');
INSERT INTO CARD_TYPES(id, card_type) VALUES (3, 'CANNON');
INSERT INTO CARD_TYPES(id, card_type) VALUES (2, 'BALLOON');
INSERT INTO CARD_TYPES(id, card_type) VALUES (1, 'GALLEON');


--CARTAS
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (50, 4, 50);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (49, 4, 49);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (48, 3, 48);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (47, 3, 47);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (46, 3, 46);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (45, 3, 45);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (44, 3, 44);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (43, 3, 43);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (42, 3, 42);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (41, 3, 41);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (40, 3, 40);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (39, 3, 39);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (38, 3, 38);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (37, 3, 37);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (36, 3, 36);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (35, 3, 35);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (34, 3, 34);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (33, 3, 33);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (32, 2, 32);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (31, 2, 31);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (30, 2, 30);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (29, 2, 29);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (28, 2, 28);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (27, 2, 27);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (26, 2, 26);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (25, 2, 25);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (24, 2, 24);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (23, 2, 23);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (22, 2, 22);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (21, 2, 21);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (20, 2, 20);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (19, 2, 19);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (18, 2, 18);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (17, 2, 17);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (16, 1, 16);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (15, 1, 15);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (14, 1, 14);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (13, 1, 13);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (12, 1, 12);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (11, 1, 11);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (10, 1, 10);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (9, 1, 9);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (8, 1, 8);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (7, 1, 7);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (6, 1, 6);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (5, 1, 5);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (4, 1, 4);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (3, 1, 3);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (2, 1, 2);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (1, 1, 1);


--TIPOS DE OBJETIVOS
INSERT INTO public.objective_types(
    id, objective_type)
VALUES (1, 'GENERAL'),
       (2, 'CONTINENT'),
       (3, 'COLOR'),
       (4, 'ADJACENCY')

--CONTINENT TARGETS
INSERT INTO public.continent_targets(
    id, amount, target_id)
VALUES
    --AN
    (1,5,1), --5
    (2, 10,1), --conquistar
    (3, 4,1), --4
    --AS
    (4, 6,2), --conquistar
    (5, 2,2), -- 2
    --EU
    (6, 4,3), --4
    (7, 7,3), --7
    (8, 9,3), --conquistar
    (9, 3,3), --3
    (10, 2,3), --2
    --AF
    (11, 6,4), --conquistar
    (12, 2,4), --2
    --ASIA
    (13, 15,5), --conquistar
    (14, 4,5), --4
    (15, 3,5), --3
    --OC
    (16, 2,6), --2
    (17, 4,6) --conquistar

--OBJETIVOS
INSERT INTO public.objectives(
    id, description, target_adjacent_countries, target_color_id, target_countries, objective_type_id)
VALUES
    (1,'OCUPAR ÁFRICA, 5 PAÍSES DE AMÉRICA DEL NORTE y 4 PAÍSES DE EUROPA.',null,null,null,2),
    (2,'OCUPAR AMÉRICA DEL SUR, 7 PAÍSES DE EUROPA y 3 PAÍSES LIMÍTROFES ENTRE SÍ EN
CUALQUIER LUGAR DEL MAPA.',3,null,null,2),
    (3,'OCUPAR ASIA y 2 PAÍSES DE AMÉRICA DEL SUR.',null,null,null,2),
    (4,'OCUPAR EUROPA, 4 PAÍSES DE ASIA y 2 PAÍSES DE AMÉRICA DEL SUR.',null,null,null,2),
    (5,'OCUPAR AMÉRICA DEL NORTE, 2 PAÍSES DE OCEANÍA y 4 DE ASIA.',null,null,null,2),
    (6,'OCUPAR 2 PAÍSES DE OCEANÍA, 2 PAÍSES DE ÁFRICA, 2 PAÍSES DE AMÉRICA DEL SUR,
3 PAÍSES DE EUROPA, 4 DE AMÉRICA DEL NORTE y 3 DE ASIA.',null,null,null,2),
    (7,'OCUPAR OCEANÍA, AMÉRICA DEL NORTE y 2 PAÍSES DE EUROPA.',null,null,null,2),
    (8,'OCUPAR AMÉRICA DEL SUR, ÁFRICA y 4 PAÍSES DE ASIA.',null,null,null,2),
    (9,'OCUPAR OCEANÍA, ÁFRICA y 5 PAÍSES DE AMÉRICA DEL NORTE.',null,null,null,2),
    (10,'DESTRUIR EL EJÉRCITO AzUL, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA.',null,2,null,3),
    (11,'DESTRUIR AL EJÉRCITO ROJO, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA.',null,5,null,3),
    (12,'DESTRUIR AL EJÉRCITO NEGRO, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA.',null,4,null,3),
    (13,'DESTRUIR AL EJÉRCITO AMARILLO, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA.',null,1,null,3),
    (14,'DESTRUIR AL EJÉRCITO VERDE, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA.',null,6,null,3),
    (15,'DESTRUIR AL EJÉRCITO MAGENTA, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA.',null,3,null,3),
    (16,'OCUPAR 30 PAÍSES.',null,null,30,1)


--OBJTIVOS X CONTINENT TARGETS
INSERT INTO public.objectives_continent_targets(
    id_objective, id_continent_target)
VALUES
    (1,11),
    (1,1),
    (1,6),
    (2,4),
    (2,7),
    (3,13),
    (3,5),
    (4,8),
    (4,14),
    (4,5),
    (5,2),
    (5,16),
    (5,14),
    (6,16),
    (6,12),
    (6,5),
    (7,17),
    (7,2),
    (7,10),
    (8,4),
    (8,11),
    (8,14),
    (9,17),
    (9,11),
    (9,1)



/*
INSERT INTO CONTINENTS(id, name,bonus) VALUES (6, 'OCEANÍA',2);
INSERT INTO CONTINENTS(id, name,bonus) VALUES (5, 'ASIA',3);
INSERT INTO CONTINENTS(id, name,bonus) VALUES (4, 'ÁFRICA',4);
INSERT INTO CONTINENTS(id, name,bonus) VALUES (3, 'EUROPA',8);
INSERT INTO CONTINENTS(id, name,bonus) VALUES (2, 'AMÉRICA DEL SUR',10);
INSERT INTO CONTINENTS(id,name,bonus) VALUES (1, 'AMÉRICA DEL NORTE',11);


INSERT INTO COUNTRIES(id,name,id_continent) VALUES (50, 'AUSTRALIA', 6);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (49, 'JAVA', 6);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (48, 'BORNEO', 6);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (47, 'SUMATRA', 6);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (46, 'JAPÓN', 5);
INSERT INTO COUNTRIES(id,name,id_continent)VALUES (45, 'KAMCHATKA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (44, 'TAYMIR', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (43, 'TARTARIA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (42, 'SIBERIA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (41, 'MONGOLIA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (40, 'GOBÍ', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (39, 'CHINA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (38, 'ARAL', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (37, 'IRÁN', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (36, 'MALASIA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (35, 'INDIA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (34, 'ARABIA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (33, 'ISRAEL', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (32, 'TURQUÍA', 5);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (31, 'MADAGASCAR', 4);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (30, 'SUDÁFRICA', 4);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (29, 'ZAIRE', 4);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (28, 'ETIOPÍA', 4);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (27, 'EGIPTO', 4);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (26, 'SAHARA', 4);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (25, 'GRAN BRETAÑA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (24, 'ESPAÑA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (23, 'FRANCIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (22, 'ITALIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (21, 'ALEMANIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (20, 'POLONIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (19, 'RUSIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (18, 'SUECIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (17, 'ISLANDIA', 3);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (16, 'BRASIL', 2);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (15, 'URUGUAY', 2);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (14, 'ARGENTINA', 2);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (13, 'CHILE', 2);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (12, 'PERU', 2);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (11, 'COLOMBIA', 2);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (10, 'MÉXICO', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (9, 'CALIFORNIA', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (8, 'OREGÓN', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (7, 'NUEVA YORK', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (6, 'TERRANOVA', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (5, 'LABRADOR', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (4, 'GROENLANDIA', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (3, 'CANADÁ', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (2, 'YUKÓN', 1);
INSERT INTO COUNTRIES(id,name,id_continent) VALUES (1, 'ALASKA', 1);

INSERT INTO COLORS(id, color) VALUES (6, 'VERDE');
INSERT INTO COLORS(id, color) VALUES (5, 'ROJO');
INSERT INTO COLORS(id, color) VALUES (4, 'NEGRO');
INSERT INTO COLORS(id, color) VALUES (3, 'MAGENTA');
INSERT INTO COLORS(id, color) VALUES (2, 'AZUL');
INSERT INTO COLORS(id, color) VALUES (1, 'AMARILLO');
INSERT INTO CARD_TYPES(id, cardType) VALUES (4, 'JOKER');
INSERT INTO CARD_TYPES(id, cardType) VALUES (3, 'CANNON');
INSERT INTO CARD_TYPES(id, cardType) VALUES (2, 'BALLOON');
INSERT INTO CARD_TYPES(id, cardType) VALUES (1, 'GALLEON');
INSERT INTO PLAYER_TASKS(id, description, idColor) VALUES (6, 'DESTRUIR EL EJÉRCITO MAGENTA, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA', 3);
INSERT INTO PLAYER_TASKS(id, description, idColor) VALUES (5, 'DESTRUIR EL EJÉRCITO VERDE, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA', 6);
INSERT INTO PLAYER_TASKS(id, description, idColor) VALUES (4, 'DESTRUIR EL EJÉRCITO AMARILLO, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA', 1);
INSERT INTO PLAYER_TASKS(id, description, idColor) VALUES (3, 'DESTRUIR EL EJÉRCITO NEGRO, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA', 4);
INSERT INTO PLAYER_TASKS(id, description, idColor) VALUES (2, 'DESTRUIR EL EJÉRCITO ROJO, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA', 5);
INSERT INTO PLAYER_TASKS(id, description, idColor) VALUES (1, 'DESTRUIR EL EJÉRCITO AZUL, DE SER IMPOSIBLE AL JUGADOR DE LA DERECHA', 2);


INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (49, 50);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (48, 50);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (47, 50);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (45, 46);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (43, 44);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (42, 45);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (42, 44);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (41, 42);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (42, 43);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (40, 41);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (39, 46);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (39, 45);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (39, 42);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (39, 41);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (39, 40);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (38, 43);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (38, 42);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (38, 41);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (37, 41);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (37, 40);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (37, 39);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (37, 38);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (36, 48);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (36, 39);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (35, 47);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (35, 39);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (35, 37);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (35, 36);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (33, 34);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (32, 37);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (32, 34);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (32, 33);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (29, 31);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (29, 30);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (28, 30);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (28, 29);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (27, 33);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (27, 32);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (27, 31);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (27, 28);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (26, 29);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (26, 28);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (26, 27);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (24, 26);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (24, 25);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (23, 24);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (22, 23);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (21, 23);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (21, 25);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (21, 27);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (21, 22);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (20, 27);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (20, 32);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (19, 38);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (19, 37);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (19, 32);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (19, 20);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (18, 19);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (17, 25);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (17, 18);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (16, 26);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (15, 16);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (14, 16);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (14, 15);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (13, 50);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (13, 14);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (12, 16);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (12, 14);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (12, 13);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (11, 16);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (11, 12);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (10, 11);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (9, 10);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (8, 9);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (7, 9);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (7, 8);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (6, 7);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (5, 6);
INSERT INTO LIMITS (country_id, adjacent_country_id)VALUES (4, 17);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (4, 5);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (4, 7);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (3, 6);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (3, 7);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (3, 8);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (2, 8);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (2, 3);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (1, 45);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (1, 8);
INSERT INTO LIMITS(country_id, adjacent_country_id) VALUES (1, 2);

INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (49, 50);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (48, 50);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (47, 50);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (45, 46);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (43, 44);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (42, 45);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (42, 44);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (41, 42);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (42, 43);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (40, 41);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (39, 46);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (39, 45);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (39, 42);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (39, 41);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (39, 40);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (38, 43);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (38, 42);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (38, 41);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (37, 41);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (37, 40);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (37, 39);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (37, 38);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (36, 48);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (36, 39);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (35, 47);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (35, 39);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (35, 37);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (35, 36);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (33, 34);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (32, 37);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (32, 34);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (32, 33);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (29, 31);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (29, 30);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (28, 30);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (28, 29);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (27, 33);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (27, 32);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (27, 31);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (27, 28);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (26, 29);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (26, 28);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (26, 27);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (24, 26);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (24, 25);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (23, 24);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (22, 23);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (21, 23);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (21, 25);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (21, 27);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (21, 22);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (20, 27);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (20, 32);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (19, 38);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (19, 37);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (19, 32);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (19, 20);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (18, 19);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (17, 25);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (17, 18);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (16, 26);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (15, 16);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (14, 16);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (14, 15);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (13, 50);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (13, 14);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (12, 16);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (12, 14);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (12, 13);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (11, 16);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (11, 12);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (10, 11);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (9, 10);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (8, 9);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (7, 9);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (7, 8);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (6, 7);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (5, 6);
INSERT INTO LIMITS (adjacent_country_id, country_id)VALUES (4, 17);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (4, 5);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (4, 7);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (3, 6);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (3, 7);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (3, 8);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (2, 8);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (2, 3);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (1, 45);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (1, 8);
INSERT INTO LIMITS(adjacent_country_id, country_id) VALUES (1, 2);

INSERT INTO CARDS(id, idCardType, idCountry) VALUES (50, 4, 50);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (49, 4, 49);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (48, 3, 48);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (47, 3, 47);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (46, 3, 46);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (45, 3, 45);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (44, 3, 44);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (43, 3, 43);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (42, 3, 42);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (41, 3, 41);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (40, 3, 40);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (39, 3, 39);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (38, 3, 38);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (37, 3, 37);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (36, 3, 36);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (35, 3, 35);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (34, 3, 34);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (33, 3, 33);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (32, 2, 32);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (31, 2, 31);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (30, 2, 30);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (29, 2, 29);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (28, 2, 28);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (27, 2, 27);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (26, 2, 26);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (25, 2, 25);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (24, 2, 24);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (23, 2, 23);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (22, 2, 22);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (21, 2, 21);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (20, 2, 20);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (19, 2, 19);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (18, 2, 18);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (17, 2, 17);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (16, 1, 16);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (15, 1, 15);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (14, 1, 14);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (13, 1, 13);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (12, 1, 12);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (11, 1, 11);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (10, 1, 10);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (9, 1, 9);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (8, 1, 8);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (7, 1, 7);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (6, 1, 6);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (5, 1, 5);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (4, 1, 4);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (3, 1, 3);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (2, 1, 2);
INSERT INTO CARDS(id, idCardType, idCountry) VALUES (1, 1, 1);
 */
