-- Ejercicio 1

create or replace trigger t1
after delete on depart
for each row
begin
    delete from emple where dept_no = :old.dept_no;
end;

-- Ejercicio 2

create or replace trigger t2
after update on depart
for each row
begin
    update emple set dept_no = :new.dept_no where dept_no = :old.dept_no;
end;

-- Ejercicio 3

create or replace trigger t3
before insert or update on emple
for each row
declare
    v1 integer;
begin
    select count(*) into v1
    from depart
    where dept_no = :new.dept_no;

    if v1 = 0 then
        raise_application_error(-20000, 'El departamento no existe.');
    end if;
end;

-- Ejercicio 4

create or replace trigger t4
before update on emple
for each row
begin
    declare
        vsal number;
    begin
        select salario * 1.2 into vsal
        from emple
        where emp_no = :new.emp_no;

        if :new.salario > vsal then
            raise_application_error(-20000, 'No se puede aumentar el salario en más de un 20%.');
        end if;
    end;
end;

-- Ejercicio 5

create or replace trigger t5
before update on emple
for each row
declare
    vsal number;
begin
    if updating ('apellido') or updating ('emp_no') then
        raise_application_error(-20000, 'no se puede modificar el apellido o número de empleado.');
    end if;

    select salario * 1.2 into vsal 
    from emple
    where emp_no = :new.emp_no;

    if :new.salario > vsal then
        raise_application_error(-20000, 'no se puede aumentar el salario en más de un 20%.');
    end if;
end;

-- Ejercicio 6

create or replace trigger t6
before insert on emple
for each row
begin
    new.comision := :new.salario * 0.01;
end;

-- Ejercicio 7

create or replace trigger t7
after insert or delete on personal
for each row
begin
    if inserting then
        if :new.funcion = 'profesor' then
            insert into profesores values (:new.cod_centro, :new.dni, :new.apellidos, :new.funcion);
        end if;

    elsif deleting then
        if :old.funcion = 'profesor' then
            delete from profesores where cod_centro = :old.cod_centro and dni = :old.dni;
        end if;
    end if;
end;

-- Ejercicio 8

create table libros (
    isbn       varchar2(13) primary key,
    genero     varchar2(20) not null,
    titulo     varchar2(50) not null,
    autor      varchar2(50) not null
);

create table estadisticas (
    genero     varchar2(20) primary key,
    total_libros number(10) not null
);

create or replace trigger t8
after insert or delete on libros
for each row
declare
    vgenero varchar2(20) := 'null';
    cursor c1 is select genero from estadisticas;
begin

    for v1 in c1 loop
        if v1.genero = :new.genero then
            vgenero := v1.genero;
        end if;
    end loop;

    if inserting then

        if vgenero <> 'null' then
            update estadisticas set total_libros = total_libros + 1 where genero = :new.genero;
        else
            insert into estadisticas values (:new.genero, 1);
        end if;

    else

        update estadisticas set total_libros = total_libros - 1 where genero = :old.genero;

    end if;
end;