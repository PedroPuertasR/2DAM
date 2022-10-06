/*Ejercicio práctico 1*/

declare
	numEmpl number(3) := 0;
begin
  insert into DEPART values(70, 'provisional', null);
  update EMPLE set DEPT_NO = 70 where DEPT_NO = 20;
  numEmpl := sql%rowcount;
  delete from DEPART where DEPT_NO = 20;
  dbms_output.put_line('Nº de empleados afectados: '|| numEmpl);
  
  exception
	when others then
		dbms_output.put_line('Error');
  
end;

/*Ejercicio práctico 2*/

declare
vapellido emple.apellido%type;
voficio emple.oficio%type;
begin
  select apellido, oficio into vapellido, voficio
  from emple
  where emp_no = 7900;
  
  dbms_output.put_line('El apellido es: ' || vapellido || ' y el oficio: ' || voficio);
  
end;

/*Ejercicio práctico 3*/

declare
vapellido emple.apellido%type;
voficio emple.oficio%type;
begin
  select apellido, oficio into vapellido, voficio
  from emple
  where emp_no = 7900;
  
  dbms_output.put_line('El apellido es: ' || vapellido || ' y el oficio: ' || voficio);
  
  exception
    when no_date_found then
        dbms_output.put_line('No existen datos.');
    when too_many_rows then
        dbms_output.put_line('Hay demasiados oficios.');
    when others then
        dbms_output.put_line('Error en la aplicación');

end;

/*Ejercicio práctico 4*/

create or replace trigger audit_borrado_empl
  before delete
  on emple
  for each row
begin

  dbms_output.put_line('Borrado empleado: ' || :old.emp_no || :old.apellido);

end;

/*Ejercicio práctico 5*/

declare
vnombre cliente.nombre%type;
begin
  select nombre into vnombre
  from clientes
  where nif = '&vn_cli'
  dbms_output.put_line(vnombre);
end;

/*Ejercicio práctico 6*/

create or replace procedure verDepartamento(num number)
as
	vnombre varchar2;
	vlocalidad varchar2;
begin
	select dnombre, loc into vnombre, vlocalidad
	from depart
	where dept_no = num;
	dbms_output.put_line('Código departamento: ' || num || '. Nombre: '
						 || vnombre || '. Localidad:' || vlocalidad);
exception
  when no_data_found then
  dbms_output.put_line('Departamento no encontrado.');
end;

/*Ejercicio práctico 7.1*/

create or replace procedure verPrecio(num number)
as
	vprecio productos.precio%type;
begin
	select precio_uni into vprecio
	from productos
	where cod_producto = num;
	dbms_output.put_line('Cod producto: ' || num || '. Precio: ' || vprecio || ' €.');
end;

/*Ejercicio práctica 7.2*/

create or replace procedure modPrecio(num number, nuevo number)
as
	vprecioant productos.precio%type;
begin
	select precio_uni into vprecioant
	from productos
	where cod_producto = num;
	if((precioant * 20/100) > (nuevo - precioant)) then
		update productos set precio_uni = nuevo where cod_producto = num;
	else
		dbms_output.put_line('Error hay demasiada varianza.');
	end if;
	exception
		when no_data_found then
		dbms_output.put_line('No ha introducido un valor.');
end;

/*Ejercicio práctico 7.3*/

create or replace function precioIVA(cantidad number, iva number default 16)
return number
as
	vresultado number;
begin
	vresultado := cantidad * (1 + (iva / 100));
	return vresultado;
end;

select cod_producto, precio_uni, precioIVA(precio_uni) from productos;

/*Actividades complementarias*/

/*Actividad 1*/

begin
dbms_output.put_line('Hola');
end;

/*Actividad 2*/

/*Guarda en una variable la cantidad de filas de la tabla productos y la imprime por consola.*/

/*Actividad 3*/

declare
  v_num number;
begin
  select count(*) into v_num
  from productos;
  dbms_output.put_line(v_num);
end;

/*Actividad 4*/

/*ERROR en línea 4:
ORA-06550: línea 4, columna 3:
PLS-00428: se espera una cláusula INTO en esta sentencia SELECT
ORA-06550: línea 4, columna 3:
PL/SQL: SQL Statement ignored*/

/*Actividad 5*/

/*

9
Procedimiento PL/SQL terminado correctamente.

*/

/*Actividad 6*/

/*Actividad 7*/

--create or replace procedure

--modificar_precio_producto

--num_producto y precio_nuevo

--precioant

/*
begin
	select precio_uni into vprecioant
	from productos
	where cod_producto = num;
	if((precioant * 20/100) > (nuevo - precioant)) then
		update productos set precio_uni = nuevo where cod_producto = num;
	else
		dbms_output.put_line('Error hay demasiada varianza.');
	end if;
	exception
		when no_data_found then
		dbms_output.put_line('No ha introducido un valor.');
end;
*/

/*
as
	vprecioant productos.precio%type;
*/

/*
exception
		when no_data_found then
		dbms_output.put_line('No ha introducido un valor.');
*/

-- Introduce los datos del select en una variable local

/*Es una excepción que cuando no encuentra los datos 
nos muestra el mensaje que hayamos escrito*/

-- Porque en los procedimientos "as" reemplaza a "declare"