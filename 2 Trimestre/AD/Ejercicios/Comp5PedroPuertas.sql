/*
Crea un procedimiento que permita consultar todos los
datos de la tabla depart a partir de una condición que
se indicará en la llamada al procedimiento.
*/

create or replace procedure consulta(fila varchar2, valor varchar2)
as
    id_cursor number;
    v_comando varchar2(100);
    vdept depart.dept_no%type;
    vdnombre depart.dnombre%type;
    vloc depart.loc%type;
    vdummy number;
begin
    id_cursor := dbms_sql.open_cursor;

    v_comando := 'SELECT * FROM DEPART WHERE ' || fila || ' = :valor';
    dbms_sql.parse(id_cursor, v_comando, dbms_sql.v7);
    dbms_sql.bind_variable(id_cursor, ':valor', valor);

    dbms_sql.define_column(id_cursor, 1, vdept);
    dbms_sql.define_column(id_cursor, 2, vdnombre, 14);
    dbms_sql.define_column(id_cursor, 3, vloc, 14);
    vdummy := dbms_sql.execute(id_cursor);

    while dbms_sql.fetch_rows(id_cursor) > 0 loop

        dbms_sql.column_value(id_cursor, 1, vdept);
        dbms_sql.column_value(id_cursor, 2, vdnombre);
        dbms_sql.column_value(id_cursor, 3, vloc);
        dbms_output.put_line(vdept || '*' || vdnombre || '*' || vloc);

    end loop;

    dbms_sql.close_cursor(id_cursor);

    exception
        when others then
            dbms_sql.close_cursor(id_cursor);
            raise;
end;

-- Ejemplo 1

create or replace procedure ejsqldin (instruccion varchar2)
as
    id_cursor integer;
    v_dummy integer;
begin
    id_cursor := dbms_sql.open_cursor;
    dbms_sql.parse(id_cursor, instruccion, dbms_sql.v7);
    v_dummy := dbms_sql.execute(id_cursor);
    dbms_sql.close_cursor(id_cursor);

    exception
        when others then
            dbms_sql.close_cursor(id_cursor);
            raise;
end ejsqldin;

-- Ejemplo 2

create or replace procedure creartabla (nombretabla varchar2, nombrecol varchar2, longitudcol positive)
as
    id_cursor integer;
    v_comando varchar2(2000);
begin
    id_cursor := dbms_sql.open_cursor;
    v_comando := 'create table '|| nombretabla || ' (' || nombrecol || ' varchar2(' || longitudcol || '))';
    dbms_sql.parse(id_cursor, v_comando, dbms_sql.native);
    dbms_sql.close_cursor(id_cursor);

    exception
        when others then
            dbms_sql.close_cursor(id_cursor);
            raise;
end creartabla;

-- Ejemplo 3

create or replace procedure introducir_fila(nombretabla varchar2, valor varchar2)
as
    id_cursor integer;
    v_comando varchar2(2000);
    v_filas integer;
begin
    id_cursor := dbms_sql.open_cursor;
    v_comando := 'insert into ' || nombretabla || 'values (:val_1)';
    dbms_output.put_line(v_comando);
    dbms_sql.parse(id_cursor, v_comando, dbms_sql.native);
    dbms_sql.bind_variable(id_cursor, ':val_1', valor);
    v_filas := dbms_sql.execute(id_cursor);
    dbms_sql.close_cursor(id_cursor);
    dbms_output.put_line('Filas introducidas: ' || v_filas);

    exception
        when others then
            dbms_sql.close_cursor(id_cursor);
            raise;
end introducir_fila;

-- Ejemplo 4

create or replace procedure consultar_emple(condicion varchar2, valor varchar2)
as
    id_cursor integer;
    v_comando varchar2(2000);
    v_dummy number;
    v_emp_no emple.emp_no%type;
    v_apellido emple.apellido%type;
    v_oficio emple.oficio%type;
begin
    id_cursor := dbms_sql.open_cursor;
    v_comando := 'select emp_no, apellido, oficio from emple where ' || condicion || ':val_1';
    dbms_output.put_line(v_comando);

    dbms_sql.parse(id_cursor, v_comando, dbms_sql.native);
    dbms_sql.bind_variable(id_cursor, ':val_1', valor);
    
    dbms_sql.define_column(id_cursor, 1, v_emp_no);
    dbms_sql.define_column(id_cursor, 2, v_apellido, 14);
    dbms_sql.define_column(id_cursor, 3, v_oficio, 14);
    v_dummy := dbms_sql.execute(id_cursor);

    while dbms_sql.fetch_rows(id_cursor) > 0 loop
        dbms_sql.column_value(id_cursor, 1, v_emp_no);
        dbms_sql.column_value(id_cursor, 2, v_apellido);
        dbms_sql.column_value(id_cursor, 3, v_oficio);
        dbms_output.put_line(v_emp_no || '*' || v_apellido || '*' || v_oficio);
    end loop;
    dbms_sql.close_cursor(id_cursor);

    exception
        when others then
            dbms_sql.close_cursor(id_cursor);
            raise;
end consultar_emple;

-- Ejemplo 5

create or replace procedure ejsqldin_nds (instruccion varchar2)
as
begin
    execute immediate instruccion;
end ejsqldin_nds;

-- Ejemplo 6

create or replace procedure borrar (nombre_tabla varchar2,columnaref varchar2, valor varchar2)
as
    instruccion_borrado varchar2(2000);
begin
    instruccion_borrado := 'delete from ' || nombre_tabla || ' where ' || columnaref || ' = ' || valor;
    execute immediate instruccion_borrado;
end;

-- Ejemplo 7

create or replace procedure borrar (nombre_tabla varchar2,columnaref varchar2, valorvarchar2)
as
    instruccion_borrado varchar2(2000);
begin
    instruccion_borrado := 'delete from ' || nombre_tabla || ' where ' || columnaref || ' = :vt1'; 
    execute immediate instruccion_borrado
    using valor;
end;