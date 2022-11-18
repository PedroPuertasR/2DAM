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
    vdept number;
    vdir number;
    vempl number;
    salario_nulo exception;
    no_existe_departamento exception;
    no_existe_director exception;
    numero_empleado_duplicado exception;
begin

    if sal <= 0 then
        raise_application_error(-20001, 'No puede insertarse un salario nulo.');
    end if;

    select dept_no into vdept
    from depart
    where dept_no = dept;

    if vdept is null then
        raise no_existe_departamento;
    end if;

    select emp_no into vdir
    from emple
    where emp_no = dire
          and oficio = 'DIRECTOR';

    if vdir is null then
        raise no_existe_director;
    end if;

    select emp_no into vempl
    from emple
    where emp_no = num_empl;

    if vempl = num_empl then
        raise numero_empleado_duplicado;
    elsif vempl is null then
        dbms_output.put_line('emp');
        insert into emple values (num_empl, ape, ofi, dire, fecha_cont, sal, comi, dept);
    end if;

    dbms_output.put_line('Se ha insertado el nuevo empleado.');

    exception
        when no_existe_departamento then
            dbms_output.put_line('No existe el número de departamento.');
        when no_existe_director then
            dbms_output.put_line('No existe ningún director con ese número.');
        when numero_empleado_duplicado then
            dbms_output.put_line('El número de empleado no puede repetirse.');
        when too_many_rows then
            dbms_output.put_line('Se ha encontrado más de una fila en alguna consulta.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;

exec nuevo_emple(1234, 'Puertas', 'ANALISTA', 7782, '06/01/2022', 25000, null, 10);

/*Actividad propuesta 7*/

/*Ejercicio complementario 7*/

create or replace procedure subir_sueldo_todos
as
    cursor c1 is select distinct oficio 
                 from emple;
    cursor c2(ofi varchar2) is select avg(salario) as media
                               from emple
                               where oficio = ofi;
    cursor c3(ofi varchar2) is select emp_no
                               from emple
                               where oficio = ofi;
    subida number := 0;
    vsal number;
    tot_filas number := 0;
begin
    commit;

    for v1 in c1 loop

        for v2 in c2(v1.oficio) loop

            for v3 in c3(v1.oficio) loop

                select salario into vsal
                from emple
                where emp_no = v3.emp_no;

                if vsal < v2.media then
                    subida := (v2.media - vsal) * 0.5;

                    update emple set salario = salario + subida where emp_no = v3.emp_no;

                    tot_filas := tot_filas + 1;

                    subida := 0;
                end if;
            end loop;
        end loop;
    end loop;

    dbms_output.put_line('Total de filas afectadas: ' || tot_filas);

    commit;

    exception
        when too_many_rows then
            rollback;
            dbms_output.put_line('Demasiadas columnas en el salario.');
        when no_data_found then
            rollback;
            dbms_output.put_line('No se ha encontrado el salario.');
        when others then
            rollback;
            dbms_output.put_line(sqlcode || sqlerrm);
end;

/*Ejercicio complementario 8*/

create or replace procedure liquidacion_emple
as
    cursor c1 is select *
              from emple
              order by apellido;
    total number := 0;
    trienio number := 0;
    anios number := 0;
    resp number := 0;
    sum_resp number;
    comi number;
    contador number := 0;
begin

    for v1 in c1 loop

        dbms_output.put_line('***********************************');
        dbms_output.put_line('Liquidación del empleado: ' || v1.apellido);
        dbms_output.put_line('Departamento: ' || v1.dept_no);
        dbms_output.put_line('Oficio: ' || v1.oficio);
        dbms_output.put_line('Salario: ' || v1.salario || '€');

        select floor(months_between(sysdate, v1.fecha_alt) / 12) / 3 into anios
        from dual;

        while contador < anios loop
            trienio := trienio + 50;
        end loop;

        contador := 0;

        dbms_output.put_line('Trienios: ' || trienio || '€');

        select count(*) into resp
        from emple
        where dir = v1.emp_no;

        while contador < resp loop
            sum_resp := sum_resp + 100;
        end loop;

        contador := 0;

        dbms_output.put_line('Comp. responsabilidad: ' || sum_resp);

        if v1.comision is null then
            comi := 0;
        else
            comi := v1.comision;
        end if;

        dbms_output.put_line('Comisión: ' || comi || '€');

        total := v1.salario + trienio + comi + sum_resp;

        dbms_output.put_line('***********************************');
        dbms_output.put_line(total);
        dbms_output.put_line('***********************************');

        trienio := 0;
        comi := 0;
        sum_resp := 0;

    end loop;

    exception
        when too_many_rows then
            dbms_output.put_line('Demasiadas filas en alguna consulta.');
        when no_data_found then
            dbms_output.put_line('No se han encontrado datos en una consulta.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;

/*Ejercicio complementario 9*/

create table t_liquidacion(
    emp_no number primary key,
    apellido varchar2(10),
    departamento number,
    oficio varchar2(10),
    salario number, 
    trienios number,
    comp_responsabilidad number,
    comision number,
    total number
);

create or replace procedure liquidacion_emple_tabla
as
    cursor c1 is select *
              from emple
              order by apellido;
    total number := 0;
    trienio number := 0;
    anios number := 0;
    resp number := 0;
    sum_resp number;
    comi number;
    contador number := 0;
    filar number := 0;
begin

    commit;

    for v1 in c1 loop

        select floor(months_between(sysdate, v1.fecha_alt) / 12) / 3 into anios
        from dual;

        while contador < anios loop
            trienio := trienio + 50;
        end loop;

        contador := 0;

        select count(*) into resp
        from emple
        where dir = v1.emp_no;

        while contador < resp loop
            sum_resp := sum_resp + 100;
        end loop;

        contador := 0;

        if v1.comision is null then
            comi := 0;
        else
            comi := v1.comision;
        end if;

        total := v1.salario + trienio + comi + sum_resp;

        trienio := 0;
        comi := 0;
        sum_resp := 0;

        insert into t_liquidacion values (v1.emp_no, v1.apellido, v1.dept_no, v1.oficio, v1.salario, trienio, sum_resp, comi, total);
        
        filas := filas + 1;

    end loop;

    dbms_output.put_line('Filas insertadas: ' || filas);

    exception
        when too_many_rows then
            dbms_output.put_line('Demasiadas filas en alguna consulta.');
            rollback;
        when no_data_found then
            dbms_output.put_line('No se han encontrado datos en una consulta.');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;
end;

/*Ejercicio complementario 10*/

