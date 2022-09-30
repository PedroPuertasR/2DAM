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
  where cliente_no = 
end;