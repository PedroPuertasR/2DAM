/*Ejercicio 1*/

create or replace procedure mostrarDatos(num_empl number)
as
    apell emple.apellido%type;
    dinero emple.salario%type;
    num_dept emple.dept_no%type;
begin
    select apellido, salario, dept_no into apell, dinero, num_dept
    from emple
    where emp_no = num_empl;

    dbms_output.put_line('Nº ' || num_empl || '. Apellido: ' || apell || '. Salario: ' || dinero || '€. Nº departamento: ' || num_dept);

    exception
        when no_data_found then
            dbms_output.put_line('No se han encontrado datos para ese número de empleado.');
end;

/*Ejercicio 2*/

create or replace procedure borrarEmpl(num number)
as
    v_emple emple.emp_no%type;
begin
    select emp_no into v_emple
    from emple 
    where emp_no = num;

    delete from emple where emp_no = num;

    exception
        when no_data_found then
            dbms_output.put_line('No se ha encontrado ningún empleado con ese código.');
end;


create or replace procedure modLocalidad(lugar varchar2, num number)
as
    v_dept emple.dept_no%type;
begin
    select dept_no into v_dept
    from emple
    where dept_no = num;

    update depart set loc = lugar where dept_no = num;

    exception
        when no_data_found then
            dbms_output.put_line('No se ha encontrado ningún departamento con ese código.');
end;

/*Ejercicio 3*/

create or replace procedure borrarEmpl(num number)
as
    numEmpl number(6);
begin
    delete from emple where emp_no = num;
    numEmpl := sql%rowcount;

    dbms_output.put_line('Se han modificado '|| numEmpl || ' empleados.');

    exception
        when no_data_found then
            dbms_output.put_line('No se ha encontrado ningún empleado con ese código.');
end;


create or replace procedure modLocalidad(lugar varchar2, num number)
as
    numLocal number(6);
begin
    update depart set loc = lugar where dept_no = num;
    numLocal := sql%rowcount;

    dbms_output.put_line('Se han modificado ' || numLocal || ' departamentos.');

    exception
        when no_data_found then
            dbms_output.put_line('No se ha encontrado ningún departamento con ese código.');
end;

/*Ejercicio 4*/

declare 
    num_empl number := 7788;
    num_dept number := 50;
    dept_e number;
    empl_e number;
    v_dept_ant number;
begin
    begin
        select dept_no into dept_e
        from depart
        where dept_no = num_dept;

        exception
            when no_data_found then
                dbms_output.put_line('No se ha encontrado el departamento.');
    end;

    begin

        select emp_no into empl_e
        from emple
        where emp_no = num_empl;

        exception
            when no_data_found then
                dbms_output.put_line('No se ha encontrado el empleado.');
    end;

    begin
    
        select dept_no into v_dept_ant
        from emple
        where emp_no = num_empl;

        update emple set dept_no = num_dept where emp_no = num_empl;

        if num_empl = empl_e and num_dept = dept_e then
            dbms_output.put_line('Anterior dept: ' || v_dept_ant || '. Nuevo dept: ' || num_dept);
        end if;

        exception
            when no_data_found then
                dbms_output.put_line('No se ha podido cambiar el departamento.');
    end;
end;

/*Ejercicio 5*/

create or replace procedure cambiarDeptProc(num_empl number, num_dept number)
as
    bandera number;
    dept_e number;
    empl_e number;
    v_dept_ant number;
begin
    select dept_no into dept_e
    from depart
    where dept_no = num_dept;

    select emp_no into empl_e
    from emple
    where emp_no = num_empl;

    select dept_no into v_dept_ant
    from emple
    where emp_no = num_empl;

    if dept_e != num_dept then
        bandera := 0;
    elsif empl_e != num_empl then 
        bandera := 1;
    elsif empl_e != num_empl and dept_e != num_dept then
        bandera := 2;
    else
        bandera := 3;
    end if;

    if bandera = 3 then
        update emple set dept_no = num_dept where emp_no = num_empl;
    end if;

    exception
        when no_data_found then
            case bandera
                when 0 then
                    dbms_output.put_line('No se ha encontrado el nuevo departamento.');
                when 1 then
                    dbms_output.put_line('No se ha encontrado el empleado.');
                when 2 then
                    dbms_output.put_line('No se ha encontrado ni el empleado ni el departamento.');
                else
                    dbms_output.put_line('No se ha podido cambiar el departamento.');
            end case;
end;