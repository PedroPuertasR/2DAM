/*Caso práctico 5*/

create or replace procedure subir_salario(num_empl number, subida number)
as
    salario_act number;
    salario_nulo exception;
begin
    select salario into salario_act
    from emple
    where emp_no = num_empl;

    if salario_act is null then
        raise salario_nulo;
    end if;

    update emple set salario = salario + subida where emp_no = num_empl;

    select salario into salario_act
    from emple
    where emp_no = num_empl;

    dbms_output.put_line('El salario ha sido subido.');
    dbms_output.put_line('Empleado: ' || num_empl || ', salario: ' || salario_act || '€.');

    exception
        when no_data_found then
            dbms_output.put_line(num_empl || ', no ha sido encontrado.');
        when salario_nulo then
            dbms_output.put_line(num_empl || ', su salario es nulo.');

end;

/*Caso práctico 6*/


create table temp2(
    col1 varchar2 (50) primary key,
    col2 varchar2 (50)
);

declare
    cod_err number(6);
    vnif varchar2(10);
    vnom varchar2(15);
    err_blancos exception;
    no_hay_espacio exception;
    pragma exception_init(no_hay_espacio, -1547);
begin
    select col1, col2 into vnif, vnom from temp2;

    if substr(vnom, 1, 1) <= ' ' then
        raise err_blancos;
    end if;

    update clientes set nombre = vnom where nif = vnif;

    exception
        when err_blancos then
            INSERT INTO temp2(col1) VALUES ('err blancos');
        when no_hay_espacio then
            INSERT INTO temp2(col1) VALUES ('err tablespace');
        when no_data_found then
            INSERT INTO temp2(col1) VALUES ('err no habia datos');
        when too_many_rows then
            INSERT INTO temp2(col1) VALUES ('err demasiados datos');
        when others then
            cod_err := SQLCODE;
            INSERT INTO temp2(col1) VALUES (cod_err);
end;

/*Caso práctico 7*/

create or replace procedure subir_sueldo(num_empl number, subida number)
as
    salario_act number;
begin
    select salario into salario_act
    from emple
    where emp_no = num_empl;

    if salario_act is null then
        raise_application_error(-20010, 'Salario nulo');
    else
        update emple set salario = salario + subida where emp_no = num_empl;
    end if;
end;

/*Actividad propuesta 6*/

create or replace procedure nuevo_emple(num_empl number, ape varchar2, ofi varchar2,
                                        dire number, fecha_cont date, sal number, comi number, dept number)
as
    cod_err number(6);
    vdept number;
    vdir varchar2(10);
    vempl number;
    salario_nulo exception;
    dept_err exception;
    dir_err exception;
    emp_err exception;
begin

    select dept_no into vdept
    from depart
    where dept_no = dept;

    if vdept is null then
        raise dept_err;
    end if;

    select oficio into vdir
    from emple
    where emp_no = dire;

    if vdir <> 'DIRECTOR' then
        raise dir_err;
    end if;

    select emp_no into vempl
    from emple
    where emp_no = num_empl;

    if vempl = num_empl then
        raise emp_err;
    else
        insert into emple values (num_empl, ape, ofi, dire, fecha_cont, sal, comi, dept);
    end if;

    dbms_output.put_line('Se ha insertado el nuevo empleado.');

    exception
        when dept_err then
            dbms_output.put_line('No existe el número de departamento.');
        when dir_err then
            dbms_output.put_line('No existe ningún director con ese número.');
        when emp_err then
            dbms_output.put_line('El número de empleado no puede repetirse.');
        when too_many_rows then
            dbms_output.put_line('Se ha encontrado más de una fila en alguna consulta.');
        when others then
            cod_err := SQLCODE;
            dbms_output.put_line('Error número: ' || cod_err);
end;

exec nuevo_emple(7369, 'Puertas', 'ANALISTA', 7902, '06/01/2022', 25000, null, 10);