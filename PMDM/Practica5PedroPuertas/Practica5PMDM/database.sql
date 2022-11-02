CREATE TABLE profesor(
    codProfesor INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    horas DECIMAL(5,2) NOT NULL CHECK (horas >= 25 AND horas <= 35),
    fechaContrato DATE NOT NULL,
    notaCorteMedia DECIMAL(5,2) NOT NULL,
    foto VARCHAR(30),
    usuario VARCHAR(20),
    pass VARCHAR(20)
);

INSERT INTO profesor VALUES(1, 'Rocio Rodríguez López', 30.5, '09/01/2012', 0, '/05_bds/fotos/fotos1005.jpg', 'rorolo', 'rodri2012');
INSERT INTO profesor VALUES(2, 'Alvaro Gómez López', 28.0, '03/09/2020', 0, '/p05_bds/fotos/fotos1004.jpg', 'algolo', 'gomez2020');
INSERT INTO profesor VALUES(3, 'David González Puertos', 32.5, '10/09/2008', 0, '/p05_bds/fotos/fotos1001.jpg', 'dagopu', 'gonza2008');

CREATE TABLE asignatura(
    codAsignatura INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    codProfesor INTEGER NOT NULL,
    notaCorte DECIMAL (5,2) NOT NULL,
    fechaCorte DATE NOT NULL,
    CONSTRAINT fk_asignatura_profesor FOREIGN KEY (codProfesor) REFERENCES profesor(codProfesor)
);

INSERT INTO asignatura VALUES(1, 'PSP', 1, 7.3, '06/25/2022');
INSERT INTO asignatura VALUES(2, 'PMDM', 1, 5, '06/25/2022');
INSERT INTO asignatura VALUES(3, 'PROG', 1, 6.5, '06/25/2022');
INSERT INTO asignatura VALUES(4, 'EMP', 2, 5.6, '06/25/2022');
INSERT INTO asignatura VALUES(5, 'FOL', 2, 6.5, '06/25/2022');
INSERT INTO asignatura VALUES(6, 'ING', 2, 5.0, '06/25/2022');
INSERT INTO asignatura VALUES(7, 'BD', 3, 8.0, '06/25/2022');
INSERT INTO asignatura VALUES(8, 'AD', 3, 6.3, '06/25/2022');
INSERT INTO asignatura VALUES(9, 'SIST', 3, 8.2, '06/25/2022');