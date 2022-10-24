CREATE DEFINER=`root`@`localhost` PROCEDURE `subida_salario`(dep INT, subida INT)
BEGIN
UPDATE empleados 
SET salario=salario + (salario*subida/100) 
WHERE dept_no=dep;
END