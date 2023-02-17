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
instead of update on vnotas
declare
    vdni alumnos.dni%type;
    vcod asignaturas.cod%type;
begin
    if updating('nota') then
        select dni into vdni
        from alumnos
        where apenom = :old.apenom;

        select cod into vcod
        from asignaturas
        where nombre = :old.nombre;

        update notas set nota = :new.nota where dni = vdni and cod = vcod;

        dbms_output.put_line('Vista actualizada.');
    end if; 
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
    vemp emple.emp_no%type;
    vdept depart.dept_no%type;
begin
    select emp_no into vdir
    from emple
    where apellido = :new.apedir;

    select dept_no into vdept
    from depart
    where dnombre = :new.dnombre;

    select * into vemp
    from (select emp_no + 1
          from emple
          order by emp_no desc)
    where rownum = 1;

    insert into emple (emp_no, apellido, dir, fecha_alt, dept_no) values (vemp, :new.apeemp, vdir, sysdate, vdept);
end;

--2.2

create or replace trigger t1
instead of update on v1
declare
    vdept depart.dept_no%type;
    volddept depart.dept_no%type;
    vemp emple.emp_no%type;
    vdir emple.emp_no%type;
begin
    if updating('dnombre') then
        select dept_no into vdept
        from depart
        where dnombre = :new.dnombre;

        select dept_no into volddept
        from depart
        where dnombre = :old.dnombre;

        select emp_no into vdir
        from emple
        where apellido = :old.apedir;

        select emp_no into vemp
        from emple
        where apellido = :new.apeemp
              and dir = vdir
              and dept_no = volddept;

        update emple set dept_no = vdept where emp_no = vemp;
    end if;
end;

update v1 set dnombre = 'INVESTIGACION' where apeemp = 'NEGRO' and apedir = 'REY';

--2.3

create or replace trigger t1
instead of update on v1
declare
    vdir emple.dir%type;
begin
    if updating('apedir') then
        select emp_no into vdir
        from emple
        where apellido = :new.apedir;

        update emple set dir = vdir where apellido = :new.apeemp;
    end if;
end;

--2.4

create or replace trigger t1
instead of delete on v1
declare
    vdir emple.emp_no%type;
begin

    select emp_no into vdir
    from emple
    where apellido = :old.apeemp;

    update emple set dir = null where dir = vdir;
    delete from emple where apellido = :old.apeemp;
end;

/*
3.- Dadas las tablas, Clientes,Productos,Ventas, crear una vista que
muestre:
Nombre del cliente,Descripción del producto, Fecha de
venta,unidades,PrecioUnitario, Subtotal(precio*unidades)
Diseñar disparadores para:
 - Insertar una venta.
 - Borrar una venta.
 - Modificar las unidades de una venta.
 - Borrar todas las ventas de un cliente.
 - Borrar todas las ventas de un producto. 
*/

create view v1 as select nombre, descripcion, fecha, unidades, precio_uni, precio_uni * unidades as subtotal
                from clientes, productos, ventas
                where ventas.nif = clientes.nif
                        and ventas.cod_producto = productos.cod_producto;

--3.1

create or replace trigger t1
instead of insert on v1
declare
    vnif clientes.nif%type;
    vcod productos.cod_producto%type;
begin
    select nif into vnif
    from clientes
    where nombre = :new.nombre;

    select cod_producto into vcod
    from productos 
    where descripcion = :new.descripcion;

    insert into ventas (nif, cod_producto, fecha, unidades) values (vnif, vcod, :new.fecha, :new.unidades);

    dbms_output.put_line('Venta nuevo introducida.');
end;

insert into v1 (nombre, descripcion, fecha, unidades) values ('JAIME', 'PLACA BASE VX', sysdate, 1);


--3.2

create or replace trigger t1
instead of delete on v1
declare
    vnif clientes.nif%type;
    vcod productos.cod_producto%type;
begin
    select clientes.nif, productos.cod_producto into vnif, vcod
    from ventas, clientes, productos
    where ventas.nif = clientes.nif
          and ventas.cod_producto = productos.cod_producto
          and descripcion = :old.descripcion
          and nombre = :old.nombre
          and fecha = :old.fecha;

    delete from ventas where nif = vnif and cod_producto = vcod and fecha = :old.fecha;

    dbms_output.put_line('Venta borrada.');
end;

delete from v1 where nombre = 'ALBERTO' and descripcion = 'PROCESADOR MMX' and fecha = '07/10/97';

--3.3

create or replace trigger t1
instead of update on v1
declare
    vnif clientes.nif%type;
    vcod productos.cod_producto%type;
    total productos.stock%type;
begin
    if updating('unidades') then
        total := :old.unidades - :new.unidades;

        select clientes.nif, productos.cod_producto into vnif, vcod
        from ventas, clientes, productos
        where ventas.nif = clientes.nif
            and ventas.cod_producto = productos.cod_producto
            and descripcion = :old.descripcion
            and nombre = :old.nombre
            and fecha = :old.fecha;

        update ventas set unidades = :new.unidades where nif = vnif and cod_producto = vcod and fecha = :new.fecha;

        update productos set stock = stock + total where cod_producto = vcod;

    end if;
end;

update v1 set unidades = 1 where nombre = 'JAIME' and descripcion = 'PLACA BASE VX' and fecha = '05/12/1997';

--3.4

create or replace trigger t1
instead of delete on v1
declare
    vnif clientes.nif%type;
begin
    select nif into vnif
    from clientes
    where nombre = :old.nombre;

    delete from ventas where nif = vnif;
end;

delete from v1 where nombre = 'JAIME';

--3.5

create or replace trigger t1
instead of delete on v1
declare
    vcod productos.cod_producto%type;
begin
    select cod_producto into vcod
    from productos
    where descripcion = :old.descripcion;

    delete from ventas where cod_producto = vcod;
end;

delete from v1 where descripcion = 'PLACA BASE VX';

/*
4.- Crear un trigger de sistema que inserte una fila en una tabla de
registros, creada previamente, con la siguiente información:
- Nombre del usuario, hora, 'Entrada' si se conecta a la BD
- Nombre del usuario, hora, 'Salida' si finaliza la conexión.

system
manager
*/

CREATE TABLE control_conexiones (
    usuario VARCHAR2(20),
    momento VARCHAR2(20), 
    evento VARCHAR2(20)
);

--4.1

create or replace trigger t1
after logon
on database
begin
    insert into control_conexiones values (USER, TO_CHAR(SYSDATE, 'HH24:MI:SS'), 'Entrada');
end;

--4.2

create or replace trigger t1
after logoff
on database
begin
    insert into control_conexiones values (USER, TO_CHAR(SYSDATE, 'HH24:MI:SS'), 'Salida');
end;