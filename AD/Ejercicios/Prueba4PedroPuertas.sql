--Ejercicio 6

SELECT cod_em, nomb_em
FROM empleados
WHERE cod_em NOT LIKE '%1%'
	  AND cod_em NOT LIKE '%4%'
	  AND cod_em NOT LIKE '%6%'
	  AND cod_em NOT LIKE '%8%'
	  AND cod_em NOT LIKE '%10%';
	  
-- Ejercicio 7

SELECT *
FROM empleados
WHERE exttel_em IS NULL;

-- Ejercicio 8

SELECT cod_de, nomb_de, presup_de
FROM departamentos
ORDER BY presup_de DESC;

-- Ejercicio 9

SELECT e.nomb_em,  h.nomb_hi, h.fecnac_hi
FROM empleados e, hijos h 
WHERE e.cod_em = h.padre_hi
	  AND e.numhij_em = 1
ORDER BY h.fecnac_hi;

-- Ejercicio 10

SELECT nomb_de, deptjefe_de
FROM departamentos
WHERE deptjefe_de IS NOT NULL;

-- Ejercicio 11

SELECT e.dni_em, e.nomb_em, d.nomb_de
FROM empleados e, departamentos d 
WHERE e.dept_em = d.cod_de
GROUP BY e.nomb_em;

-- Ejercicio 12

SELECT MIN(e.salario_em), MAX(e.salario_em), AVG(e.salario_em), d.cod_de, d.nomb_de
FROM empleados e, departamentos d 
WHERE e.dept_em = d.cod_de;

-- Ejercicio 13

SELECT AVG(salario_em) AS "euros", AVG(salario_em) * 166.386 AS "pesetas"
FROM empleados;

-- Ejercicio 14

SELECT nomb_hi
FROM hijos h, empleados e 
WHERE e.cod_em = h.padre_hi
	  AND e.nomb_em LIKE '%Correa%';

-- Ejercicio 15

SELECT d.nomb_de, SUM(e.salario_em) AS "total_salario"
FROM departamentos d, empleados e 
WHERE d.cod_de = e.dept_em
GROUP BY d.nomb_de
HAVING SUM(e.salario_em) >= (d.presup_de * 25 / 100);

-- Ejercicio 16

SELECT d.nomb_de
FROM departamentos d, empleado e
WHERE d.cod_de = e.dept_em
	  AND (e.salario_em * 166.386) / 12 >= 500000;

-- Ejercicio 17

SELECT exttel_em, AVG(salario_em)
FROM empleados
WHERE exttel_em IS NOT NULL
GROUP BY exttel_em;

-- Ejercicio 18

SELECT d.nomb_de, AVG(e.salario_em) AS "media"
FROM departamentos d, empleados e
WHERE d.cod_de = e.dept_em
GROUP BY d.nomb_de
HAVING MAX(e.salario_em) < AVG(e.salario_em);

-- Ejercicio 19

SELECT h.cod_ha, h.desc_ha
FROM habilidades h, habiempl he, empleados e
WHERE h.cod_ha = he.codha_he AND he.codem_he = e.cod_em
	  AND h.cod_ha NOT IN (SELECT codha_he
	  					   FROM habiempl);

-- Ejercicio 20

SELECT e.nomb_em, COUNT(he.codha_he)
FROM empleados e, habiempl he
WHERE e.cod_em = he.codem_he
GROUP BY e.nomb_em
HAVING COUNT(he.codha_he) >= 2;

-- Ejercicio 21

SELECT e.nomb_em, COUNT(he.codha_he)
FROM empleados e, habiempl he
WHERE e.cod_em = he.codem_he
GROUP BY e.nomb_em
HAVING MAX(SELECT he2.codha_he
		   FROM habiempl he2, empleados e2
		   WHERE e2.cod_em = he2.codem_he
		   GROUP BY e2.nomb_em);

-- Ejercicio 22

REM Nombre: Listado de salarios
REM Descripción: Comparación salarios con la media del departamento.
TTITLE 'Salario medio por departamento'
COLUMN d.nomb_de HEADING 'Departamento'
COLUMN media HEADING 'Salario medio' FORMAT 9G999
BREAK ON d.nomb_de SKIP 1
COLUMN e.nomb_em HEADING 'Empleado'
COLUMN e.salario_em HEADING 'Salario'

SET LINESIZE 50
SET PAGESIZE 50
SET NEWPAGE 0

SPOOL listado.lst

SELECT d.nomb_de, AVG(e.salario_em) AS "media"
FROM departamentos d, empleados e
WHERE e.dept_em = d.cod_de
GROUP BY d.nomb_de, e.nomb_em, e.salario_em;

SELECT e.nomb_em, e.salario_em
FROM empleados e;

TTITLE OFF
BTITTLE OFF

SPOOL OFF

-- Ejercicio 23

REM Nombre: Listado de centros
REM Descripción: Departamentos en cada centro.
TTITLE 'Departamentos en centros'
COLUMN d.nomb_de HEADING 'Departamento'
COLUMN mediaCentro HEADING 'Salario medio centro' FORMAT 9G999
BREAK ON c.nomb_ce SKIP 1
COLUMN mediaDepar HEADING 'Salario medio depart' FORMAT 9G999
BREAK ON d.nomb_de SKIP 1
COLUMN e.nomb_em HEADING 'Empleado'
COLUMN e.salario_em HEADING 'Salario'

SET LINESIZE 50
SET PAGESIZE 50
SET NEWPAGE 0

SPOOL listado.lst

SELECT e.nomb_em, e.salario_em
FROM empleados e;

SELECT c.nomb_ce, AVG(e.salario_em) AS "mediaCentro"
FROM centros c, departamentos d, empleados e
WHERE c.cod_ce = d.centro_de AND c.cod_de = e.dept_em
GROUP BY c.nomb_ce;

SELECT d.nomb_de, AVG(e.salario_em) AS "mediaDepar"
FROM departamentos d, empleados e
WHERE d.cod_de = e.dept_em
GROUP BY d.nomb_de;

TTITLE OFF
BTITTLE OFF

SPOOL OFF

-- Ejercicio 24

CREATE TABLE temp(
	codemp number (6),
	nomdept varchar2 (40),
	nomemp varchar2 (40),
	salemp number (9)
);

INSERT INTO temp (codemp, nomdept, nomemp, salemp)
SELECT (e.cod_em, d.nomb_de, e.nomb_em, e.salario_em)
FROM empleados e, departamentos d, centros c
WHERE e.dept_em = d.cod_de AND c.cod_ce = d.centro_de
	  AND c.poblac_ce LIKE 'MURCIA';

-- Ejercicio 25

UPDATE habiempl 