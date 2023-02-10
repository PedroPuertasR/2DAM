DROP TABLE IF EXISTS `libros`;

CREATE TABLE IF NOT EXISTS `libros` (
  `id` int(11) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  'isbn' varchar(13) NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  `precio` decimal(6,2) NOT NULL,
  'ventas' int(11)
  `foto` blob DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

INSERT INTO libro ('id', 'autor', 'nombre', 'isbn', 'fechaAlta', 'precio', 'foto') 
VALUES 
(1, 'Joe Abercrombie', 'Tierras Rojas','9788491810681', '2018-03-08', LOAD_FILE ()), 
(2, 'Kameron Hurley', 'Las estrellas son legion','9788491048411', '2017-11-23', LOAD_FILE ()), 
(3, 'Brandon Sanderson', 'El imperio final','9788418037214', '2021-08-07', LOAD_FILE ()), 
(4, 'Harold Sakuishi', 'Beck 1','9788419412430', '2022-01-12', LOAD_FILE ()), 
(5, 'Todd McFarlane', 'Spawn Integral nº 10','9788411120227', '2022-06-22', LOAD_FILE ()), 
(6, 'Villanelli', 'Star Wars Vader: Visiones Oscuras','9788413411811', '2020-09-06', LOAD_FILE ()), 
(7, 'Joyce Carol Oates', 'Babysitter','9788420463087', '2022-06-10', LOAD_FILE ()), 
(8, 'Javier Marias', 'Los dominios del lobo','9788420460338', '2021-09-09', 18.90, 4, 2);