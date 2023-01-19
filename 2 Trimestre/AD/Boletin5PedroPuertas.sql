-- Ejercicio 1

create or replace trigger t1
after insert or update on emple
declare
    vnum number;
    cursor c1 is select * 
                 from depart;
begin

    for v1 in c1 loop
        select count(*) into vnum
        from emple
        where dept_no = v1.dept_no;

        if vnum >= 7 then
            raise_application_error(-20001, 'No se pueden añadir más empleados a este departamento');
        end if;
    end loop;

    dbms_output.put_line('Empleado añadido.');
end;


-- Ejercicio 2

create or replace trigger t1
after insert or update on emple
declare
    vtot number;
    cursor c1 is select * from depart;
begin

    for v1 in c1 loop
    
        select sum(salario) into vtot
        from emple
        where dept_no = v1.dept_no;

        if vtot > 150000 then
            raise_application_error(-20002, 'El salario no puede ser mayor que 150.000€');
        end if;
    end loop;

    dbms_output.put_line('Añadido correctamente.');
end;

-- Ejercicio 3

create or replace trigger t1
after insert or update on emple
declare
    vtot number;
    cursor c1 is select dir from emple group by dir;
begin

    for v1 in c1 loop
        select count(*) into vtot
        from emple
        where dir = v1.dir;

        if vtot > 5 then
            raise_application_error(-20003, 'Un empleado no puede ser jefe de más de 5 empleados.');
        end if;
    end loop;

    dbms_output.put_line('Proceso terminado.');

end;

-- Ejercicio 4

create or replace trigger t1
after insert or update on emple
declare
    cursor c1 is select emp_no, salario
                from emple
                where emp_no in (select dir
                                from emple
                                group by dir);
begin
    for v1 in c1 loop
        if :new.dir = v1.emp_no then
            if :new.salario > v1.salario then
                raise_application_error(-20003, 'El salario no puede ser mayor que el del jefe.');
            end if;
        end if;
    end loop;
end;