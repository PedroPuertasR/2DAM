CREATE TABLE tienda(
    id INTEGER NOT NULL PRIMARY KEY,
    direccion VARCHAR2(100) NOT NULL,
    presupuesto NUMBER NOT NULL
);

INSERT INTO tienda VALUES (1, 'Calle El Greco 50', 10000.5);
INSERT INTO tienda VALUES (2, 'Avenida Luis Montoto 25', 8000.0);
INSERT INTO tienda VALUES (3, 'Calle Alas 12', 4500.0);

CREATE TABLE trabajador(
    id INTEGER NOT NULL PRIMARY KEY, 
    nombre VARCHAR2(50) NOT NULL, 
    apellidos VARCHAR2(100) NOT NULL, 
    dni VARCHAR2(9) NOT NULL UNIQUE, 
    fecha_cont DATE NOT NULL, 
    salario NUMBER NOT NULL,
    id_jefe INTEGER, 
    tienda INTEGER NOT NULL, 
    usuario VARCHAR2(30) NOT NULL, 
    pass VARCHAR2(30) NOT NULL, 
    foto VARCHAR2(30) NOT NULL, 
    CONSTRAINT fk_trabajador_jefe FOREIGN KEY (id_jefe) REFERENCES trabajador(id), 
    CONSTRAINT fk_trabajador_tienda FOREIGN KEY (tienda) REFERENCES tienda(id)
);

INSERT INTO trabajador VALUES(1, 'Alberto', 'Lopez Rodriguez', '42738623T', '16/06/2014', 2500, null, 1, 'alloro', 'alber2014', '1001.jpg');
INSERT INTO trabajador VALUES(2, 'Diego', 'Sánchez Garcia', '20676447E', '10/09/2019', 1400, 1, 1, 'disaga', 'diego2019', '1002.jpg');
INSERT INTO trabajador VALUES(3, 'Roberto', 'Rosado Aguilar', '12406219L', '11/12/2021', 2500, 1, 2, 'roroag', 'rober2021', '1004.jpg');
INSERT INTO trabajador VALUES(4, 'María', 'Rubio Lopez', '54122047B', '25/02/2018', 1600, 1, 3, 'marulo', 'maria2018', '1005.jpg');
INSERT INTO trabajador VALUES(5, 'Alba', 'Otero Blanco', '67134983F', '01/02/2021', 1500, 4, 3, 'alotbla', 'alba2021', '1007.jpg');
INSERT INTO trabajador VALUES(6, 'Sergio', 'Perez Crespo', '49778605G', '29/01/2022', 1000, 2, 1, 'sepecre', 'sergi2022', '1008.jpg');
INSERT INTO trabajador VALUES(7, 'Clara', 'Alarcon Garcia', '54391703S', '01/06/2020', 1550, 3, 2, 'clalgar', 'clara2020', '1009.jpg');
INSERT INTO trabajador VALUES(8, 'Andres', 'Pelayo Rodriguez', '56324370S', '21/12/2019', 1350, 3, 2, 'anpero', 'andre2019', '1012.jpg');

CREATE TABLE editorial(
    id INTEGER NOT NULL PRIMARY KEY, 
    nombre VARCHAR2(50) NOT NULL, 
    cif VARCHAR2(9) NOT NULL UNIQUE
);

INSERT INTO editorial VALUES(1, 'Alianza Editorial', 'A28085223');
INSERT INTO editorial VALUES(2, 'Nova Editorial', 'B79527610');
INSERT INTO editorial VALUES(3, 'Editorial Planeta SA', 'A08186249');
INSERT INTO editorial VALUES(4, 'Alfaguara Grupo Editorial SL', 'B87008595');

CREATE TABLE categoria(
    id INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL
);

INSERT INTO categoria VALUES(1, 'Fantasia');
INSERT INTO categoria VALUES(2, 'Ciencia ficcion');
INSERT INTO categoria VALUES(3, 'Comic');
INSERT INTO categoria VALUES(4, 'Suspense');
INSERT INTO categoria VALUES(5, 'Provisional');

CREATE TABLE libro(
    id INTEGER NOT NULL PRIMARY KEY, 
    autor VARCHAR2(100) NOT NULL, 
    nombre VARCHAR2(50) NOT NULL,
    id_editorial INTEGER NOT NULL,
    isbn VARCHAR2(13) NOT NULL UNIQUE,
    fecha_pub DATE NOT NULL,
    precio NUMBER NOT NULL,
    id_categoria INTEGER NOT NULL, 
    id_tienda INTEGER NOT NULL
);

ALTER TABLE libro ADD CONSTRAINT fk_libro_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id);
ALTER TABLE libro ADD CONSTRAINT fk_libro_editorial FOREIGN KEY (id_editorial) REFERENCES editorial(id);
ALTER TABLE libro ADD CONSTRAINT fk_libro_tienda FOREIGN KEY (id_tienda) REFERENCES tienda(id);

INSERT INTO libro VALUES(1, 'Joe Abercrombie', 'Tierras Rojas', 1, '9788491810681', '03/08/2018', 14.5, 2, 1);
INSERT INTO libro VALUES(2, 'Kameron Hurley', 'Las estrellas son legion', 1, '9788491048411', '23/11/2017', 18.95, 2, 3);
INSERT INTO libro VALUES(3, 'Brandon Sanderson', 'El imperio final', 2, '9788418037214', '07/08/2021', 29.90, 1, 3);
INSERT INTO libro VALUES(4, 'Harold Sakuishi', 'Beck 1', 2, '9788419412430', '12/01/2022', 15.95, 3, 1);
INSERT INTO libro VALUES(5, 'Todd McFarlane', 'Spawn Integral nº 10', 3, '9788411120227', '22/06/2022', 50.0, 3, 1);
INSERT INTO libro VALUES(6, 'Villanelli', 'Star Wars Vader: Visiones Oscuras', 3, '9788413411811', '06/09/2020', 16.95, 3, 1);
INSERT INTO libro VALUES(7, 'Joyce Carol Oates', 'Babysitter', 4, '9788420463087', '10/06/2022', 21.90, 2, 2);
INSERT INTO libro VALUES(8, 'Javier Marias', 'Los dominios del lobo', 4, '9788420460338', '09/09/2021', 18.90, 4, 2);