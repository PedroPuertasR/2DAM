/*Ejercicio 1*/

declare
    num1 number(8,2) := 0;
    num2 number(8,2) NOT NULL := 0;
    num3 number(8,2) NOT NULL := 0;
    cantidad integer(3);
    precio number(6);
    descuento number(6);
    num4 num1%type;
    dto constant integer := 0;
begin
  dbms_output.put_line('Hola');
end;

/*Ejercicio 2*/

declare
    i binary_integer;
    palabra varchar2(10);
begin
    i := length('hola');
    loop
        palabra := palabra || SUBSTR('hola', i, 1);
        i := i - 1;
        exit when i <= 0;
    end loop;
    dbms_output.put_line(palabra);
end;

/*Ejercicio 3*/

create or replace procedure cambiar_dept(emple_num number, dept_num number)
as
    v_dept_ant emple.dept_no%type;
begin
    select dept_no into v_dept_ant
    from emple
    where emp_no = emple_num;

    update emple set dept_no = dept_num where emp_no = emple_num;
    dbms_output.put_line('Anterior dept: ' || v_dept_ant || '. Nuevo dept: ' || dept_num);
end;

/*Ejercicio 4*/

-- crear_depart(50, 'COMPRAS', 'VALENCIA');

/*Ejercicio práctico 1*/

declare
    v_empleado_no number (4, 0);
    v_can_empleados number(2);
    v_aumento number (7) default 0;
    v_oficio varchar2 (10);
begin

    v_empleado_no := &vt_empno;

    select oficio into v_oficio
    from emple
    where emp_no = v_empleado_no;

    if v_oficio like 'PRESIDENTE' then
        v_aumento := 30;
    end if;

    select count(*) into v_can_empleados
    from emple
    where dir = v_empleado_no;

    if v_can_empleados = 0 then
        v_aumento := v_aumento + 50;
    elsif v_can_empleados = 1 then
        v_aumento := v_aumento + 80;
    elsif v_can_empleados = 2 then
        v_aumento := v_aumento + 100;
    else
        v_aumento := v_aumento + 110;
    end if;

    update emple set salario = salario + v_aumento where emp_no = v_empleado_no;
    dbms_output.put_line('El aumento es de: ' || v_aumento || ' €.');
    
end;

/*Ejercicio práctico 2*/

declare
    v_apellidos varchar2(25);
    v_1apell varchar2(25);
    v_caracter char;
    v_posicion integer := 1;
begin
    v_apellidos := '&vs_apellidos';

    v_caracter := SUBSTR(v_apellidos, v_posicion, 1);
    while v_caracter between 'A' and 'Z' loop
        v_1apell := v_1apell || v_caracter;
        v_posicion := v_posicion + 1;
        v_caracter := SUBSTR(v_apellidos, v_posicion, 1);
    end loop;
    dbms_output.put_line('1er apellido: ' || v_1apell);
end;

/*Ejercicio práctico 3.1*/

declare
    palabra varchar2(10);
begin
    for i in reverse 1..LENGTH('hola') loop
        palabra := palabra || SUBSTR('hola', i, 1);
    end loop; 
    dbms_output.put_line(palabra);
end;

/*Ejercicio práctico 3.2*/

declare
    i binary_integer;
    palabra varchar2(10);
begin
    i := length('hola');
    while i >= 1 loop
        palabra := palabra || SUBSTR('hola', i, 1);
        i := i - 1;
    end loop;
    dbms_output.put_line(palabra);
end;

/*Ejercicio práctico 4*/

create or replace procedure cambiar_oficio(emple_num number, ofi varchar2)
as
    v_oficio_ant emple.oficio%type;
begin
    select oficio into v_oficio_ant
    from emple
    where emp_no = emple_num;

    update emple set oficio = ofi where emp_no = emple_num;
    dbms_output.put_line('Anterior oficio: ' || v_oficio_ant || '. Nuevo oficio: ' || ofi);
end;

/*Ejercicio práctico 5*/

create or replace procedure cambiar_divisas(cant_euros in number, cant_cambio in number, 
                                           cant_comision in out number, cant_final out number)
as
    pct_comision constant number(3, 2) := 0.2;
    comision_min constant number(6) DEFAULT 3;
begin
    if cant_comision IS NULL then
        cant_comision := greatest(cant_euros/100 * pct_comision, comision_min);
    end if;
    cant_final := (cant_euros - cant_comision) * cant_cambio;
end;

create or replace procedure mostrar_cambio_divisas(cant_euros number, cant_cambio number)
as
    v_comision number(9);
    v_divisas number(9);
begin
    cambiar_divisas(cant_euros, cant_cambio, v_comision, v_divisas);
    dbms_output.put_line('Euros: ' || to_char(cant_euros, '999,999,999.999'));
    dbms_output.put_line('Divisas x 1 euro: ' || to_char(cant_cambio, '999,999,999.999'));
    dbms_output.put_line('Euros de comisión: ' || to_char(v_comision, '999,999,999.999'));
    dbms_output.put_line('Euros de divisas: ' || to_char(v_divisas, '999,999,999.999'));
end;

/*Actividades complementarias*/

/*Actividad 1*/

create or replace procedure sumar(num1 number, num2 number)
as
    total number(6);
begin
    total := num1 + num2;
    dbms_output.put_line('Total de la suma: ' || total);
end;

/*Actividad 2*/

create or replace procedure alreves(palabra varchar2)
as
    i binary_integer;
    cadena varchar2 (10);
begin
    i := LENGTH(palabra);
    while i >= 1 loop
        cadena := cadena || SUBSTR(palabra, i, 1);
        i := i - 1;
    end loop;
    dbms_output.put_line('Al reves es: ' || cadena);
end;

/*Actividad 3*/

create or replace function sumarFunc(num1 number, num2 number)
    return number
as
    total number(6);
begin
    total := num1 + num2;
    return total;
end sumarFunc;

create or replace function alrevesFunc(palabra varchar2)
return varchar2
as
    i binary_integer;
    cadena varchar2(10)
begin
    i := LENGTH(palabra);
    while i >= 1 loop
        cadena := cadena || SUBSTR(palabra, i, 1);
        i := i - 1;
    end loop;
    return cadena;
end;

/*Actividad 4*/

create or replace function sacarAnio(fecha date)
return integer
as
    num integer;
begin
    num := extract(year from fecha);
    return num;
end;

/*Actividad 5*/

declare
    fecha date := '27/10/2013';
    num integer;
    actual integer;
    total integer;
begin
    select sacarAnio(fecha) into num
    from dual;
    actual := extract(year from sysdate);
    total := actual - num;
    dbms_output.put_line('La diferencia de años es de: ' || total);
end;

/*Actividad 6*/

create or replace function difFechas(fecha date, fecha2 date)
return integer
as
    total integer;
    num integer;
    num2 integer;
begin
    num := extract(year from fecha);
    num2 := extract(year from fecha2);
    total := num - num2;
    if total < 0 then
        total := total * -1;
    end if;
    return total;
end;

/*Actividad 7*/

create or replace function trienios(fecha date, fecha2 date)
return integer
as
    total integer;
    num integer;
begin
    select difFechas(fecha, fecha2) into num
    from dual;
    total := num / 3;
    return total;
end;

/*Actividad 8*/

create or replace procedure sumarNumeros(num number, num2 number, num3 number, num4 number, num5 number)
as
    total number;
begin
    total := num + num2 + num3 + num4 + num5;
    dbms_output.put_line('Suma total: ' || total);
end;

/*Actividad 9*/

create or replace function sustituirLetras(palabra varchar2)
return varchar2
as
    nueva varchar2(25);
    letra char;
begin
    for i in 1..LENGTH(palabra) loop
        letra := SUBSTR(palabra, i, 1);
        if letra between 'A' and 'Z' or letra between 'a' and 'z' then
            letra := ' ';
        end if;
        nueva := nueva || letra;
    end loop;
    return nueva;
end;

/*Actividad 10*/

create or replace procedure borrarEmpl(num number)
as
begin
    delete from emple where emp_no = num;
end;

/*Actividad 11*/

create or replace procedure modLocalidad(lugar varchar2, num number)
as
begin
    update depart set loc = lugar where dept_no = num;
end;

/*Actividad 12*/

SELECT * 
FROM all_objects
WHERE object_type IN ('FUNCTION','PROCEDURE');