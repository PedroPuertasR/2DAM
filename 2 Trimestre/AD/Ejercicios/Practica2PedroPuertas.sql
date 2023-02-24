/*

Transforma tu BD Relacional a una BD Objeto Relacional.

Deberás crear objetos (con atributos y métodos) y tablas tipadas y relacionarlas mediante punteros. Inserta datos en ellas.
Crea un paquete para gestionar alguna de las tablas principales.
El paquete incluirá programas que realicen alta, baja, modificación y consulta de los datos.
Añade triggers de tablas y de sustitución que puedan ser útiles.
Utiliza también tipos registro y tablas indexadas.

*/

-- Drops de las tablas

drop table tienda;
drop table trabajador;
drop table editorial;
drop table categoria;
drop table libro;

drop type t_tienda;
drop type t_trabajador;
drop type t_editorial;
drop type t_categoria;
drop type t_libro;


-- Creación de los objetos

create or replace type t_tienda as object(
    id INTEGER,
    direccion VARCHAR2(100),
    presupuesto NUMBER
);

create or replace type t_trabajador as object(
    id INTEGER,
    nombre VARCHAR2(50), 
    apellidos VARCHAR2(100),
    dni VARCHAR2(9), 
    fecha_cont DATE,
    salario NUMBER,
    pjefe ref t_trabajador,
    ptienda ref t_tienda,
    usuario VARCHAR2(30),
    pass VARCHAR2(30),
    foto VARCHAR2(30)
);

create or replace type t_editorial as object(
    id INTEGER, 
    nombre VARCHAR2(50), 
    cif VARCHAR2(9)
);

create or replace type t_categoria as object(
    id INTEGER,
    nombre VARCHAR2(50)
);

create or replace type t_libro as object(
    id INTEGER, 
    autor VARCHAR2(100), 
    nombre VARCHAR2(50),
    pedi ref t_editorial,
    isbn VARCHAR2(13),
    fecha_pub DATE,
    precio NUMBER,
    pcat ref t_categoria, 
    ptienda ref t_tienda,
    member function devolver_precio_noiva return number,
    member procedure modi_precio(porc number)
);

create or replace type body t_libro as

      member function devolver_precio_noiva
      return number
      is
            iva number := 21;
            precio_antes number := 0;
      begin
            precio_antes := self.precio - (self.precio * iva / 100);
            return precio_antes;
      end devolver_precio_noiva;

      member procedure modi_precio(porc number)
      is
      begin
            self.precio = self.precio * porc / 100;
      end;

end;

-- Creación de las tablas

create table tienda of t_tienda;

create table trabajador of t_trabajador;

create table editorial of t_editorial;

create table categoria of t_categoria;

create table libro of t_libro;

-- Inserts

insert into tienda values (1, 'Calle El Greco 50', 10000.5);
insert into tienda values (2, 'Avenida Luis Montoto 25', 8000.0);
insert into tienda values (3, 'Calle Alas 12', 4500.0);



insert into trabajador select 1, 'Alberto', 'López Rodríguez', '42738623t', '16/06/2014', 2500, null, ref(t), 'alloro', 'alber2014', '1001.jpg'
                       from tienda t
                       where t.id = 1;

insert into trabajador select 2, 'Diego', 'Sánchez García', '20676447e', '10/09/2019', 1400, ref(tr), ref(t), 'disaga', 'diego2019', '1002.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 1
                             and t.id = 1;

insert into trabajador select 3, 'Roberto', 'Rosado Aguilar', '12406219l', '11/12/2021', 2500, ref(tr), ref(t), 'roroag', 'rober2021', '1004.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 1
                             and t.id = 2;

insert into trabajador select 4, 'María', 'Rubio López', '54122047b', '25/02/2018', 1600, ref(tr), ref(t), 'marulo', 'maria2018', '1005.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 1
                             and t.id = 3;

insert into trabajador select 5, 'Alba', 'Otero Blanco', '67134983f', '01/02/2021', 1500, ref(tr), ref(t), 'alotbla', 'alba2021', '1007.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 4
                             and t.id = 3;

insert into trabajador select 6, 'Sergio', 'Pérez Crespo', '49778605g', '29/01/2022', 1000, ref(tr), ref(t), 'sepecre', 'sergi2022', '1008.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 2
                             and t.id = 1;

insert into trabajador select 7, 'Clara', 'Alarcón García', '54391703s', '01/06/2020', 1550, ref(tr), ref(t), 'clalgar', 'clara2020', '1009.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 3
                             and t.id = 2;

insert into trabajador select 8, 'Andrés', 'Pelayo Rodríguez', '56324370s', '21/12/2019', 1350, ref(tr), ref(t), 'anpero', 'andre2019', '1012.jpg'
                       from tienda t, trabajador tr
                       where tr.id = 3
                             and t.id = 2;


insert into editorial values(1, 'Alianza Editorial', 'A28085223');
insert into editorial values(2, 'Nova Editorial', 'B79527610');
insert into editorial values(3, 'Editorial Planeta SA', 'A08186249');
insert into editorial values(4, 'Alfaguara Grupo Editorial SL', 'B87008595');


insert into categoria values(1, 'Fantasía');
insert into categoria values(2, 'Ciencia ficción');
insert into categoria values(3, 'Cómic');
insert into categoria values(4, 'Suspense');
insert into categoria values(5, 'Provisional');


insert into libro select 1, 'Joe Abercrombie', 'Tierras Rojas', ref(e), '9788491810681', '03/08/2018', 14.5, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 1
                        and c.id = 2
                        and t.id = 1;

insert into libro select 2, 'Kameron Hurley', 'Las estrellas son legión', ref(e), '9788491048411', '23/11/2017', 18.95, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 1
                        and c.id = 2
                        and t.id = 3;

insert into libro select 3, 'Brandon Sanderson', 'El imperio final', ref(e), '9788418037214', '07/08/2021', 29.90, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 2
                        and c.id = 1
                        and t.id = 3;

insert into libro select 4, 'Harold Sakuishi', 'Beck 1', ref(e), '9788419412430', '12/01/2022', 15.95, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 2
                        and c.id = 3
                        and t.id = 1;

insert into libro select 5, 'Todd McFarlane', 'Spawn Integral nº 10', ref(e), '9788411120227', '22/06/2022', 50.0, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 3
                        and c.id = 3
                        and t.id = 1;

insert into libro select 6, 'Villanelli', 'Star Wars Vader: Visiones Oscuras', ref(e), '9788413411811', '06/09/2020', 16.95, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 3
                        and c.id = 3
                        and t.id = 1;

insert into libro select 7, 'Joyce Carol Oates', 'Babysitter', ref(e), '9788420463087', '10/06/2022', 21.90, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 4
                        and c.id = 2
                        and t.id = 2;

insert into libro select 8, 'Javier Marias', 'Los dominios del lobo', ref(e), '9788420460338', '09/09/2021', 18.90, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 4
                        and c.id = 4
                        and t.id = 2;

insert into libro select 9, 'Brandon Sanderson', 'El pozo de la ascensión', ref(e), '9788466658904','21/09/2016', 16.5, ref(c), ref(t)
                  from tienda t, editorial e, categoria c
                  where e.id = 2
                        and c.id = 1
                        and t.id = 2;


select nombre, l.pedi.nombre, l.pcat.nombre, l.ptienda.direccion
from libro l
where id = 5;

-- Creación de paquete

create or replace package pk_libro as
      procedure alta(vid integer, vautor varchar2, vnombre varchar2, visbn varchar2, vprecio number, vcat varchar2, vedi varchar2);
      procedure baja(vtienda integer);
      procedure modi_cat(vcat varchar2, vlibro varchar2);
      procedure modi_edi(vedi varchar2, vlibro varchar2);
      procedure dia_sin_iva(vtie varchar2);
      procedure consulta_autor(vautor varchar2);
      procedure consulta_tienda(vtienda varchar2);
end pk_libro;

create or replace package body pk_libro as
      procedure alta(vid integer, vautor varchar2, vnombre varchar2, visbn varchar2, vprecio number, vcat varchar2, vedi varchar2) is
      begin

      end;

      procedure baja(vtienda integer) is
            cursor c1(tie integer) is select *
                                      from libro
                                      where ptienda.id = tie;
            contador number := 0;
      begin

            for v1 in c1(vtienda) loop
                  delete from libro where id = v1.id;
                  contador := contador + 1;
            end loop;

            if contador = 0 then
                  raise_application_error(-20002, 'El número de tienda no existe, o no existe ninguna fila con esa tienda.');
            else
                  dbms_output.put_line('Se han borrado ' || contador || ' filas.');
            end if;

      end;

      procedure modi_cat(vcat varchar2, vlibro varchar2) is
            vid categoria.id%type;
            vid_libro libro.id%type;
      begin
            select id into vid
            from categoria
            where nombre = vcat;

            select 


      end;

      procedure modi_edi(vedi varchar2, vlibro varchar2) is
      begin
            select 
      end;

      procedure dia_sin_iva (vdir varchar2) is
            cursor c1(dir varchar2) is select * 
                         from libro
                         where ptienda.id = (select id
                                             from tienda
                                             where direccion = dir);
            vlibro t_libro;
      begin
            for v1 in c1(vdir) loop
                  if v1.precio > 15 then
                        select deref()
                  end if;
            end loop;
      end;

      procedure consulta_autor(vautor varchar2) is
            cursor c1 is select *
      begin

      end;

      procedure consulta_tienda(vtienda varchar2) is
            vid tienda.id%type;
      begin
            select id into vid
            from tienda
            where direccion = vtienda;


      end;
end pk_libro;


declare
  vtrab t_trabajador;
begin
  select ref(t) into vtrab
  from trabajador t
  where id = 1;
  
  dbms_output.put_line('Nombre: ' || DEREF(vtrab).nombre);
end;
