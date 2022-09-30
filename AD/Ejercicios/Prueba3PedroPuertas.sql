ALTER TABLE departamentos ADD CONSTRAINT ck_mayor_cero_director CHECK (director_de > 0);
ALTER TABLE departamentos ADD CONSTRAINT ck_mayor_cero_presup CHECK (presup_de > 0);
ALTER TABLE departamentos ADD CONSTRAINT ck_director_tipo CHECK (tipodir_de LIKE ('F') OR ('P'));

ALTER TABLE habiempl ADD COLUMN nivel_he number (2);