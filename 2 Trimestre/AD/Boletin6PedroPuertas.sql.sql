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
begin
    select dept_no into vdept
    from depart
    where dnombre = :new.dnombre;

    update emple set dept_no = vdept where apellido = :old.apeemp;
end;

--2.3

create or replace trigger t1
instead of update on v1
declare
    vdir emple.dir%type;
begin
    select emp_no into vdir
    from emple
    where apellido = :new.apedir;

    update emple set dir = vdir where apellido = :new.apeemp;
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

CREATE TABLE clientes
	(nif		VARCHAR2(10) NOT NULL,
	nombre		VARCHAR2(15) NOT NULL,
	domicilio	VARCHAR2(15),
     CONSTRAINT pk_clientes
	PRIMARY KEY (nif)
	);

CREATE TABLE productos
	(cod_producto	NUMBER(4) 	NOT NULL,
	descripcion	VARCHAR2(15) 	NOT NULL,
	linea_producto	VARCHAR2(6) 	NOT NULL,
 	precio_uni	NUMBER(6) 	NOT NULL,
	stock		NUMBER(5)	NOT NULL,	
  CONSTRAINT pk_productos	
	PRIMARY KEY (cod_producto),
  CONSTRAINT ck_precio
	CHECK (precio_uni > 0)	
	);

    CREATE TABLE ventas
	(nif		VARCHAR2(10) NOT NULL,
	cod_producto	NUMBER(4)	NOT NULL,
	fecha		DATE		NOT NULL,
	unidades	NUMBER(3)	DEFAULT 1 NOT NULL,
    CONSTRAINT pk_ventas
	PRIMARY KEY (nif, cod_producto, fecha),
    CONSTRAINT fk_ventas_cliente
	FOREIGN KEY (nif)
	REFERENCES Clientes(nif) 
	ON DELETE CASCADE,
    CONSTRAINT fk_ventas_producto
	FOREIGN KEY (cod_producto)
	REFERENCES Productos(cod_producto)
	ON DELETE CASCADE,
    CONSTRAINT ck_unidades
	CHECK (unidades > 0)
	);
*/

create view as select nombre, descripcion, fecha, unidades, precio_uni, precio_uni * unidades as subtotal
               from clientes, productos, ventas
               where ventas.nif = clientes.nif
                     and ventas.cod_producto = productos.cod_producto;