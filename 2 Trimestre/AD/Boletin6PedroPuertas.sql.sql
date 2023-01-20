/*
1.- Dada la vista Vnotas( Nombrealumno,NombreAsignatura,Nota), diseñar
disparadores para:
-Insertar una nueva nota.
-Modificar la nota de un alumno
-Borrar una nota.
-Borrar todas las notas de un alumno.
*/

create view vnotas as select apenom, nombre, nota
                  from alumnos, asignaturas, notas
                  where alumnos.dni = notas.dni
                        and asignaturas.cod = notas.cod;

--1.1

create or replace trigger t1
instead of insert on vnotas
declare
    vdni alumnos.dni%type;
    vcod asignaturas.cod%type;
begin
    select alumnos.dni, asignaturas.cod into vdni, vcod
    from alumnos, asignaturas, notas
    where alumnos.dni = notas.dni
            and asignaturas.cod = notas.cod
            and nombre = :new.nombre
            and apenom = :new.apenom;

    insert into notas values (vdni, vcod, :new.nota);

    dbms_output.put_line('Vista actualizada.');
end;

insert into vnotas values ('Alcalde García, Elena', 'Análisis', 8);

--1.2

create or replace trigger t1
instead of update of nota on vnotas
declare
    vdni alumnos.dni%type;
    vcod asignaturas.cod%type;
begin
    select dni into vdni
    from alumnos
    where apenom = :old.apenom;

    select cod into vcod
    from asignaturas
    where nombre = :old.nombre;

    update notas set nota = :new.nota where dni = vdni and cod = vcod;

    dbms_output.put_line('Vista actualizada.');
end;

update vnotas set nota = 9 where apenom = 'Alcalde García, Elena' and nombre = 'Sist. Informáticos';

--1.3

create or replace trigger t1
instead of delete on vnotas
declare
    vdni alumnos.dni%type;
    vcod asignaturas.cod%type;
begin
    select cod into vcod
    from asignaturas
    where nombre = :old.nombre;

    select dni into vdni
    from alumnos
    where apenom = :old.apenom;

    delete from notas where dni = vdni and cod = vcod;

    dbms_output.put_line('Vista actualizada.');
end;

delete from vnotas where apenom = 'Alcalde García, Elena' and nombre = 'Sist. Informáticos';

--1.4

create or replace trigger t1
instead of delete on vnotas
declare
    vdni alumnos.dni%type;
begin

    select dni into vdni
    from alumnos
    where apenom = :old.apenom;

    delete from notas where dni = vdni;

    dbms_output.put_line('Vista actualizada.');
end;

delete from vnotas where apenom = 'Alcalde García, Elena';

/*
2.-Crear una vista, en la que aparezca el apellido del empleado, el
nombre de su departamento, y el apellido de su jefe.
Diseñar disparadores que permitan:
- Insertar un nuevo empleado.
- Cambiar el departamento del empleado.
- Cambiar el jefe del empleado.
- Borrar un empleado. (Puede que sea jefe de otro)

CREATE TABLE EMPLE (
 EMP_NO    NUMBER(4) NOT NULL,
 APELLIDO  VARCHAR2(10)  ,
 OFICIO    VARCHAR2(10)  ,
 DIR       NUMBER(4) ,
 FECHA_ALT DATE      ,
 SALARIO   NUMBER(7),
 COMISION  NUMBER(7),
 DEPT_NO   NUMBER(2) NOT NULL) ;

 CREATE TABLE DEPART (
 DEPT_NO  NUMBER(2) NOT NULL,
 DNOMBRE  VARCHAR2(14), 
 LOC      VARCHAR2(14) ) ;

*/

--2.1

create view v1 as select e.apellido as apeemp, dnombre, d.apellido as apedir
                  from emple e, emple d, depart
                  where e.dept_no = depart.dept_no
                        and e.dir = d.emp_no;

create or replace trigger t1
instead of insert on v1
declare
    vdir emple.dir%type;
    vdept depart.dept_no%type;
begin
    select emp_no into vdir
    from emple
    where apellido = :new.apedir;

    select dept_no into vdept
    from depart
    where dnombre = :new.dnombre;

    insert into 
end;