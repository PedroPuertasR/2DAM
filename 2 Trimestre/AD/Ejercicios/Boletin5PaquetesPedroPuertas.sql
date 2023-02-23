-- Ejercicio 1

create or replace package pk1 as
    type t_emple is table of emple.emp_no%type index by BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1
before insert or update on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t2
after insert or update on emple
for each row
begin
    pk1.tipo1(:new.emp_no) := :new.dept_no;
end;

create or replace trigger t3
after insert or update on emple
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

create or replace package pk1 as
    type t_emple is table of emple.dept_no%type index by BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1
before insert or update on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t2
after insert or update on emple
for each row
begin
    pk1.tipo1(:new.emp_no) := :new.dept_no;
end;

create or replace trigger t3
after insert or update on emple
declare
    i number;
    limite number;
begin
    i := pk1.tipo1.first;

    while i is not null loop

        select sum(salario) into limite
        from emple
        where dept_no = pk1.tipo1(i);

        if limite > 150000 then
            raise_application_error(-20002, 'El total de salario del departamento no puede ser mayor que 150000.');
        end if;

        i := pk1.tipo1.next(i);
    end loop;
end;

update emple set salario = 160000 where emp_no = 7902;

-- Ejercicio 3

create or replace package pk1 as
    type t_emple is table of emple.emp_no%type index by BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1
before insert or update on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t2
after insert or update on emple
for each row
begin
    pk1.tipo1(:new.emp_no) := :new.dir;
end;

create or replace trigger t3
after insert or update on emple
declare
    vtot number;
    i number;
begin
    i := pk1.tipo1.first;

    while i is not null loop
        select count(*) into vtot
        from emple
        where dir = pk1.tipo1(i);

        if vtot > 5 then
            raise_application_error(-20003, 'Un jefe no puede tener más de 5 empleados a su cargo');
        end if;

        i := pk1.tipo1.next(i);
    end loop;
end;

update emple set dir = 7698 where emp_no = 7902;

-- Ejercicio 4

create or replace package pk1 as
    type t_emple is table of emple.emp_no%type index by BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1 
before insert or update on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t2
after insert or update on emple
for each row
begin
    pk1.tipo1(:new.emp_no) := :new.dir;
end;

create or replace trigger t3
after insert or update on emple
declare
    i number;
    vsal number;
    vdirsal number;
begin
    i := pk1.tipo1.first;

    while i is not null loop

        select salario into vsal
        from emple
        where emp_no = i;

        select salario into vdirsal
        from emple
        where emp_no = pk1.tipo1(i);

        if vsal > vdirsal then
            raise_application_error(-20004, 'El empleado no puede tener un salario mayor que el jefe.');
        end if;

        i := pk1.tipo1.next(i);
    end loop;
    
end;

update emple set salario = 400000 where emp_no = 7902;

-- Ejercicio 5

create or replace package pk1 as
    type t_emple is table of emple.emp_no%type index by BINARY_INTEGER;
    tipo1 t_emple;
end;

create or replace trigger t1
before insert or update on emple
begin
    pk1.tipo1.delete;
end;

create or replace trigger t2
after insert or update on emple
for each row
begin
    pk1.tipo1(:new.emp_no) := :new.dir;
end;

create or replace trigger t3
after insert or update on emple
declare
    vdept number;
    vdeptdir number;
    i number;
begin

    i := pk1.tipo1.first;

    while i is not null loop
        select dept_no into vdept
        from emple
        where emp_no = i;

        select dept_no into vdeptdir
        from emple
        where emp_no = pk1.tipo1(i);

        if vdept <> vdeptdir then
            raise_application_error(-20005, 'El empleado y el jefe no pueden tener un departamento diferente.');
        end if;

        i := pk1.tipo1.next(i);
    end loop;

end;

update emple set dept_no = 30 where emp_no = 7902;
