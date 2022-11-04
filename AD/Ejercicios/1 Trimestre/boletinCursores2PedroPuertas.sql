/*Casos Prácticos:3,4 Act.Propuestas:3,4,5 Act.Complementarias: 4,5 y 6*/

/*Ejercicio práctico 3*/

declare
    cursor c1 is select apellido, fecha_alt from emple order by fecha_alt;
    vdat c1%rowtype;
begin
    open c1;

    fetch c1 into vdat;

    while c1%found loop
        dbms_output.put_line('Apellido: ' || vdat.apellido || '. Fecha alta: ' || vdat.fecha_alt);
        fetch c1 into vdat;
    end loop;

    close c1;
end;

/*Ejercicio práctico 4*/

create or replace procedure listar_emple
as
    cursor c1 is select apellido, salario, dept_no
                 from emple
                 order by dept_no, apellido;
    vr_emp c1%rowtype;
    dep_ant emple.dept_no%type default 0;
    cont_emple number(4) default 0;
    sum_sal number(9,2) default 0;
    tot_emple number(4) default 0;
    tot_sal number(10,2) default 0;
begin

    open c1;

    loop
        fetch c1 into vr_emp;
        
        if c1%rowcount = 1 then
            dep_ant := vr_emp.dept_no;
        end if;

        if dep_ant <> vr_emp.dept_no or c1%notfound then
            dbms_output.put_line('DEPT: ' || dep_ant || '. NUM EMPLEADOS: ' || cont_emple || '. SUM SALARIO: ' || sum_sal || '€.');
            dep_ant := vr_emp.dept_no;
            tot_emple := tot_emple + cont_emple;
            tot_sal := tot_sal + sum_sal;
            cont_emple := 0;
            sum_sal := 0;
        end if;

        exit when c1%notfound;

        dbms_output.put_line(RPAD(vr_emp.apellido, 10) || ' * ' || LPAD(TO_CHAR(vr_emp.salario, '999,999'), 12));
        cont_emple := cont_emple + 1;
        sum_sal := sum_sal + vr_emp.salario;

    end loop;

    close c1;

    dbms_output.put_line('NUMERO TOTAL DE EMPLEADOS: ' || tot_emple || '. TOTAL SALARIOS: ' || tot_sal);

end;

/*Ejercicio propuesto 3*/

create or replace procedure ver_ape_num(ape varchar2)
as
    cursor c1 is select emp_no, apellido from emple where apellido like '%' || ape || '%';
begin
    
    for v1 in c1 loop
        dbms_output.put_line('Cod: ' || v1.emp_no || '. Apellido: ' || v1.apellido);
    end loop;

end;

/*Ejercicio propuesto 4*/

create or replace procedure listar_emple_for
as
    cursor c1 is select apellido, salario, dept_no
                 from emple
                 order by dept_no, apellido;
    dept_ant emple.dept_no%type;
    num_empl number(4) := 0;
    sum_sal number(9,2) := 0;
    tot_sal number(9,2) := 0;
    tot_emple number(4) := 0;
begin

    for v1 in c1 loop
        if c1%rowcount = 1 then
            dept_ant := v1.dept_no;
        end if;

        if dept_ant <> v1.dept_no then
            dbms_output.put_line('Dept: ' || dept_ant || '. Num empleados: ' || num_empl || '. Sum salarios: ' || sum_sal || '€.');
            tot_sal := tot_sal + sum_sal;
            tot_emple := tot_emple + num_empl;
            sum_sal := 0;
            num_empl := 0;
            dept_ant := v1.dept_no;
        end if;

        dbms_output.put_line('Apellido: ' || v1.apellido || '. Salario: ' || v1.salario || '€.');
        sum_sal := sum_sal + v1.salario;
        num_empl := num_empl + 1;

    end loop;

    dbms_output.put_line('Dept: ' || dept_ant || '. Num empleados: ' || num_empl || '. Sum salarios: ' || sum_sal || '€.');
    tot_sal := tot_sal + sum_sal;
    tot_emple := tot_emple + num_empl;

    dbms_output.put_line('NUMERO TOTAL DE EMPLEADOS: ' || tot_emple || '. TOTAL SALARIOS: ' || tot_sal || '€.');

end;

/*Ejercicio propuesto 5*/

create or replace procedure mas_salario(dept_empl number, subida number)
as
    cursor c1 is select salario, rowid from emple where dept_no = dept_empl;
    tot_filas number(4) := 0;
begin

    for v1 in c1 loop
        update emple set salario = v1.salario + subida where rowid = v1.rowid;
        tot_filas := tot_filas + 1;
    end loop;

    dbms_output.put_line('Filas afectadas: ' || tot_filas);

end;

/*Ejercicio complementario 4*/

create or replace procedure menos_salario
as

    cursor c1 is select apellido, oficio, salario
                 from emple
                 order by oficio, salario;

    vdat c1%rowtype;
    voficio emple.oficio%type;
    cont number (4);

begin
    voficio := '*';

    open c1;

    fetch c1 into vdat;

    while c1%found loop
        if voficio <> vdat.oficio then
            voficio := vdat.oficio;
            cont := 0;
        end if;

        if cont < 2 then
            dbms_output.put_line('Oficio: ' || vdat.oficio || '. Apellido: ' || vdat.apellido || '. Salario: '|| vdat.salario);
            cont := cont + 1;  
        end if;

        fetch c1 into vdat;
  
    end loop;

end;

/*Ejercicio complementario 5*/

create or replace procedure nuevo_depart(vnombre varchar, vloc varchar)
as
    cursor c1 is select *
                 from (select dept_no
                       from depart
                       order by dept_no desc) result
                 where rownum = 1;
    vdat c1%rowtype;
begin
    open c1;

        fetch c1 into vdat;

        insert into depart values ((vdat.dept_no + 10), vnombre, vloc);

    close c1;

    exception
        when no_data_found then
            dbms_output.put_line('No se han encontrado departamentos.');
        when too_many_rows then
            dbms_output.put_line('Se ha devuelto más de un departamento.');
        when others then
            dbms_output.put_line('Ha ocurrido un error inesperado.');
end;

/*Ejercicio complementario 6*/

create or replace procedure sumar_salario(num_dept number, importe number, porc number)
as
    cursor c1 is select emp_no, salario
                 from emple
                 where dept_no = num_dept;
    vdat c1%rowtype;
    nuevo number(9,2) := 0;
    suma number(9,2) := 0;
begin

    for v1 in c1 loop
        suma := vdat.salario * porc / 100;

        if importe > suma then
            nuevo := vdat.salario + importe;
            update emple set salario = nuevo where emp_no = vdat.emp_no;
        end if;

        if suma > importe then
            nuevo := vdat.salario + suma;
            update emple set salario = nuevo where emp_no = vdat.emp_no;
        end if;
    end loop;
end;