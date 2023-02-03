EXECUTE DBMS_OUTPUT.ENABLE(10000)
/*AUMENTA EL TAMA�O DEL BUFFER*/

/* Creaci�n de la tabla SQL provincias para facilitar
   la creaci�n de la tabla PL/SQL */
CREATE TABLE provincias (
	mat 	VARCHAR2(2),
	prov 	VARCHAR2(11),
     cp 	VARCHAR(2)
); 
INSERT INTO PROVINCIAS VALUES('A','ALICANTE','03');
INSERT INTO PROVINCIAS VALUES('BA','BADAJOZ','06');
INSERT INTO PROVINCIAS VALUES('CC','CACERES','10');
INSERT INTO PROVINCIAS VALUES('GC','LAS PALMAS','35');
INSERT INTO PROVINCIAS VALUES('HU','HUESCA','22');
INSERT INTO PROVINCIAS VALUES('LU','LUGO','27');
INSERT INTO PROVINCIAS VALUES('O','OVIEDO','33');
INSERT INTO PROVINCIAS VALUES('S','CANTABRIA','39');
INSERT INTO PROVINCIAS VALUES('SS','GUIPUZCOA','20');
INSERT INTO PROVINCIAS VALUES('V','VALENCIA','46');
INSERT INTO PROVINCIAS VALUES('AB','ALBACETE','02');
INSERT INTO PROVINCIAS VALUES('BI','VIZCAYA','48');
INSERT INTO PROVINCIAS VALUES('CR','CIUDADREAL','13');
INSERT INTO PROVINCIAS VALUES('GE','GERONA','17');
INSERT INTO PROVINCIAS VALUES('J','JAEN','23');
INSERT INTO PROVINCIAS VALUES('M','MADRID','28');
INSERT INTO PROVINCIAS VALUES('OR','ORENSE','32');
INSERT INTO PROVINCIAS VALUES('SA','SALAMANCA','37');
INSERT INTO PROVINCIAS VALUES('T','TARRAGONA','43');
INSERT INTO PROVINCIAS VALUES('VA','VALLADOLID','47');
INSERT INTO PROVINCIAS VALUES('AL','ALMERIA','04');
INSERT INTO PROVINCIAS VALUES('BU','BURGOS','09');
INSERT INTO PROVINCIAS VALUES('CS','CASTELLON','12');
INSERT INTO PROVINCIAS VALUES('GR','GRANADA','18');
INSERT INTO PROVINCIAS VALUES('L','LERIDA','25');
INSERT INTO PROVINCIAS VALUES('MA','MALAGA','29');
INSERT INTO PROVINCIAS VALUES('P','PALENCIA','34');
INSERT INTO PROVINCIAS VALUES('SE','SEVILLA','41');
INSERT INTO PROVINCIAS VALUES('TE','TERUEL','44');
INSERT INTO PROVINCIAS VALUES('VI','ALAVA','01');
INSERT INTO PROVINCIAS VALUES('AV','AVILA','05');
INSERT INTO PROVINCIAS VALUES('C','LACORU�A','15');
INSERT INTO PROVINCIAS VALUES('CO','CORDOBA','14');
INSERT INTO PROVINCIAS VALUES('GU','GUADALAJARA','19');
INSERT INTO PROVINCIAS VALUES('LE','LEON','24');
INSERT INTO PROVINCIAS VALUES('MU','MURCIA','30');
INSERT INTO PROVINCIAS VALUES('PM','BALEARES','07');
INSERT INTO PROVINCIAS VALUES('SG','SEGOVIA','40');
INSERT INTO PROVINCIAS VALUES('TF','SANTACRUZ','38');
INSERT INTO PROVINCIAS VALUES('Z','ZARAGOZA','50');
INSERT INTO PROVINCIAS VALUES('B','BARCELONA','08');
INSERT INTO PROVINCIAS VALUES('CA','CADIZ','11');
INSERT INTO PROVINCIAS VALUES('CU','CUENCA','16');
INSERT INTO PROVINCIAS VALUES('H','HUELVA','21');
INSERT INTO PROVINCIAS VALUES('LO','LOGRO�O','26');
INSERT INTO PROVINCIAS VALUES('NA','NAVARRA','31');
INSERT INTO PROVINCIAS VALUES('PO','PONTEVEDRA','36');
INSERT INTO PROVINCIAS VALUES('SO','SORIA','42');
INSERT INTO PROVINCIAS VALUES('TO','TOLEDO','45');
INSERT INTO PROVINCIAS VALUES('ZA','ZAMORA','49');

