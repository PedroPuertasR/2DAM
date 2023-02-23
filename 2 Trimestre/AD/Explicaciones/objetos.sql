create or replace type t_depart as object(
    dept_no number(4),
    dnombre varchar2(20)
);

create table depart(
    c t_depart
);

insert into depart values (t_depart(1, 'CONTABILIDAD'));
insert into depart values (t_depart(2, 'VENTAS'));

select d.c.dnombre from depart d;

-- Así no se suele trabajar. Mejor como lo siguiente:

create or replace type t_depart as object(
    dept_no number(4),
    dnombre varchar2(20)
);

create table depart of t_depart;

insert into depart values (1, 'CONTABILIDAD');
insert into depart values (2, 'VENTAS');

-- A partir de aquí podriamos realizar consultas como si fuera una tabla normal

select dnombre
from depart;

--------------------------------------

create or replace type t_emple as object(
    emp_no number(4),
    apellido varchar2(20),
    pdep ref t_depart
);

-- pdep es un puntero que apunta a t_depart

create table emple of t_emple;

-- Así sacamos la referencia para meterla en la tabla emple

select ref(d)
from depart d
where dept_no = 1;

insert into emple select 10, 'PUERTAS', ref(d)
                  from depart d
                  where dept_no = 1;

-- Para insertar la referencia tendremos que hacer un select en el insert into

select * 
from emple;

-- Con la siguiente consulta encontramos a quien apunta nuestro puntero

select deref(pdep) from emple;

-- De esta forma comprobamos el valor de la columna dnombre de nuestro objeto

select e.pdep.dnombre from emple e;