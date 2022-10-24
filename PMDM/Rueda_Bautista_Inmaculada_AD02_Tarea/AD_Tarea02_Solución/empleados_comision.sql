CREATE PROCEDURE `empleados_comision` (in mini float, in maxi float, out cantidad int)
BEGIN
SELECT count(*)empleados_comisionempleados_comisioncantidad_empl_rango_salarial
INTO cantidad
FROM empleados
WHERE comision BETWEEN mini AND maxi;
END