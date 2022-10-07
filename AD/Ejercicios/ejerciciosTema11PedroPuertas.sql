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

/*Ejercicio práctico 5*/

create or replace function cambiar_divisas(cant_euros in number, cant_cambio in number, 
                                           cant_comision in out number, cant_final out number)
as
    pct_comision constant number(3, 2) := 0.2;
    comision_min constant number(6) DEFAULT 3;
begin
    
end;