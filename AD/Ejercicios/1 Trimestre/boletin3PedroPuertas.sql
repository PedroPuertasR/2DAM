/*Ejercicio 1*/

create or replace function diferencia
return number
as
    total number;
    min_precio productos.precio_uni%type;
    max_precio productos.precio_uni%type;
begin
    select min(precio_uni) into min_precio
    from productos;

    select max(precio_uni) into max_precio
    from productos;

    total := max_precio - min_precio;

    return total;
end;

/*Ejercicio 2*/

create or replace procedure clienteRozas
as
    n_cliente clientes.nombre%type;
    nif_cliente clientes.nif%type;
begin
    select nif, nombre into nif_cliente, n_cliente
    from clientes
    where domicilio like 'LAS ROZAS'
          and nif not in (select nif
                            from ventas);
                    
    dbms_output.put_line('NIF: ' || nif_cliente || '. Nombre: ' || n_cliente || '.');
end;

/*Ejercicio 3*/

create or replace procedure insertarVenta(cod number)
as
begin

    insert into ventas (nif, cod_producto, fecha, unidades) select nif, cod, sysdate, 10 from clientes;

    exception
        when no_data_found then
            dbms_output.put_line('El producto no existe.');
end;

/*Ejercicio 4*/

create or replace procedure numVentas
as
    total number;
    v_cod ventas.cod_producto%type;
    v_descripcion	productos.descripcion%type;
	v_linea_producto productos.linea_producto%type;
 	v_precio_uni productos.precio_uni%type;
	v_stock productos.stock%type;
begin
    SELECT * into v_cod, total
    FROM (
            SELECT cod_producto, count(*)
            FROM ventas
            GROUP BY cod_producto 
            ORDER BY count(*) desc
         ) resultSet
    WHERE ROWNUM=1;

    select descripcion, linea_producto, precio_uni, stock into v_descripcion, v_linea_producto, v_precio_uni, v_stock
    from productos
    where cod_producto = v_cod;

    dbms_output.put_line('Código producto: ' || v_cod || '. Descripción: ' || v_descripcion || '. Linea producto: ' 
    || v_linea_producto || '. Precio unitario: ' || v_precio_uni || '€ . Stock: ' || v_stock || '. Ventas: ' || total);
end;

/*Ejercicio 5*/

create or replace function difSalario(cod_empleado number)
return number
as
    v_dept depart.dept_no%type;
    v_dif emple.salario%type;
    v_max emple.salario%type;
    v_sal_emple emple.salario%type;
begin
    select dept_no, salario into v_dept, v_sal_emple
    from emple
    where emp_no = cod_empleado;

    SELECT * into v_max
    FROM (
            SELECT e.salario
            FROM emple e, depart d
            WHERE e.dept_no = d.dept_no
                  and d.dept_no = v_dept
            ORDER BY e.salario desc
         ) resultSet
    WHERE ROWNUM=1;

    v_dif := v_max - v_sal_emple;

    return v_dif;

    exception
        when no_data_found then
            return -1;
end;

/*Ejercicio 6*/

create or replace procedure porcEmple(num in number, porc out number)
as
    v_total number(5,2);
begin
    select count(*) into v_total
    from emple;

    porc := num / v_total * 100;
end;

declare
    cant number;
begin
    porcEmple(14, cant);
    dbms_output.put_line(cant || '%');
end;