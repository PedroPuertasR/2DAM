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

