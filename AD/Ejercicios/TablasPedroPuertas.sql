DROP TABLE habiempl;
DROP TABLE habilidades;
DROP TABLE departamentos;
DROP TABLE centros;
DROP TABLE hijos;
DROP TABLE empleados;

CREATE TABLE habilidades (
	cod_ha char (5),
	desc_ha varchar2 (30) NOT NULL UNIQUE,
	CONSTRAINT pk_habilidades PRIMARY KEY (cod_ha)
);

CREATE TABLE centros (
	cod_ce char (4),
	director_ce number (6),
	nomb_ce varchar2 (30) NOT NULL,
	direcc_ce varchar2 (50) NOT NULL,
	poblac_ce varchar2 (15) NOT NULL,
	CONSTRAINT pk_centros PRIMARY KEY (cod_ce)
);

CREATE TABLE departamentos (
	cod_de char (5),
	director_de number (6),
	deptjefe_de char (5),
	centro_de char (4) NOT NULL,
	nomb_de varchar2 (40) NOT NULL,
	presup_de number (11) NOT NULL,
	tipodir_de char (1) NOT NULL,
	CONSTRAINT pk_departamentos PRIMARY KEY (cod_de)
);

CREATE TABLE empleados (
	cod_em number (6),
	dept_em char (5) NOT NULL,
	exttel_em char (9),
	fecinc_em date NOT NULL,
	fecnac_em date NOT NULL,
	dni_em varchar2 (9) UNIQUE,
	nomb_em varchar2 (40) NOT NULL,
	numhij_em number (2) NOT NULL,
	salario_em number (9) NOT NULL,
	CONSTRAINT pk_empleados PRIMARY KEY (cod_em)
);

CREATE TABLE hijos (
	padre_hi number (6),
	numhij_hi number (2),
	fecnac_hi date NOT NULL,
	nomb_hi varchar2 (40) NOT NULL,
	CONSTRAINT pk_hijos PRIMARY KEY (padre_hi)
);

CREATE TABLE habiempl (
	codha_he char (5),
	codem_he number (6),
	CONSTRAINT pk_habiempl PRIMARY KEY (codha_he, codem_he)
);

ALTER TABLE empleados ADD CONSTRAINT fk_empleados_depart FOREIGN KEY (cod_de) REFERENCES departamentos;
ALTER TABLE centros ADD CONSTRAINT fk_centros_empleados FOREIGN KEY (director_ce) REFERENCES empleados;
ALTER TABLE empleados ADD CONSTRAINT fk_empleados_depart FOREIGN KEY (dept_em) REFERENCES departamentos;
ALTER TABLE hijos ADD CONSTRAINT fk_hijos_empleados FOREIGN KEY (padre_hi) REFERENCES empleados;
ALTER TABLE habiempl ADD CONSTRAINT fk_habiempl_habilidades FOREIGN KEY (codha_he) REFERENCES habilidades;
ALTER TABLE habiempl ADD CONSTRAINT fk_habiempl_empleados FOREIGN KEY (codem_he) REFERENCES empleados;
ALTER TABLE departamentos ADD CONSTRAINT fk_departamentos_empleados FOREIGN KEY (director_de) REFERENCES empleados;
ALTER TABLE departamentos ADD CONSTRAINT fk_departamentos_departjefe FOREIGN KEY (deptjefe_de) REFERENCES departamentos;
ALTER TABLE departamentos ADD CONSTRAINT fk_departamentos_centros FOREIGN KEY (centro_de) REFERENCES centros;
