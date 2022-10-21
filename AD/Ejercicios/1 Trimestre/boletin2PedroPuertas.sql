/*Ejercicio 1*/

create or replace function totalVendidas(num_prod number)
return number
as
    total ventas.unidades%type;
    prod_e ventas.cod_producto%type;
    bandera number := -1;
begin

    begin
        select cod_producto into prod_e
        from productos
        where cod_producto = num_prod;

        exception
            when no_data_found then
                return bandera;
    end;

    bandera := 0;

    begin
        select sum(unidades) into total
        from ventas
        where cod_producto = num_prod;

        exception
            when no_data_found then
                return bandera;
    end;

    return total;

end;

/*Ejercicio 2*/

create or replace procedure ventasProd(p_producto IN number, p_total OUT number)
as
    prod_e ventas.cod_producto%type;
begin
    p_total := -1;

    select cod_producto into prod_e
    from productos
    where cod_producto = p_producto;

    p_total := 0;

    select sum(unidades) into p_total
    from ventas
    where cod_producto = p_producto;

    exception
        when no_data_found then
            if p_total = -1 then
                p_total := -1;
            else
                p_total := 0;
            end if;
end;

declare
    cant number;
begin
    ventasProd(2, cant);
    dbms_output.put_line(cant);
end;

/*Ejercicio 3*/

create or replace procedure mostrarDatosVenta(nif_cliente varchar2, fecha_venta date)
as
    f_venta ventas.fecha%type;
    n_cliente clientes.nombre%type;
    d_producto productos.descripcion%type;
    u_producto ventas.unidades%type;
begin
    begin
        select nombre into n_cliente
        from clientes
        where nif = nif_cliente;

        exception
            when no_data_found then
                dbms_output.put_line('No se ha encontrado el cliente.');
    end;

    begin
        select fecha into f_venta
        from ventas
        where fecha = fecha_venta
              and nif = nif_cliente;

        exception
            when no_data_found then
                dbms_output.put_line('No hubo ninguna venta ese día.');
    end;

    select sum(unidades)into u_producto
    from ventas
    where nif = nif_cliente
          and fecha = fecha_venta;
    
    select p.descripcion into d_producto
    from productos p, ventas v
    where p.cod_producto = v.cod_producto
          and v.nif = nif_cliente
          and v.fecha = fecha_venta;

    dbms_output.put_line('Nombre: ' || n_cliente || '. Descripción: ' || d_producto || '. Unidades vendidas: ' || u_producto || '.');

    exception
        when no_data_found then
            dbms_output.put_line('No se han encontrado datos.');
end;

exec mostrarDatosVenta('333C', '22/09/1997');

/*Ejercicio 4*/

create or replace function ventasCliente(nif_cliente varchar2)
return number
as
    n_cliente clientes.nif%type;
    c_ventas number;
begin
    begin
        select nif into n_cliente
        from clientes
        where nif = nif_cliente;

        exception
            when no_data_found then
                return -1;
    end;

    select count(*) into c_ventas
    from ventas
    where nif = nif_cliente;

    return c_ventas;

    exception
        when no_data_found then
            return 0;
end;

/*Ejercicio 5*/

create or replace function ventasNombre(n_cliente varchar2)
return number
as
    nif_cliente clientes.nif%type;
    c_ventas number;
begin
    begin
        select nif into nif_cliente
        from clientes
        where nombre = n_cliente;

        exception
            when no_data_found then
                return -1;
    end;

    select ventasCliente(nif_cliente) into c_ventas
    from dual;

    return c_ventas;
end;