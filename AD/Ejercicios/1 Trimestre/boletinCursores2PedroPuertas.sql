/*Ejercicio práctico 3*/

declare
    cursor c1 is select apellido, fecha_alt from emple order by fecha_alt;
    vdat c1%rowtype;
begin
end;