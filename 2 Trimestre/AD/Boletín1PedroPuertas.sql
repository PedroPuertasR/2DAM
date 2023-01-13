/*Escribe un disparador que inserte en la tabla auditaremple(col1
(VARCHAR2(200)) cualquier cambio que supere el 5% del salario del
empleado indicando la fecha y hora, el empleado, y el salario anterior y
posterior.*/

--Actividad propuesta 1

create table auditaremple (
    col1 varchar2(200) primary key
);


create or replace trigger t1
after update on emple
for each row when(new.salario > old.salario + old.salario * 0.05)
begin
    dbms_output.put_line('Se está modificando el salario del empleado nº' || :old.emp_no);

    insert into auditaremple values ('Empleado: ' || :old.emp_no || ', fecha: ' || sysdate || ' ' || to_char(sysdate, 'HH24:MI:SS') || ', salario anterior: ' || :old.salario || '€, nuevo salario: ' || :new.salario || '€.');
end;


/*
Escribe un disparador de base de datos que permita
auditar las operaciones de inserción o borrado de
datos que se realicen en la tabla EMPLE según las
siguientes especificaciones:

-Se creará desde SQL*Plus la tabla auditaremple con la
columna col1 VARCHAR2(200).

-Cuando se produzca cualquier manipulación, se inser-
tará una fila en dicha tabla que contendrá: fecha y
hora, número de empleado, apellido y la operación de
actualización INSERCIÓN o BORRADO.
*/

--Actividad complementaria 1

create table auditaremple (
    col1 varchar2(200) primary key
);


create or replace trigger t2
after insert or delete on emple
for each row
begin

    if deleting then
        dbms_output.put_line('Se ha borrado al empleado nº' || :old.emp_no);
        insert into auditaremple values('Fecha: ' || sysdate || ' ' || to_char(sysdate, 'HH24:MI:SS') || ', nº empleado: ' || :old.emp_no || ', apellido: ' || :old.apellido || '. BORRADO.');
    else
        dbms_output.put_line('Se ha añadido al empleado nº' || :new.emp_no);
        insert into auditaremple values('Fecha: ' || sysdate || ' ' || to_char(sysdate, 'HH24:MI:SS') || ', nº empleado: ' || :new.emp_no || ', apellido: ' || :new.apellido || '. INSERCIÓN.');
    end if;
end;

/*
Escribe un trigger que permita auditar las modificacio-
nes en la tabla EMPLEADOS, insertando los siguientes
datos en la tabla auditaremple: fecha y hora, número de
empleado, apellido, la operación de actualización MODI-
FICACIÓN y el valor anterior y el valor nuevo de cada
columna modificada (sólo en las columnas modificadas).
*/

--Actividad complementaria 2

create table auditaremple (
    col1 varchar2(200) primary key
);

create or replace trigger t3
after update on emple
for each row
declare
    v1 varchar2(200);
begin
    dbms_output.put_line('Se ha modificado al empleado nº' || :old.emp_no);

    v1 := 'Modificación: ' || chr(10);
    
    if updating('emp_no') then

        v1 := v1 || 'Antigüo nº' || :old.emp_no || ', nuevo nº' || :new.emp_no || '.' || chr(10);

    end if;
    if updating('apellido') then

        v1 := v1 || 'Antigüo apellido: ' || :old.apellido || ', nuevo apellido: ' || :new.apellido || '.' || chr(10);

    end if;

    if updating('oficio') then

        v1 := v1 || 'Antigüo oficio: ' || :old.oficio || ', nuevo oficio: ' || :new.oficio || '.' || chr(10);

    end if;

    if updating('dir') then

        v1 := v1 || 'Antigüo jefe: ' || :old.dir || ', nuevo jefe: ' || :new.dir || '.' || chr(10);

    end if;

    if updating('fecha_alt') then

        v1 := v1 || 'Antigüa fecha: ' || :old.fecha_alt || ', nueva fecha: ' || :new.fecha_alt || '.' || chr(10);

    end if;

    if updating('salario') then

        v1 := v1 || 'Antigüo salario: ' || :old.salario || '€, nuevo salario: ' || :new.salario || '€.' || chr(10);

    end if;

    if updating('comision') then

        if :old.comision is NULL then

            v1 := v1 || 'Antigüa comisión: 0€, nueva comisión: ' || :new.comision || '€.' || chr(10);

        else

            if :new.comision is NULL then

                v1 := v1 || 'Antigüa comisión: ' || :old.comision || '€, nueva comisión: 0€.' || chr(10);

            else

                v1 := v1 || 'Antigüa comisión: ' || :old.comision || '€, nueva comisión: ' || :new.comision || '€.' || chr(10);

            end if;

        end if;

    end if;

    if updating('dept_no') then

        v1 := v1 || 'Antigüo dept: ' || :old.dept_no || ', nuevo dept: ' || :new.dept_no || '.' || chr(10);

    end if;

    insert into auditaremple values ('Fecha: ' || sysdate || ' ' || to_char(sysdate, 'HH24:MI:SS') || ', Nº: ' || :old.emp_no || ', apellido: ' || :old.apellido || ', ' || v1);
end;