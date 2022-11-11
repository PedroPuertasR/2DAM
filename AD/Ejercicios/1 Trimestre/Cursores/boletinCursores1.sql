/*Ejercicios prácticos 1 y 2. Ejercicios 1 y 2 propuestas. Ejercicios complementarios 1-3*/

/*Ejercicio 1 práctico*/

declare
    cursor c1 is select apellido from emple where dept_no = 20;
    v1 c1%rowtype;
begin
    open c1;

    fetch c1 into v1;

    loop
        dbms_output.put_line('Apellido: ' || v1.apellido);
        fetch c1 into v1;
        exit when c1%notfound;
    end loop;

    close c1;
end;

/*Ejercicio 2 práctico*/

create or replace procedure ver_emple(dep varchar2)
as
    vdept number(2);
    cursor c1 is select apellido from emple where dept_no = vdept;
    vapellido varchar2(10);
begin
    vdept := dep;
    open c1;

    fetch c1 into vapellido;

    while c1%found loop
        dbms_output.put_line(vapellido);
        fetch c1 into vapellido;
    end loop;
    close c1;
end;


/*Actividad 1 propuesta*/

declare
    cursor c1 is select apellido from emple where dept_no = 20;
    v1 c1%rowtype;
begin
    open c1;

    fetch c1 into v1;

    while c1%found loop
        dbms_output.put_line('Apellido: ' || v1.apellido);
        fetch c1 into v1;
    end loop;

    close c1;
end;

/*Actividad 2 propuesta*/

create or replace procedure ver_ape_num(ape varchar2)
as
    vape varchar2 (10);
    cursor c1 is select emp_no from emple where apellido like ape;
    vcod c1%rowtype;
begin
    vape := ape;
    open c1;

    fetch c1 into vcod;

    while c1%found loop
        dbms_output.put_line('Cod: ' || vcod.emp_no || '. Apellido: ' || vape);
        fetch c1 into vcod;
    end loop;
    close c1;
end;

/*Ejercicio 1 complementario*/

create or replace procedure ver_ape_fecha
as
    cursor c1 is select apellido, fecha_alt from emple order by apellido;
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

/*Ejercicio 2 complementario*/

create or replace procedure ver_dept_num
as
    cursor c1 is select d.dnombre as dnom, count(e.emp_no) as total 
                from depart d, emple e
                where d.dept_no = e.dept_no (+) 
                group by d.dnombre 
                order by d.dnombre;
    vdat c1%rowtype;
begin

    open c1;

    fetch c1 into vdat;

    while c1%found loop
        dbms_output.put_line('Departamento: ' || vdat.dnom || '. Empleados: ' || vdat.total);
        fetch c1 into vdat;
    end loop;

    close c1;
end;

/*Ejercicio 3 complementario*/

create or replace procedure ver_emp_sal
as
    cursor c1 is select * from (select apellido, salario from emple order by salario desc) where rownum <= 5;
    vdat c1%rowtype;
begin
    open c1;

    fetch c1 into vdat;

    while c1%found loop
        dbms_output.put_line('Apellido: ' || vdat.apellido || '. Salario: ' || vdat.salario || '€.');
        fetch c1 into vdat;
    end loop;

    close c1;
end;