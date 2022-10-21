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
    v_cod productos.cod_producto%type;
begin

    select cod_producto into v_cod
    from productos
    where cod_producto = cod;

    insert into ventas values ('111A', cod, 'current_date', 10);
    insert into ventas values ('222B', cod, 'current_date', 10);
    insert into ventas values ('333C', cod, 'current_date', 10);
    insert into ventas values ('444D', cod, 'current_date', 10);
    insert into ventas values ('555E', cod, 'current_date', 10);
    insert into ventas values ('666F', cod, 'current_date', 10);
    insert into ventas values ('777G', cod, 'current_date', 10);
    insert into ventas values ('888H', cod, 'current_date', 10);
    insert into ventas values ('999I', cod, 'current_date', 10);

    exception
        when no_data_found then
            dbms_output.put_line('El producto no existe.');
end;