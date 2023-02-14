DROP TABLE IF EXISTS `libros`;

CREATE TABLE IF NOT EXISTS `libros` (
  `id` int(11) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `fechaAlta` date DEFAULT NULL,
  `precio` decimal(6,2) NOT NULL,
  `ventas` int(11),
  `foto` longblob DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

INSERT INTO libros (`id`, `autor`, `nombre`, `isbn`, `fechaAlta`, `precio`,`ventas`, `foto`) 
VALUES 
(1, 'Joe Abercrombie', 'Tierras Rojas','9788491810681', '2018-03-08', 18.90 ,23, LOAD_FILE('T:\tierrasrojas.jpg')), 
(2, 'Kameron Hurley', 'Las estrellas son legion','9788491048411', '2017-11-23', 15.50 ,20, LOAD_FILE('T:\lasestrellasson.jpg')), 
(3, 'Brandon Sanderson', 'El imperio final','9788418037214', '2021-08-07', 18.3 ,51, LOAD_FILE('T:\elimperiofinal.jpg')), 
(4, 'Harold Sakuishi', 'Beck 1','9788419412430', '2022-01-12', 9 ,13, LOAD_FILE('T:\beck1.jpg')), 
(5, 'Todd McFarlane', 'Spawn Integral nº 10','9788411120227', '2022-06-22', 9.90 ,21, LOAD_FILE('T:\spawn10.jpg')), 
(6, 'Villanelli', 'Star Wars Vader: Visiones Oscuras','9788413411811', '2020-09-06', 20 ,33, LOAD_FILE('T:\visionesoscuras.jpg')), 
(7, 'Joyce Carol Oates', 'Babysitter','9788420463087', '2022-06-10', 16, 8, LOAD_FILE('T:\babysitter.jpg')), 
(8, 'Javier Marias', 'Los dominios del lobo','9788420460338', '2021-09-09', 25, 12, LOAD_FILE('T:\losdominiosdellobo.jpg')),
(9, 'Brandon Sanderson', 'El pozo de la ascensión', '9788466658904','2016-09-21', 16.5, 20, LOAD_FILE('T:\pozodelaascension.jpg'));