CREATE TABLE usuario (
      numero		    INTEGER,
	  nombre		    VARCHAR(20),
	  apellido		    VARCHAR(20),
	  password		    VARCHAR(20),
      fechaNacimiento   DATE,
      foto  		    VARCHAR(20),
	  PRIMARY KEY (numero)
	);

CREATE TABLE cuenta (
      codigo		    INTEGER,
	  email             VARCHAR(20),
	  fechaAlta         DATE, 
	  maximoMensajes    INTEGER, 
	  costeMensajeExtra NUMERIC(6,2),
	  usuNumero		    INTEGER,
	  PRIMARY KEY (codigo),
	  FOREIGN KEY(usuNumero) REFERENCES usuario(numero)	  
	);
	
CREATE TABLE mensaje(
      numero         INTEGER PRIMARY KEY,
	  asunto         VARCHAR(20),
	  contenido 	 VARCHAR(100),
	  leido          INTEGER,
	  fecha          DATE, 
	  cueCodigoOrigen    	 INTEGER,
	  cueCodigoDestino   	 INTEGER,
  	  FOREIGN KEY(cueCodigoOrigen) REFERENCES cuenta(codigo),
	  FOREIGN KEY(cueCodigoDestino) REFERENCES cuenta(codigo)
	);

INSERT INTO usuario VALUES (1,'Ana','RUANO','ana','11/27/2001','1005.jpg');
INSERT INTO usuario VALUES (2,'Juan','RUIZ','juan','10/21/1998','1004.jpg');
INSERT INTO usuario VALUES (3,'Ines','GONZALEZ','ines','9/19/2003','1009.jpg');
	


INSERT INTO cuenta VALUES (1,'ana@mail.com','11/29/2019',5,1.49,1);
INSERT INTO cuenta VALUES (2,'juan@mail.com','10/29/2021',4,1.19,2);
INSERT INTO cuenta VALUES (3,'ana.pro@zmail.com','09/19/2020',5,1.99,1);
INSERT INTO cuenta VALUES (4,'juan@zmail.com','04/15/2021',3,1.25,2);
INSERT INTO cuenta VALUES (5,'ines@mail.com','11/11/2021',5,0.59,3);



INSERT INTO mensaje VALUES (1,'Primero','Hola. Primer mensaje',0,'1/24/2019',1,2);
INSERT INTO mensaje VALUES (2,'asuntoD','Su economía estaba basada, principalmente, en el sector del comercio',0,'4/21/2021',1,2);
INSERT INTO mensaje VALUES (3,'Primero','Hola. Primer mensaje',0,'11/6/2022',3,5);
INSERT INTO mensaje VALUES (4,'Primero','Hola. Primer mensaje',0,'8/10/2022',4,5);
INSERT INTO mensaje VALUES (5,'Primero','Hola. Primer mensaje',1,'5/9/2021',5,1);
INSERT INTO mensaje VALUES (6,'asuntoX','Su economía estaba basada, principalmente, en el sector del comercio',1,'5/10/2019',5,3);
INSERT INTO mensaje VALUES (7,'asuntoF','Su economía estaba basada, principalmente, en el sector del comercio',0,'2/2/2022',4,1);
INSERT INTO mensaje VALUES (8,'asuntoG','Su economía estaba basada, principalmente, en el sector del comercio',1,'8/2/2019',4,2);
INSERT INTO mensaje VALUES (9,'asuntoT','Su economía estaba basada, principalmente, en el sector del comercio',0,'5/27/2021',1,5);
INSERT INTO mensaje VALUES (10,'asuntoY','Su economía estaba basada, principalmente, en el sector del comercio',1,'1/15/2022',5,3);
INSERT INTO mensaje VALUES (11,'asuntoH','Su economía estaba basada, principalmente, en el sector del comercio',1,'9/18/2021',1,2);
INSERT INTO mensaje VALUES (12,'asuntoN','Su economía estaba basada, principalmente, en el sector del comercio',0,'6/26/2019',3,2);
INSERT INTO mensaje VALUES (13,'asuntoF','Su economía estaba basada, principalmente, en el sector del comercio',0,'8/17/2017',5,3);
INSERT INTO mensaje VALUES (14,'asuntoK','Su economía estaba basada, principalmente, en el sector del comercio',1,'9/14/2019',3,5);
INSERT INTO mensaje VALUES (15,'asuntoW','Su economía estaba basada, principalmente, en el sector del comercio',0,'12/16/2022',1,5);
INSERT INTO mensaje VALUES (16,'asuntoX','Su economía estaba basada, principalmente, en el sector del comercio',1,'5/14/2022',5,1);
INSERT INTO mensaje VALUES (17,'asuntoP','Su economía estaba basada, principalmente, en el sector del comercio',0,'4/18/2021',3,2);
INSERT INTO mensaje VALUES (18,'asuntoJ','Su economía estaba basada, principalmente, en el sector del comercio',1,'11/11/2017',1,3);
INSERT INTO mensaje VALUES (19,'asuntoK','Su economía estaba basada, principalmente, en el sector del comercio',1,'6/2/2022',3,2);
INSERT INTO mensaje VALUES (20,'asuntoA','Su economía estaba basada, principalmente, en el sector del comercio',0,'12/1/2017',3,5);
INSERT INTO mensaje VALUES (21,'asuntoE','Su economía estaba basada, principalmente, en el sector del comercio',1,'11/26/2022',5,1);
INSERT INTO mensaje VALUES (22,'asuntoS','Su economía estaba basada, principalmente, en el sector del comercio',1,'9/13/2019',4,2);
INSERT INTO mensaje VALUES (23,'asuntoQ','Su economía estaba basada, principalmente, en el sector del comercio',1,'2/26/2019',1,3);
INSERT INTO mensaje VALUES (24,'asuntoO','Su economía estaba basada, principalmente, en el sector del comercio',0,'12/24/2017',4,1);
INSERT INTO mensaje VALUES (25,'asuntoI','Su economía estaba basada, principalmente, en el sector del comercio',0,'2/18/2022',5,1);
INSERT INTO mensaje VALUES (26,'Ultimo','Adios. Ultimo mensaje',0,'11/30/2022',1,5);
INSERT INTO mensaje VALUES (27,'asuntoD','Su economía estaba basada, principalmente, en el sector del comercio',1,'2/16/2017',3,3);
INSERT INTO mensaje VALUES (28,'asuntoS','Su economía estaba basada, principalmente, en el sector del comercio',1,'8/26/2019',5,3);
INSERT INTO mensaje VALUES (29,'asuntoB','Su economía estaba basada, principalmente, en el sector del comercio',1,'3/27/2017',4,1);
INSERT INTO mensaje VALUES (30,'asuntoI','Su economía estaba basada, principalmente, en el sector del comercio',0,'2/18/2022',3,1);
INSERT INTO mensaje VALUES (31,'asuntoR','Su economía estaba basada, principalmente, en el sector del comercio',0,'12/23/2019',3,5);
INSERT INTO mensaje VALUES (32,'asuntoD','Su economía estaba basada, principalmente, en el sector del comercio',1,'2/16/2017',3,5);
INSERT INTO mensaje VALUES (33,'Ultimo','Adios. Ultimo mensaje',1,'11/30/2022',3,3);
INSERT INTO mensaje VALUES (34,'Ultimo','Adios. Ultimo mensaje',1,'11/30/2022',5,1);
INSERT INTO mensaje VALUES (35,'Ultimo','Adios. Ultimo mensaje',0,'11/30/2022',4,3);






