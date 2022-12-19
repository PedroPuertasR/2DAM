CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE IF NOT EXISTS socio (
    numeroID INT NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    fecha_nacimiento DATE,
    fecha_alta DATE,
    municipio VARCHAR(25),
    PRIMARY KEY (numeroID)
);

INSERT INTO socio VALUES (1,'Jose','Sanchez','2001-9-2','2015-10-5','Gines');
INSERT INTO socio VALUES (2,'Ana','Garcia','1994-11-21','2015-11-4','Tomares');
INSERT INTO socio VALUES (3,'Sara','Moreno','1983-8-19','2015-12-7','Espartina');
INSERT INTO socio VALUES (4,'Claudia','Ortiz','1999-12-25','2016-1-22','Camas');
INSERT INTO socio VALUES (5,'Pablo','Sanchez','2002-1-7','2016-2-19','Castilleja');

CREATE TABLE libro (
    codigoID INT NOT NULL,
    titulo varchar(100),
    autor varchar(100),
    fecha_escrito DATE,
    precio DEC(6,2),
    PRIMARY KEY (codigoID)    
);

INSERT INTO libro VALUES (1,'Los anillos de Marte','Juana Luna','2001-5-28',23.55);
INSERT INTO libro VALUES (2,'Nosotros','Manuel Salgado','2005-1-15',35.75);
INSERT INTO libro VALUES (3,'Un año sin','Pablo Camino','1995-8-21',15.25);
INSERT INTO libro VALUES (4,'Pacto con el diablo','Ana Garcia','1996-9-11',20.00);
INSERT INTO libro VALUES (5,'1945','Juana Luna','2007-12-6',44.95);

CREATE TABLE prestamo (
    numeroID INT NOT NULL,
    fecha DATE,
    fecha_devolucion DATE,
    numeroID_socio INT,
    codigoID_libro INT,
    PRIMARY KEY (numeroID),
    FOREIGN KEY (numeroID_socio) REFERENCES socio(numeroID),    
    FOREIGN KEY (codigoID_libro) REFERENCES libro(codigoID)
);

INSERT INTO prestamo VALUES (1,'2017-2-3','2017-2-10',1,1);
INSERT INTO prestamo VALUES (2,'2017-2-8','2017-2-19',2,2);
INSERT INTO prestamo VALUES (3,'2017-3-1','2017-3-5',3,3);
INSERT INTO prestamo VALUES (4,'2017-3-4','2017-3-15',5,5);
INSERT INTO prestamo VALUES (5,'2017-3-8','2017-3-12',1,1);
INSERT INTO prestamo VALUES (6,'2017-3-14','2017-3-18',2,5);
INSERT INTO prestamo VALUES (7,'2017-3-18','2017-3-19',3,3);
INSERT INTO prestamo VALUES (8,'2017-3-28','2017-4-5',3,4);
INSERT INTO prestamo VALUES (9,'2017-4-2','2017-4-5',5,3);
INSERT INTO prestamo VALUES (10,'2017-4-2','2017-4-15',3,5);
INSERT INTO prestamo VALUES (11,'2017-4-4','2017-4-11',1,1);
INSERT INTO prestamo VALUES (12,'2017-4-5','2017-4-15',5,2);
INSERT INTO prestamo VALUES (13,'2017-4-17','2017-5-1',3,5);
INSERT INTO prestamo VALUES (14,'2017-5-1','2017-5-9',1,4);
INSERT INTO prestamo VALUES (15,'2017-5-3','2017-5-9',3,3);

COMMIT;

