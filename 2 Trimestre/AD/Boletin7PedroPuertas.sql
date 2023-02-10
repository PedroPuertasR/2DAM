-- Ejercicio 1

create or replace package gest_emple as

    procedure insertar_nuevo_emple(num emple.emp_no%type, vdept depart.dept_no%type);
    procedure borrar_emple(num emple.emp_no%type);
    procedure modificar_oficio_emple(num emple.emp_no%type, ofi emple.oficio%type);
    procedure modificar_dept_emple(num emple.emp_no%type, vdept emple.dept_no%type);
    procedure modificar_dir_emple(num emple.emp_no%type, dire emple.emp_no%type);
    procedure modificar_salario_emple(num emple.emp_no%type, sal emple.salario%type);
    procedure modificar_comision_emple(num emple.emp_no%type, comi emple.comision%type);
    procedure visualizar_datos_emple(num emple.emp_no%type);
    procedure visualizar_datos_emple(ape emple.apellido%type);
    function buscar_emple_por_dnombre (ape emple.apellido%type) return number;
    procedure subida_salario_pct(sal number);
    procedure subida_salario_imp(sal emple.salario%type);

end gest_emple;

create or replace package body gest_emple as

    procedure insertar_nuevo_emple(num emple.emp_no%type, vdept depart.dept_no%type) is
    begin
        insert into emple (emp_no, dept_no) values (num, vdept);
    end insertar_nuevo_emple;

    procedure borrar_emple(num emple.emp_no%type) is
        dire emple.dir%type;
    begin
        select dir into dire
        from emple
        where emp_no = num;

        update emple set dir = dire where dir = num;
        delete from emple where emp_no = num;
    end borrar_emple;

    procedure modificar_oficio_emple(num emple.emp_no%type, ofi emple.oficio%type) is
    begin
        update emple set oficio = ofi where emp_no = num;
    end modificar_oficio_emple;

    procedure modificar_dept_emple(num emple.emp_no%type, vdept emple.dept_no%type) is
    begin
        update emple set dept_no = vdept where emp_no = num;
    end modificar_dept_emple;
    
    procedure modificar_dir_emple(num emple.emp_no%type, dire emple.emp_no%type) is
    begin
        update emple set dir = dire where emp_no = num;
    end modificar_dir_emple;
    
    procedure modificar_salario_emple(num emple.emp_no%type, sal emple.salario%type) is
    begin
        update emple set salario = sal where emp_no = num;
    end modificar_salario_emple;

    procedure modificar_comision_emple(num emple.emp_no%type, comi emple.comision%type) is
    begin
        update emple set comision = comi where emp_no = num;
    end modificar_comision_emple;
    
    procedure visualizar_datos_emple(num emple.emp_no%type) is
        cursor c1(numero emple.emp_no%type) is select * from emple where emp_no = numero;
    begin
        for v1 in c1(num) loop
            dbms_output.put_line('Num: ' || v1.emp_no || '. Apellido: ' || v1.apellido || '. Oficio: ' || v1.oficio || chr(10));
            dbms_output.put_line('Salario: ' || v1.salario || '€. Comisión: ' || v1.comision || '. Jefe: ' || v1.dir || chr(10));
            dbms_output.put_line('Fecha alta: ' || v1.fecha_alt || '. Departamento: ' || v1.dept_no);
        end loop;
    end visualizar_datos_emple;

    procedure visualizar_datos_emple(ape emple.apellido%type) is 
        vemp emple.emp_no%type;
        cursor c1(numero emple.emp_no%type) is select * from emple where emp_no = numero;
    begin
        vemp := buscar_emple_por_dnombre(ape);

        for v1 in c1(vemp) loop
            dbms_output.put_line('Num: ' || v1.emp_no || '. Apellido: ' || v1.apellido || '. Oficio: ' || v1.oficio || chr(10));
            dbms_output.put_line('Salario: ' || v1.salario || '€. Comisión: ' || v1.comision || '. Jefe: ' || v1.dir || chr(10));
            dbms_output.put_line('Fecha alta: ' || v1.fecha_alt || '. Departamento: ' || v1.dept_no);
        end loop;
    end visualizar_datos_emple;

    function buscar_emple_por_dnombre (ape emple.apellido%type) return number is
    vemp emple.emp_no%type;
    begin
        select emp_no into vemp
        from emple
        where apellido = ape;

        return vemp;
    end buscar_emple_por_dnombre;

    procedure subida_salario_pct(sal number) is
    begin
        if sal > 25 then
            raise_application_error(-20001, 'El porcentaje no puede ser mayor de 25.');
        end if;

        update emple set salario = salario + (salario * sal/100);
    end subida_salario_pct;

    procedure subida_salario_imp(sal emple.salario%type) is 
        vsal emple.salario%type;
    begin
        select avg(salario) into vsal
        from emple;

        vsal := vsal * 0.25;

        if vsal < sal then
            raise_application_error(-20002, 'El aumento no puede ser mayor que el 25% del salario medio.');
        end if;

        update emple set salario = salario + sal;
    end subida_salario_imp;

end gest_emple;

-- Ejercicio 2

create or replace package pq_provincia as

  type t_provincias is record (
    mat varchar2(2),
    prov varchar2(11),
    cp varchar(2)
  );

  type tipo1 is table of t_provincias INDEX BY BINARY_INTEGER;

  v1 tipo1;

  cursor c1 return provincias%rowtype;

  function provincia (p_matricula varchar2) return varchar2;
  function matricula (p_provincia varchar2) return varchar2;
  function cp (p_provincia varchar2) return varchar2;
  procedure borrar_prov;

end pq_provincia;

create or replace package body pq_provincia as

    cursor c1 return provincias%rowtype is select *
                                           from provincias;

    function provincia (p_matricula varchar2) return varchar2 is
        v_prov varchar2(11);
    begin
        select prov into v_prov
        from provincias
        where mat = p_matricula;
        return v_prov;
    end provincia;

    function matricula (p_provincia varchar2) return varchar2 is
        v_mat varchar2(2);
    begin
        select mat into v_mat
        from provincias
        where prov = p_provincia;
        return v_mat;
    end matricula;

    function cp (p_provincia varchar2) return varchar2 is
        v_cp varchar2(2);
    begin
        select cp into v_cp
        from provincias
        where prov = p_provincia;
        return v_cp;
    end cp;

    procedure insertar_prov is
        contador number := 1;
    begin
        for i in c1 loop
            v1(contador).mat := i.mat;
            v1(contador).prov := i.prov;
            v1(contador).cp := i.cp;
            contador := contador + 1;
        end loop;
    end insertar_prov;

    procedure borrar_prov is
    begin
        delete from v1;
        commit;
    end borrar_prov;

end pq_provincia;