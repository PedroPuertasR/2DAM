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
    cursor c1 is select cod_empleado from emple where apellido = vape;
    vcod number(5,2);
begin
    vape := ape;
    open c1;
    fetch c1 into vcod;

    while c1%found loop
        dbms_output.put_line('Cod: ' || vcod.cod_empleado || '. Apellido: ' || ape);
        fetch c1 into vcod;
    end loop;
    close c1;
end;