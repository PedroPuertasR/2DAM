CREATE DATABASE libreria;

USE libreria;

CREATE TABLE IF NOT EXISTS tienda(id INTEGER NOT NULL PRIMARY KEY, direccion VARCHAR(100) NOT NULL, presupuesto DECIMAL NOT NULL);

INSERT INTO tienda VALUES (1, 'Calle El Greco 50', 10000.5);
INSERT INTO tienda VALUES (2, 'Avenida Luis Montoto 25', 8000.0);
INSERT INTO tienda VALUES (3, 'Calle Alas 12', 4500.0);

CREATE TABLE IF NOT EXISTS trabajador(id INTEGER NOT NULL PRIMARY KEY, nombre VARCHAR(50) NOT NULL, apellidos VARCHAR(100) NOT NULL, dni VARCHAR(9) NOT NULL UNIQUE, fecha_cont DATE NOT NULL, salario DECIMAL NOT NULL,id_jefe INTEGER, tienda INTEGER NOT NULL, usuario VARCHAR(30) NOT NULL, pass VARCHAR(30) NOT NULL, foto VARCHAR(30) NOT NULL, CONSTRAINT fk_trabajador_jefe FOREIGN KEY (id_jefe) REFERENCES trabajador(id), CONSTRAINT fk_trabajador_tienda FOREIGN KEY (tienda) REFERENCES tienda(id));

INSERT INTO trabajador VALUES(1, 'Alberto', 'López Rodríguez', '42738623T', '06/16/2014', 2500, null, 1, 'alloro', 'alber2014', '1001.jpg');
INSERT INTO trabajador VALUES(2, 'Diego', 'Sánchez García', '20676447E', '09/10/2019', 1400, 1, 1, 'disaga', 'diego2019', '1002.jpg');
INSERT INTO trabajador VALUES(3, 'Roberto', 'Rosado Aguilar', '12406219L', '12/11/2021', 2500, 1, 2, 'roroag', 'rober2021', '1004.jpg');
INSERT INTO trabajador VALUES(4, 'María', 'Rubio López', '54122047B', '02/25/2018', 1600, 1, 3, 'marulo', 'maria2018', '1005.jpg');
INSERT INTO trabajador VALUES(5, 'Alba', 'Otero Blanco', '67134983F', '02/01/2021', 1500, 4, 3, 'alotbla', 'alba2021', '1007.jpg');
INSERT INTO trabajador VALUES(6, 'Sergio', 'Pérez Crespo', '49778605G', '01/29/2022', 1000, 2, 1, 'sepecre', 'sergi2022', '1008.jpg');
INSERT INTO trabajador VALUES(7, 'Clara', 'Alarcón García', '54391703S', '06/01/2020', 1550, 3, 2, 'clalgar', 'clara2020', '1009.jpg');
INSERT INTO trabajador VALUES(8, 'Andrés', 'Pelayo Rodríguez', '56324370S', '12/21/2019', 1350, 3, 2, 'anpero', 'andre2019', '1012.jpg');

CREATE TABLE IF NOT EXISTS editorial(id INTEGER NOT NULL PRIMARY KEY, nombre VARCHAR(50) NOT NULL, cif VARCHAR(9) NOT NULL UNIQUE);

INSERT INTO editorial VALUES(1, 'Alianza Editorial', 'A28085223');
INSERT INTO editorial VALUES(2, 'Nova Editorial', 'B79527610');
INSERT INTO editorial VALUES(3, 'Editorial Planeta SA', 'A08186249');
INSERT INTO editorial VALUES(4, 'Alfaguara Grupo Editorial SL', 'B87008595');

CREATE TABLE IF NOT EXISTS categoria(id INTEGER NOT NULL PRIMARY KEY, nombre VARCHAR(50) NOT NULL);

INSERT INTO categoria VALUES(1, 'Fantasía');
INSERT INTO categoria VALUES(2, 'Ciencia ficción');
INSERT INTO categoria VALUES(3, 'Cómic');
INSERT INTO categoria VALUES(4, 'Suspense');


CREATE TABLE IF NOT EXISTS libro(id INTEGER NOT NULL PRIMARY KEY, autor VARCHAR (100) NOT NULL, nombre VARCHAR (50) NOT NULL, editorial INTEGER NOT NULL, isbn VARCHAR (13) NOT NULL UNIQUE, fecha_pub DATE NOT NULL, precio DECIMAL NOT NULL, categoria INTEGER NOT NULL, tienda INTEGER NOT NULL, CONSTRAINT fk_libro_categoria FOREIGN KEY categoria REFERENCES categoria(id), CONSTRAINT fk_libro_editorial FOREIGN KEY editorial REFERENCES editorial(id), CONSTRAINT fk_libro_tienda FOREIGN KEY tienda REFERENCES tienda(id));

INSERT INTO libro VALUES(1, 'Joe Abercrombie', 'Tierras Rojas', 1, '9788491810681', '08/03/2018', 14.5, 2, 1);
INSERT INTO libro VALUES(2, 'Kameron Hurley', 'Las estrellas son legión', 1, '9788491048411', '11/23/2017', 18.95, 2, 3);
INSERT INTO libro VALUES(3, 'Brandon Sanderson', 'El imperio final', 2, '9788418037214', '08/07/2021', 29.90, 1, 3);
INSERT INTO libro VALUES(4, 'Harold Sakuishi', 'Beck 1', 2, '9788419412430', '01/12/2022', 15.95, 3, 1);
INSERT INTO libro VALUES(5, 'Todd McFarlane', 'Spawn Integral nº 10', 3, '9788411120227', ' 06/22/2022', 50.0, 3, 1);
INSERT INTO libro VALUES(6, 'Villanelli', 'Star Wars Vader: Visiones Oscuras', 3, '9788413411811', '09/06/2020', 16.95, 3, 1);
INSERT INTO libro VALUES(7, 'Joyce Carol Oates', 'Babysitter', 4, '9788420463087', '06/10/2022', 21.90, 2, 2);
INSERT INTO libro VALUES(8, 'Javier Marías', 'Los dominios del lobo', 4, '9788420460338', '09/09/2021', 18.90, 4, 2);