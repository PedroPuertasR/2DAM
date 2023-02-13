/*
1.- Se desea anotar en la tabla auditoria cualquier hecho ocurrido (insertar,
borrar o modificar) y el número de filas afectadas sobre la tabla emple. (Ej:
"Se han borrado 5 filas")
Resolver utilizando Triggers y Paquetes.
*/

create table auditoria(
	cambios	varchar2(30)
);

create or replace package pk1 as
    contador number;
end;

create or replace trigger t1
before insert or update or delete on emple
begin
    pk1.contador := 0;
end;

create or replace trigger t2
after insert or update or delete on emple
for each row
begin
    pk1.contador := pk1.contador + 1;
end;

create or replace trigger t3
after insert or update or delete on emple
begin
    if inserting then
        insert into auditoria values ('Se han insertado: ' || pk1.contador || ' filas.');
    elsif deleting then
        insert into auditoria values ('Se han borrado: ' || pk1.contador || ' filas.');
    else
        insert into auditoria values ('Se han actualizado: ' || pk1.contador || ' filas.');
    end if;
end;

/*
2.- Se quiere conseguir la siguiente funcionalidad:
Al borrar un empleado, el campo dir se pondrá igual a nulo en todos los
empleados que dependan de él.
Resolver utilizando Triggers y Paquetes.
*/

create or replace package pk1 as
    type t_emple is table of emple.emp_no%type INDEX BY BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1
after delete on emple
for each row
begin
    pk1.tipo1(:old.emp_no) := :old.emp_no;
end;

create or replace trigger t2
before delete on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t3
after delete on emple
declare
    i number;
begin
    for i in pk1.tipo1.first .. pk1.tipo1.last LOOP
        update emple set dir = null where dir = pk1.tipo1(i);
    end loop;
    
end;

/*
3.- Retomamos los ejercicios 2 y 3 del boletin 4. Cargamos los dos y
modificamos el código del departamento 10. Su nuevo valor será 11. Resolver
utilizando Triggers y Paquetes.
*/

create or replace trigger t1
after update on depart
for each row
begin
    update emple set dept_no = :new.dept_no where dept_no = :old.dept_no;
end;

create or replace package pk1
as
    type t_emple is table of depart.dept_no%type INDEX BY BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t2
before update on depart
begin
    pk1.tipo1.delete;
end;

create or replace trigger t3
after update on depart
for each row
begin
    pk1.tipo1(:old.dept_no) := :new.dept_no;
end;

create or replace trigger t4
after update on depart
declare
    i number;
begin
    i := pk1.tipo1.first;

    while i is not null loop
        update emple set dept_no = pk1.tipo1(i) where dept_no = i;
        i := pk1.tipo1.next(i);
    end loop;
end;


/*
4.- Añadir un campo nuevo a la tabla depart llamado media_salario que almacene
la media de salarios de cada departamento.
Se quiere que se actualice su valor al insertar, borrar y modificar la tabla
emple. Resolver utilizando Triggers y Paquetes.
*/

alter table depart add media_salario number;

create or replace package pk1 as
    type t_emple is table of emple.salario%type index by BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1
before insert or update or delete on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t2
after insert or update or delete on emple
for each row
begin
    pk1.tipo1(:new.emp_no) := :new.dept_no;
end;

create or replace trigger t3
after insert or update or delete on emple
declare
    i number;
    num_emple number;
begin
    
    i := pk1.tipo.first;

    while i is not null loop
        select count(*) into num_emple
        from emple
        where dept_no = pk1.tipo(i);

        update depart set media_salario = media_salario + media_salario * num_emple / 100 where dept_no = pk1.tipo1(i);

        i := pk1.tipo.next(i);
    end loop;

end;
