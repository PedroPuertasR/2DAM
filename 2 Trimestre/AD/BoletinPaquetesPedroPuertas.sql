-- Caso práctico 3

declare
    cursor c_depar is select dnombre, count(emp_no) numemple
                      from depart, emple
                      where depart.dept_no = emple.dept_no
                      group by depart.dept_no, dnombre;

    type tr_depto is record (nombredep depart.dnombre%type,
                             numemple integer
                            );
                    
    type tv_depto is varray (6) of tr_depto;

    va_departamentos tv_depto := tv_depto();

    n integer := 0;

begin
        for vc in c_depar loop
            n := c_depar%rowcount;
            va_departamentos(n) := vc;
        end loop;

        for i in 1..n loop
            dbms_output.put_line(' * dnombre:' || va_departamentos(i).nombredep ||
            ' * noempleados: ' || va_departamentos(i).numemple );
        end loop;
end;

-- Caso práctico 4

declare
    cursor c_depar is select depart.dept_no, dnombre, count(emp_no) numemple
                      from depart, emple
                      where depart.dept_no = emple.dept_no
                      group by depart.dept_no, dnombre;
    type tr_depto is record (nombredep depart.dnombre%type,
                             numemple integer
                            );

    type ti_depto is table of tr_depto index by BINARY_INTEGER;
    va_departamentos ti_depto;
    n pls_integer := 0; 

begin
    for vc in c_depar loop
        va_departamentos(vc.dept_no).nombredep := vc.dnombre;
        va_departamentos(vc.dept_no).numemple := vc.numemple;
    end loop;

    n := va_departamentos.first;

    while va_departamentos.exists(n) loop
        dbms_output.put_line(' * dep no :' || n ||
        ' * dnombre:' || va_departamentos(n).nombredep ||
        ' * noempleados: ' || va_departamentos(n).numemple );

        n := va_departamentos.next(n);
    end loop;
end;

-- Actividad propuesta 3

declare
    cursor c_depar is select dnombre, count(emp_no) numemple
                      from depart, emple
                      where depart.dept_no = emple.dept_no
                      group by depart.dept_no, dnombre;

    type tr_depto is record (nombredep depart.dnombre%type,
                             numemple integer
                            );
                    
    type tv_depto is table of tr_depto;

    va_departamentos tv_depto := tv_depto();

    n integer := 0;

begin
        for vc in c_depar loop
            va_departamentos.extend;
            n := c_depar%rowcount;
            va_departamentos(n) := vc;
        end loop;

        for i in 1..n loop
            dbms_output.put_line(' * dnombre:' || va_departamentos(i).nombredep ||
            ' * noempleados: ' || va_departamentos(i).numemple );
        end loop;
end;

-- Actividad complementaria 4

create or replace package gest_depart as
    procedure insertar_nuevo_depart(nom depart.dnombre%type, localidad depart.loc%type);
    procedure borrar_depart(num1 depart.dept_no%type, num2 depart.dept_no%type);
    procedure modificar_loc_depart(num1 depart.dept_no%type, localidad depart.loc%type);
    procedure visualizar_datos_depart(num depart.dept_no%type);
    procedure visualizar_datos_depart(nom depart.dnombre%type);
end;

create or replace package body gest_depart is

    function buscar_depart_por_nombre(nom depart.dnombre%type) return number;

    --Procedimiento insertar_nuevo_depart

    procedure insertar_nuevo_depart(nom depart.dnombre%type, localidad depart.loc%type) is
        num number;
        cursor c1 is select dnombre, dept_no from depart order by dept_no;
    begin
        for v1 in c1 loop
            if v1.dnombre = nom then
                raise_application_error(-20001, 'El nombre del departamento no puede repetirse.');
            end if;
            num := v1.dept_no;
        end loop;

        num := num + 10;

        insert into depart (dept_no, dnombre, loc) values (num, nom, localidad);
    end insertar_nuevo_depart;

    --Procedimiento borrar_depart

    procedure borrar_depart(num1 depart.dept_no%type, num2 depart.dept_no%type) is
    begin
        update emple set dept_no = num2 where dept_no = num1;
        delete from depart where dept_no = num1;
    end borrar_depart;

    --Procedimiento modificar_loc_depart

    procedure modificar_loc_depart(num1 depart.dept_no%type, localidad depart.loc%type) is
    begin
        update depart set loc = localidad where dept_no = num1;
    end modificar_loc_depart;

    --Procedimiento visualizar_datos_depart 1

    procedure visualizar_datos_depart(num depart.dept_no%type) is
        vnom depart.dnombre%type;
        vloc depart.loc%type;
        num_emple number;
    begin
        select dnombre, loc into vnom, vloc
        from depart
        where dept_no = num;

        select count(*) into num_emple
        from emple
        where dept_no = num;

        dbms_output.put_line('Número: ' || num || '. Nombre: ' || vnom || '. Localidad: ' || vloc);
        dbms_output.put_line('Número de empleados: ' || num_emple);
    end visualizar_datos_depart;

    --Procedimiento visualizar_datos_depart 2

    procedure visualizar_datos_depart(nom depart.dnombre%type) is
        num_emple number;
        vdept depart.dept_no%type;
        vloc depart.loc%type;
    begin
        vdept := buscar_depart_por_nombre(nom);

        select loc into vloc
        from depart
        where dept_no = vdept;

        select count(*) into num_emple
        from emple
        where dept_no = vdept;

        dbms_output.put_line('Número: ' || vdept || '. Nombre: ' || nom || '. Localidad: ' || vloc);
        dbms_output.put_line('Número de empleados: ' || num_emple);
    end visualizar_datos_depart;

    --Función buscar_depart_por_nombre

    function buscar_depart_por_nombre(nom depart.dnombre%type)
    return number
    is
    vdept depart.dept_no%type;
    begin
        select dept_no into vdept
        from depart
        where dnombre = nom;

        return vdept;
    end buscar_depart_por_nombre;

end gest_depart;



-- Usos de los procedimientos

declare
  nom depart.dnombre%type;
  localidad depart.loc%type;
begin
  nom := 'HOLA';
  localidad := 'SEVILLA';
  gest_depart.insertar_nuevo_depart(nom, localidad);
end;

declare
  num1 depart.dept_no%type;
  num2 depart.dept_no%type;
begin
  num1 := 10;
  num2 := 20;
  gest_depart.borrar_depart(num1, num2);
end;

declare
  num1 depart.dept_no%type;
  localidad depart.loc%type;
begin
  num1 := 10;
  localidad := 'SEVILLA';
  gest_depart.modificar_loc_depart(num1, localidad);
end;

declare
  num1 depart.dept_no%type;
begin
  num1 := 10;
  gest_depart.visualizar_datos_depart(num1);
end;

declare
  nom depart.dnombre%type;
begin
  nom := 'VENTAS';
  gest_depart.visualizar_datos_depart(nom);
end;