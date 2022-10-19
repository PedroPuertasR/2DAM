CREATE TABLE profesor(
    codProfesor INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR2 (100) NOT NULL,
    horas NUMERIC(2,2) NOT NULL CHECK (horas >= 25 AND horas <= 35),
    fechaContrato DATE NOT NULL,
    notaCorteMedia NUMERIC(2,2) NOT NULL,
    foto VARCHAR2(30),
);

CREATE TABLE asignatura(
    codAsignatura INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR2 (20) NOT NULL,
    codProfesor INTEGER NOT NULL,
    notaCorte NUMERIC (2,2) NOT NULL,
    CONSTRAINT fk_asignatura_profesor FOREIGN KEY codProfesor REFERENCES profesor(codProfesor)
);

INSERT INTO alumno VALUES(1, 'Rocio Rodríguez López', 30.5, '01/09/2012', 0, '/p05_bds/fotos1005.jpg');
INSERT INTO alumno VALUES(2, 'Alvaro Gómez López', 28.0, '03/09/2020', 0, '/p05_bds/fotos1004.jpg');
INSERT INTO alumno VALUES(3, 'David González Puertos', 32.5, '10/09/2008', 0, '/p05_bds/fotos1001.jpg');

INSERT INTO asignatura VALUES(1, 'PSP', 1, 7.3);
INSERT INTO asignatura VALUES(2, 'PMDM', 1, 5);
INSERT INTO asignatura VALUES(3, 'PROG', 1, 6.5);
INSERT INTO asignatura VALUES(4, 'EMP', 2, 5.6);
INSERT INTO asignatura VALUES(5, 'FOL', 2, 6.5);
INSERT INTO asignatura VALUES(6, 'ING', 2, 5.0);
INSERT INTO asignatura VALUES(7, 'BD', 3, 8.0);
INSERT INTO asignatura VALUES(8, 'AD', 3, 6.3);
INSERT INTO asignatura VALUES(9, 'SIST', 3, 8.2);