CREATE TABLE autor (
	numero INTEGER,
	nombre VARCHAR(30),
	apellido VARCHAR(30),
	passowrd VARCHAR(30),
	foto VARCHAR(30),
	nacimiento DATE,
	PRIMARY KEY (numero)
);

CREATE TABLE libro (
	codigo INTEGER,
	titulo VARCHAR(30),
	fechaPublicacion DATE,
	precio DOUBLE,
	imagen VARCHAR(30),
	autNumero INTEGER CONSTRAINT prestamo_FK_autor REFERENCES autor,
	PRIMARY KEY (codigo)
);

INSERT INTO autor  VALUES (1,'Javier','Perez','javier','imagen01.jpg','1993-08-01');
INSERT INTO autor  VALUES (2,'Sara','Garcia','sara','imagen02.jpg','1975-03-20');
INSERT INTO autor  VALUES (3,'Lucas','Rubio','lucas','imagen03.jpg','2000-10-13');

INSERT INTO libro VALUES (1,'Locos','2018-08-01',25,'imagen01.jpg',2);
INSERT INTO libro VALUES (2,'Lluvia azul','2018-06-17',30,'imagen02.jpg',2);
INSERT INTO libro VALUES (3,'Libres','2019-10-21',15,'imagen03.jpg',1);
INSERT INTO libro VALUES (4,'Los amantes de lo ajeno','2015-02-01',27,'imagen04.jpg',2);
INSERT INTO libro VALUES (5,'Corazón salvaje','2014-07-24',23, 'imagen05.jpg',1);
INSERT INTO libro VALUES (6,'Ver el amacer','2018-03-28',19,'imagen06.jpg',1);
INSERT INTO libro VALUES (7,'Sin salida','2017-12-05',30,'imagen07.jpg',2);
INSERT INTO libro VALUES (8,'La dehesa','2019-05-25',19,'imagen08.jpg',2);
INSERT INTO libro VALUES (9,'Al sol','2020-01-01',19,'imagen09.jpg',2);
INSERT INTO libro VALUES (10,'El Manifiesto','2015-11-01',75,'imagen10.jpg',1);
INSERT INTO libro VALUES (11,'Sólo','2014-02-27',31,'imagen11.jpg',1);
INSERT INTO libro VALUES (12,'En el nombre de','2019-04-15',75,'imagen12.jpg',2);
INSERT INTO libro VALUES (13,'Despierta','2019-03-27',31,'imagen13.jpg',1);
INSERT INTO libro VALUES (14,'100 Noches','2021-10-15',75,'imagen14.jpg',2);
INSERT INTO libro VALUES (15,'Libre','2022-12-27',31,'imagen15.jpg',1);
INSERT INTO libro VALUES (16,'Siempre joven','2021-11-19',75,'imagen16.jpg',2);
INSERT INTO libro VALUES (17,'El color del miedo','2020-11-25',31,'imagen17.jpg',1);
INSERT INTO libro VALUES (18,'Triana','2016-10-11',75,'imagen18.jpg',2);
INSERT INTO libro VALUES (19,'La gran guerra','2012-01-07',31,'imagen19.jpg',1);
INSERT INTO libro VALUES (20,'Esencia','2018-08-18',75,'imagen20.jpg',2);
INSERT INTO libro VALUES (21,'No puedo','2020-10-20',75,'imagen21.jpg',2);
INSERT INTO libro VALUES (22,'Los hombres del norte','2021-04-22',31,'imagen22.jpg',1);
INSERT INTO libro VALUES (23,'Harry Potter','2019-12-21',75,'imagen23.jpg',2);
INSERT INTO libro VALUES (24,'Candido','2022-03-17',31,'imagen24.jpg',1);
INSERT INTO libro VALUES (25,'Matar a un ruiseñor','2023-03-08',75,'imagen25.jpg',2);

