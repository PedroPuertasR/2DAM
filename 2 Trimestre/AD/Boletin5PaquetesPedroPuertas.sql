-- Ejercicio 1

create or replace package pk1 as
    type t_emple is table of emple.dept_no%type index by BINARY_INTEGER;
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
    pk1.tipo1(:new.dept_no) := :new.dept_no;
end;

create or replace trigger t3
after insert or update or delete on emple
declare
    cantidad number;
    i number;
begin
    i := pk1.tipo1.first;

    while i is not null loop

        select count(*) into cantidad
        from emple
        where dept_no = pk1.tipo1(i);

        dbms_output.put_line('Ha entrado');

        if cantidad > 7 then
            raise_application_error(-20001, 'No puede haber 7 o más empleado en un departamento.');
        end if;

        i := pk1.tipo1.next(i);
    end loop;
end;

update emple set dept_no = 30 where emp_no = 7369;
update emple set dept_no = 30 where emp_no = 7566;

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

update emple set salario = 160000 where emp_no = 7902;

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

update emple set dir = 7698 where emp_no = 7902;

-- Ejercicio 4

create or replace trigger t1
after insert or update on emple
declare
    vsal number;
    cursor c1 is select emp_no, salario, dir
                from emple;
begin
    for v1 in c1 loop
        select salario into vsal 
        from emple
        where emp_no = v1.dir;

        if v1.salario > vsal then
            raise_application_error(-20004, 'El salario no puede ser mayor que el del jefe.');
        end if;
    end loop;
end;

update emple set salario = 400000 where emp_no = 7902;

-- Ejercicio 5

create or replace trigger t1
after insert or update on emple
declare
    vdept number;
    vjefe number;
    cursor c1 is select *
                 from emple;
begin
    for v1 in c1 loop
        select dept_no into vjefe
        from emple
        where emp_no = v1.dir;
    
        select dept_no into vdept
        from emple
        where emp_no = v1.emp_no;

        if vdept <> vjefe then
            raise_application_error(-20004, 'El empleado no puede tener un departamento diferente al jefe.');
        end if;

    end loop;

    dbms_output.put_line('Tabla actualizada.');
end;

update emple set dept_no = 30 where emp_no = 7902;
