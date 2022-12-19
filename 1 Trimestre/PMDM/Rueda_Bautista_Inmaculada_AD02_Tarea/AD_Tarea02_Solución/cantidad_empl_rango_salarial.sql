CREATE DEFINER=`root`@`localhost` PROCEDURE `cantidad_empl_rango_salarial`(in sal_min float, in sal_max float, out num int)
BEGIN
SELECT count(*)
INTO num
FROM empleados 
WHERE salario BETWEEN sal_min AND sal_max;
END