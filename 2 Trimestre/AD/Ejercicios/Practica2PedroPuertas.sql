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
            precio_act number := 0;
      begin
            precio_act := self.precio - (self.precio * iva / 100);
            return precio_act;
      end devolver_precio_noiva;

      member procedure modi_precio(porc number)
      is
      begin
            self.precio := self.precio * porc / 100;
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
      procedure alta(vautor varchar2, vnombre varchar2, visbn varchar2, vtienda number, vprecio number, vcat varchar2, vedi varchar2);
      procedure baja(vtienda integer);
      procedure modi_cat(vcat varchar2, vlibro varchar2);
      procedure modi_edi(vedi varchar2, vlibro varchar2);
      procedure dia_sin_iva(vtie varchar2);
      procedure consulta_autor(vautor varchar2);
      procedure consulta_tienda(vtienda varchar2);
end pk_libro;

create or replace package body pk_libro as
      procedure alta(vautor varchar2, vnombre varchar2, visbn varchar2, vtienda number, vprecio number, vcat varchar2, vedi varchar2) is
            vid libro.id%type;
            vidcat categoria.id%type;
            videdi editorial.id%type;
      begin
            select * into vid
            from(select id
                 from libro
                 order by id desc)
            where rownum = 1;

            vid := vid + 1;

            select id into vidcat
            from categoria
            where nombre = vcat;

            select id into videdi
            from editorial
            where nombre = vedi;

            insert into libro select vid, vautor, vnombre, ref(e), visbn, sysdate, vprecio, ref(c), ref(t)
                              from tienda t, editorial e, categoria c
                              where e.id = videdi
                                    and c.id = vidcat
                                    and t.id = vtienda;
      end;

      procedure baja(vtienda integer) is
            cursor c1(tie integer) is select *
                                      from libro l
                                      where l.ptienda.id = tie;
            contador number := 0;
      begin

            for v1 in c1(vtienda) loop
                  delete from libro where id = v1.id;
                  contador := contador + 1;
            end loop;

            if contador = 0 then
                  raise_application_error(-20002, 'No existe ninguna fila con esa tienda.');
            else
                  dbms_output.put_line('Se han borrado ' || contador || ' filas.');
            end if;

      end;

      procedure modi_cat(vcat varchar2, vlibro varchar2) is
            vid ref t_categoria;
            vid_libro libro.id%type;
      begin
            select ref(c) into vid
            from categoria c
            where nombre = vcat;

            select id into vid_libro
            from libro
            where nombre = vlibro;

            update libro set pcat = vid where id = vid_libro;

      end;

      procedure modi_edi(vedi varchar2, vlibro varchar2) is
            vid ref t_editorial;
            vid_libro libro.id%type;
      begin
            select ref(e) into vid
            from editorial e
            where nombre = vedi;

            select id into vid_libro
            from libro
            where nombre = vlibro;

            update libro l set pedi = vid where id = vid_libro;
      end;

      procedure dia_sin_iva (vtie varchar2) is
            cursor c1(dir varchar2) is select * 
                         from libro l
                         where l.ptienda.id = (select id
                                               from tienda
                                               where direccion = dir);
            vnuevo libro.precio%type;
            contador number := 0;
      begin
            for v1 in c1(vtie) loop
                  if v1.precio > 15 then
                        select l.devolver_precio_noiva into vnuevo
                        from libro l
                        where id = v1.id;

                        update libro set precio = vnuevo where id = v1.id;
                        contador := contador + 1;
                  end if;
            end loop;

            dbms_output.put_line('Se han actualizado: ' || contador || ' precios.');
      end;

      procedure consulta_autor(vautor varchar2) is
            cursor c1 is select nombre, isbn, precio, l.ptienda.direccion as tienda, l.pcat.nombre as cat, l.pedi.nombre as edi, fecha_pub
                         from libro l
                         where autor = vautor;
            contador number := 0;
      begin

            dbms_output.put_line('Autor: ' || vautor || chr(10));

            for v1 in c1 loop
                  dbms_output.put_line('Nombre: ' || v1.nombre || '. ISBN: ' || v1.isbn || '. Precio: ' || v1.precio || '€.');
                  dbms_output.put_line('Tienda: ' || v1.tienda || '. Categoría: ' || v1.cat || '. Editorial: ' || v1.edi || '. Fecha: ' || v1.fecha_pub || chr(10));
                  contador := contador + 1;
            end loop;

            dbms_output.put_line('Libros totales del autor: ' || contador);

      end;

      procedure consulta_tienda(vtienda varchar2) is
            vid tienda.id%type;
            cursor c1(vtie number) is select nombre, isbn, precio, l.ptienda.direccion as tienda, l.pcat.nombre as cat, l.pedi.nombre as edi, fecha_pub
                                      from libro l
                                      where l.ptienda.id = vtie;
            contador number := 0;
      begin
            select id into vid
            from tienda
            where direccion = vtienda;

            dbms_output.put_line('Tienda: ' || vtienda || chr(10));

            for v1 in c1(vid) loop
                  dbms_output.put_line('Nombre: ' || v1.nombre || '. ISBN: ' || v1.isbn || '. Precio: ' || v1.precio || '€.');
                  dbms_output.put_line('Tienda: ' || v1.tienda || '. Categoría: ' || v1.cat || '. Editorial: ' || v1.edi || '. Fecha: ' || v1.fecha_pub || chr(10));
                  contador := contador + 1;
            end loop;

            dbms_output.put_line('Libros totales en la tienda: ' || contador);
      end;
end pk_libro;

-- Prueba alta
declare
begin
  pk_libro.alta('Brandon Sanderson', 'Arcanum ilimitado', '9788466658922', 1, 16.3, 'Fantasía', 'Nova Editorial');
end;

-- Prueba baja
declare
begin
  pk_libro.baja(1);
end;

-- Prueba cambio cat
declare
begin
  pk_libro.modi_cat('Cómic', 'El pozo de la ascensión');
end;

-- Prueba cambio edi
declare
begin
  pk_libro.modi_edi('Alianza Editorial', 'El pozo de la ascensión');
end;

-- Prueba dia_sin_iva
declare
begin
  pk_libro.dia_sin_iva('Calle El Greco 50');
end;

-- Prueba consulta por autor
declare
begin
  pk_libro.consulta_autor('Brandon Sanderson');
end;

-- Prueba consulta por tienda
declare
begin
  pk_libro.consulta_tienda('Calle El Greco 50');
end;


-- Creación de los triggers

/*
Con este trigger nos aseguramos de que cada editorial tenga al menos 1 libro.
*/
create or replace trigger t1
after insert or update or delete on libro
declare
      cursor c1 is select id
                   from editorial;
      cuenta number;
begin
      for v1 in c1 loop
            select count(*) into cuenta
            from libro l
            where l.pedi.id = v1.id;

            if(cuenta <= 0) then
                  raise_application_error(-20003, 'No puede haber una editorial sin libros.');
            end if;
      end loop;

end;

-- Prueba trigger t1

declare
      vedi ref t_editorial;
      vedi_dos ref t_editorial;
begin
      select ref(e) into vedi
      from editorial e
      where id = 1;

      select ref(e) into vedi_dos
      from editorial e
      where id = 4;

      update libro l set l.pedi = vedi_dos where l.pedi = vedi;
end;


/*
Triggers con paquete, registro y tabla indexada para actualizar los libros que tengan una tienda
que se va a eliminar
*/

create or replace package pk1 as
      type t_tienda_rec is record{
            id INTEGER
      }

      type tipo1 is table of t_tienda_rec index by BINARY_INTEGER;
      contador number;
end;

create or replace trigger t2
before delete on tienda
begin
      pk1.tipo1.delete;
      pk1.contador := 0;
end;

create or replace trigger t3
before delete on tienda
for each row
begin
      pk1.contador := pk1.contador + 1;
      pk1.tipo1(pk1.contador).id := :old.id;
end;

create or replace trigger t4
after delete on tienda
declare
      i number;
      cursor c1(tie number) is select id
                               from libro l
                               where l.ptienda.id = tie;
begin
      i := pk1.tipo1.first;

      while i is not null loop

            for v1 in c1(pk1.tipo1(i).id) loop
                  update libro set ptienda = null where id = v1.id;
            end loop;

      end loop;
end;

/*
Trigger que a través de una vista inserta un libro
*/

create view v1 as select l.id as idlib, l.nombre as nom, autor, isbn, e.nombre as edi, c.nombre as cat, precio, fecha_pub
                  from libro l, editorial e, categoria c
                  where l.pcat.id = c.id
                        and l.pedi.id = e.id;

create or replace trigger t5
instead of insert on v1
declare
      videdi editorial.id%type;
      vidcat categoria.id%type;
      vid libro.id%type;
      bandera number := 0;
begin

      select id into videedi
      from editorial
      where nombre = :new.edi;

      bandera := 1;

      select id into vidcat
      from categoria
      where nombre = :new.cat;

      bandera := 2

      select * into vid
      from (select id
            from libro
            order by id desc)
      where rownum = 1;

      vid := vid + 1;

      insert into libro (id, nombre, autor, fecha_pub, isbn, pedi, pcat, ptienda, precio)
      select vid, :new.nom, :new.autor, sysdate, :new.isbn, ref(e), ref(c), null, :new.precio
      from editorial e, categoria c
      where e.id = videdi
            and c.id = vidcat;

      exception
            when no_data_found then
                  if bandera = 0 then
                        raise_application_error(-20001, 'No se ha encontrado la editorial.');
                  elif bandera = 1 then
                        raise_application_error(-20001, 'No se ha encontrado la categoría.');
                  elif bandera = 2 then
                        raise_application_error(-20001, 'No se ha encontrado un id de libro válido.');
                  else
                        raise_application_error(-20001, 'Error en el select into.');
                  end if;
            when others then
                  raise_application_error(sqlcode, sqlerrm);
end;

/*
Trigger para modificar la categoría y editorial de un libro a través de una vista pasandole la nueva categoría, la nueva editorial
el nombre del autor y la fecha de publicación
*/

create or replace trigger t6
instead of update on v1
declare
      vcat ref t_categoria;
begin
      select ref(c) into vcat
      from categoria c
      where nombre = :new.cat;

      select ref(e) into vedi
      from editorial e
      where nombre = :new.edi;

      update libro set pcat = vcat, pedi = vedi where autor = :old.autor and fecha_pub = :old.fecha_pub;
end;