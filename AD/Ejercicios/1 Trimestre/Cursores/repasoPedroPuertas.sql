/*
1.- Realiza un procedimiento que muestre por cada producto con ventas.

Nombre Producto1

Fecha1, unidades, importe y nombre del cliente.

Fecha2, unidades, importe y nombre del cliente.

…

Nombre Producto2

…

Indicar el total de unidades vendidas al final del informe. Los datos deberán estar ordenados por Producto y Fecha. 
Nota: Utiliza variable de acoplamiento.
*/

create or replace procedure mostrar_productos
as
    cursor c1 is select descripcion, cod_producto, precio_uni
                 from productos
                 where cod_producto IN (select distinct cod_producto
                                        from ventas);
    cursor c2 (cod_pro number) is select *
                                  from ventas
                                  where cod_producto = cod_pro
                                  order by cod_producto, fecha;
    cursor c3 (cod_pro number, fecha_ven ventas.fecha%type) is select nombre
                                                                from clientes
                                                                where nif = (select nif
                                                                            from ventas
                                                                            where cod_producto = cod_pro
                                                                                    and fecha = fecha_ven);
    tot_ventas number := 0;
    nom clientes.nombre%type;
    prec number;
begin

    for v1 in c1 loop
        dbms_output.put_line('Nombre: ' || v1.descripcion);
        for v2 in c2(v1.cod_producto) loop
            for v3 in c3(v2.cod_producto, v2.fecha) loop
                dbms_output.put_line('Fecha: ' || v2.fecha || '. Unidades: ' || v2.unidades || '. Importe: ' || v1.precio_uni || '€. Nombre cliente: ' || v3.nombre);
                tot_ventas := tot_ventas + v2.unidades;
            end loop;
        end loop;
    end loop;

    dbms_output.put_line('Total de unidades vendidas: ' || tot_ventas);
end;

/*
2.- Realiza un procedimiento que muestre, para cada venta, la fecha, el nombre del cliente, el nombre y precio del producto,
 las unidades vendidas y el importe de la venta. Ordenar los datos por fecha y cliente. Al final indicar el importe de todas las ventas.
*/

create or replace procedure mostrar_ventas
as
    cursor c1 is select * from ventas order by fecha, nif;
    nom clientes.nombre%type;
    precio number;
    nomPro productos.descripcion%type;
    tot_precio number;
begin
    for v1 in c1 loop
        select nombre into nom
        from clientes
        where nif = v1.nif;

        select descripcion, precio_uni into nomPro, precio
        from productos
        where cod_producto = v1.cod_producto;

        tot_precio := precio * v1.unidades;

        dbms_output.put_line('Fecha: ' || v1.fecha || '. Nombre cliente: ' || nom || '. Nombre producto: ' || nomPro || '. Precio: ' || precio || '€. Unidades: ' || v1.unidades || '. Precio total: ' || tot_precio || '€');
        dbms_output.put_line('*************************************');
    end loop;
end;

/*3.- Realiza un procedimiento que muestre por cada cliente con ventas:

Datos del cliente

Nombre Producto 1, Precio, Unidades

Nombre Producto 2, Precio, Unidades

…

PrecioMedioProductosComprados

Mostrar, al final del informe, el cliente que ha comprado más unidades. Nota: Utiliza cursor con parámetro.
*/

create or replace procedure mostrar_datos
as
    cursor c1 is select nombre, nif
                        from clientes
                        where nif IN (select distinct nif
                                    from ventas)
                        order by nombre;
    cursor c2(nif_cli clientes.nif%type) is select descripcion, precio_uni, unidades
                                            from productos, ventas
                                            where productos.cod_producto = ventas.cod_producto
                                                  and nif = nif_cli;
    total number := 0;
    suma number := 0;
    contador number := 0;
begin
    for v1 in c1 loop
        dbms_output.put_line('Datos del cliente.');
        dbms_output.put_line('Nif: ' || v1.nif || '. Nombre: ' || v1.nombre);
        dbms_output.put_line('Productos:');
        for v2 in c2(v1.nif) loop
            dbms_output.put_line('Nombre: ' || v2.descripcion || '. Precio: ' || v2.precio_uni || '. Unidades: ' || v2.unidades);
            contador:= contador + 1;
            suma := suma + v2.precio_uni;
        end loop;
        total := suma / contador;
        dbms_output.put_line('Precio medio: ' || total);
        dbms_output.put_line('**************************************');
        contador:=0;
        suma:=0;
        total:=0;
    end loop;
end;

/*
4.- Dado un nombre de artículo, una cantidad y un porcentaje, disminuir las existencias del artículo en esa cantidad 
y aumentar el precio en ese porcentaje. Utiliza excepciones definidas por el usuario para controlar que las existencias 
no pueden ser negativas y que el nuevo precio no debe superar los 10 Є.
*/

create or replace procedure modificar_producto(nom varchar2, uni number, porcentaje number)
as
    v_nom productos.descripcion%type;
    v_uni number;
    v_cod number;
begin
    commit;

    select descripcion, cod_producto into v_nom, v_cod
    from productos
    where descripcion = nom;

    select unidades into v_uni
    from ventas
    where cod_producto = v_cod

    if v_uni + uni < 0 then
        raise_application_error(-20001, 'Las unidades no pueden ser negativas');
    end if;

    commit;

    exception
        when no_data_found then
            dbms_output.put_line('No existe el producto.');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;

end;

/*
5.- Realiza un procedimiento que muestre el nombre del empleado más antiguo de cada departamento junto con el nombre del departamento.
*/



/*
6.- Realiza un procedimiento que borre a los dos empleados más nuevos de cada departamento. Utiliza For Update.
*/

/*
7.- Realiza un procedimiento que recorte el sueldo un 20% a los empleados cuyo nombre empiece por la letra que recibe como parámetro. 
Utiliza Rowid.
*/