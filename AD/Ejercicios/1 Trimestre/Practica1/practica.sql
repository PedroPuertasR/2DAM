/*
  Procedimiento para bajar el precio de los libros de una editorial que hace más de x tiempo que han salido (fecha number).

  Bajada = porcentaje
  Edi = id_editorial
*/

create or replace procedure bajar_precio_libro(edi integer, fecha number, bajada number)
as
    cursor c1(limite number) is select libro.*, floor(months_between(sysdate, fecha_pub) / 12) as anios
                                from libro
                                where floor(months_between(sysdate, fecha_pub) / 12) > limite;
    bandera integer := 0;
    contador integer := 0;
    v_edi libro.id_editorial%type;
    e1 exception;
begin

    commit;

    select id into v_edi
    from editorial
    where id = edi;

    for v1 in c1(fecha) loop
        if v1.id_editorial = edi then
            update libro set precio = precio - (precio * bajada / 100) where id = v1.id;
            contador := contador + 1;
        end if;
    end loop;

    if contador = 0 then
        raise e1;
    end if;

    dbms_output.put_line('Filas afectadas: ' || contador);

    commit;

    exception
        when no_data_found then
            dbms_output.put_line('No existe esa editorial.');
            rollback;
        when too_many_rows then
            dbms_output.put_line('Una consulta ha devuelto muchas filas');
            rollback;
        when e1 then
            dbms_output.put_line('No hay ningún libro que cumpla la condición de la fecha');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;
end;

/*
Inserción de un libro comprobando que la editorial, la categoria y la tienda existan. Además comprueba
que el ISBN no se repita, que su longitud no sea diferente de 13 y que el precio del libro no sea 
negativo.
*/

create or replace procedure alta_libro(escritor varchar2, nom varchar2, edi integer, isbn_lib varchar2,
                                       fecha date, precio_lib number, cate integer, tie integer)
as
    cursor c1 is select isbn from libro;
    v_edi libro.id_editorial%type;
    v_tienda libro.id_tienda%type;
    v_cat libro.id_categoria%type;
    nueva_id libro.id%type;
    bandera number := 0;
    longitud number := 0;
    e1 exception;
begin

    commit;

    if precio_lib <= 0 then
        raise_application_error(-20001, 'El precio del libro no puede ser negativo.');
        rollback;
    end if;

    select length(isbn_lib) into longitud
    from dual;

    if longitud <> 13 then
        raise_application_error(-20002, 'La longitud del ISBN no es correcta.');
        rollback;
    end if;

    for v1 in c1 loop
        if v1.isbn = isbn_lib then
            raise e1;
        end if;
    end loop;

    select id into v_edi
    from editorial
    where id = edi;

    bandera := 1;

    select id into v_tienda
    from tienda
    where id = tie;

    bandera := 2;

    select id into v_cat
    from categoria
    where id = cate;

    bandera := 3;

    select * into nueva_id
    from (select id
          from libro
          order by id desc) result
    where rownum <= 1;

    bandera := 4;
    
    nueva_id := nueva_id + 1;

    insert into libro values (nueva_id, escritor, nom, edi, isbn_lib, fecha, precio_lib, cate, tie);

    commit;

    exception
        when no_data_found then
            rollback;
            if bandera = 0 then
                dbms_output.put_line('No existe ninguna editorial con ese id.');
            elsif bandera = 1 then
                dbms_output.put_line('No existe ninguna tienda con ese id.');
            elsif bandera = 2 then
                dbms_output.put_line('No existe ninguna categoría con ese id.');
            elsif bandera = 3 then
                dbms_output.put_line('No hay datos en la tabla');
            else
                dbms_output.put_line('Alguna consulta no ha obtenido resultado.');
            end if;
        when too_many_rows then
            dbms_output.put_line('Alguna consulta ha devuelto más de una fila.');
            rollback;
        when e1 then
            dbms_output.put_line('No puede repetirse un ISBN.');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;
end;

exec alta_libro('Pedro', 'adsda', 1, '1234567891234', '25/12/2020', 12, 1, 1);

/*
Programa que da de baja a los empleados que tengan un salario menor que la media de su tienda y que lleven menos de
un año trabajando.

*/
create or replace procedure baja_empleados
as
    cursor c1 is select *
                 from tienda;
    cursor c2(tie integer) is select *
                              from trabajador
                              where tienda = tie
                                    and floor(months_between(sysdate, fecha_cont)) / 12 < 1;    
    media trabajador.salario%type;  
    contador number := 0;
begin

    commit;

    for v1 in c1 loop

        select avg(salario) into media
        from trabajador
        where tienda = v1.id;

        for v2 in c2(v1.id) loop
            
            if media > v2.salario then
                delete from trabajador where id = v2.id;
                contador := contador + 1;
            end if;

        end loop;
    end loop;

    if contador <= 0 then
        raise_application_error(-20001, 'No se ha dado de baja a ningún empleado.');
    end if;

    commit;

    dbms_output.put_line('Filas afectadas: ' || contador);

    exception
        when no_data_found then
            dbms_output.put_line('Una consulta no ha obtenido resultado.');
            rollback;
        when too_many_rows then
            dbms_output.put_line('Una consulta ha devuelto más de una fila.');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;
end;

exec baja_empleados;

/* Procedimiento que muestra los datos del jefe de la franquicia y los encargados de cada tienda. En caso de que no se hayan mostrado todos ellos
   se llamará a la excepción e1 que informará del error.
*/

create or replace procedure consultar_jefes
as
    cursor c1 is select * 
                 from tienda;
    cursor c2(dire integer) is select id, nombre, apellidos, dni, fecha_cont, salario, tienda, id_jefe
                               from trabajador
                               where id in (select distinct id_jefe
                                            from trabajador)
                                     and tienda = dire;
    v_tiendas tienda.id%type;
    v1 c1%rowtype;
    contador integer;
    e1 exception;
begin

    select count(*) into v_tiendas
    from tienda;

    open c1;

    fetch c1 into v1;

    while c1%found loop

        for v2 in c2(v1.id) loop

            if v2.id_jefe is null then
                dbms_output.put_line('Jefe de la franquicia:');
            else
                dbms_output.put_line('Encargado/a de la tienda nº' || v1.id || ':');
            end if;

            dbms_output.put_line('Nombre: ' || v2.nombre || ', Apellidos: ' || v2.apellidos || ', DNI: ' || v2.dni);
            dbms_output.put_line('Fecha contrato: ' || v2.fecha_cont || ', Salario: ' || v2.salario || '€, Tienda: ' || v1.direccion || chr(10));

            contador := contador + 1;
        end loop;

        fetch c1 into v1;

    end loop;

    if contador <= v_tiendas then
        raise e1;
    end if;

    close c1;

    exception
        when no_data_found then
            dbms_output.put_line('Error al encontrar en número de tiendas.');
        when too_many_rows then
            dbms_output.put_line('Una consulta ha devuelto más de una fila.');
        when e1 then
            dbms_output.put_line('Número de jefes menor al natural.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;

exec consultar_jefes;

/* Procedimiento que realiza un listado de los datos de los libros por editorial. Mostrando el precio total de los libros
   de cada editorial, además del total de todas ellas.
*/

create or replace procedure mostrar_libros_edi
as
    cursor c1 is select id, nombre from editorial;
    cursor c2(vedi integer) is select *
                               from libro
                               where id_editorial = vedi
                               order by nombre;
    v_cat categoria.nombre%type;
    precio_total number := 0;
    precio_edi number := 0;
    num_libros number := 0;
begin

    for v1 in c1 loop

        dbms_output.put_line('Editorial: ' || v1.nombre || chr(10));

        for v2 in c2(v1.id) loop

            select nombre into v_cat
            from categoria
            where id = v2.id_categoria;

            dbms_output.put_line('Nombre: ' || v2.nombre || '. Autor: ' || v2.autor || '. ISBN: ' || v2.isbn);
            dbms_output.put_line('Fecha publicación: ' || v2.fecha_pub ||'. Precio: ' || v2.precio || '€. Categoría: ' || v_cat || chr(10));


            num_libros := num_libros + 1;
            precio_edi := precio_edi + v2.precio;

        end loop;

        if precio_edi <= 0 then
            raise_application_error(-20001, 'No existen libros en la editorial. Introduzca libros o borre la editorial.');
        end if;

        dbms_output.put_line('Precio de los libros de ' || v1.nombre || ': ' || precio_edi || '€.' || chr(10) || chr(10));

        precio_total := precio_total + precio_edi;

        precio_edi := 0;

    end loop;

    if precio_total <= 0 then
        raise_application_error(-20002, 'No existen libros en las editoriales.');
    end if;

    dbms_output.put_line('Precio total de los libros de todas las editoriales: ' || precio_total || '€.');

    exception
        when no_data_found then
            dbms_output.put_line('No se ha encontrado la fila buscada.');
        when too_many_rows then
            dbms_output.put_line('Alguna consulta ha devuelto más de una fila.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);

end;

exec mostrar_libros_edi;

/* Procedimiento para cambiar de editorial los libros a una nueva editorial.
*/

create or replace procedure cambiar_editorial(antiguo varchar2, nuevo varchar2)
as
    v_antiguo editorial.id%type;
    v_nuevo editorial.id%type;
    cursor c1 is select id from libro where id_editorial = v_antiguo;
    v1 c1%rowtype;
    bandera integer := 0;
    contador integer := 0;
begin

    commit;

    select id into v_nuevo
    from editorial
    where nombre like nuevo;

    bandera := 1;

    select id into v_antiguo
    from editorial
    where nombre like antiguo;

    open c1;

    fetch c1 into v1;

    while c1%found loop

        update libro set id_editorial = v_nuevo where id = v1.id;

        contador := contador + 1;
        fetch c1 into v1;
    end loop;

    close c1;

    dbms_output.put_line('Filas afectadas: ' || contador);

    commit;

    exception
        when no_data_found then
            rollback;
            if bandera = 0 then
                dbms_output.put_line('No se ha encontrado la nueva editorial.');
            elsif bandera = 1 then
                dbms_output.put_line('No se ha encontrado la antigua editorial.');
            end if;
        when too_many_rows then
            dbms_output.put_line('Una de las consultas ha devuelto más de una fila.');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;
end;

exec cambiar_editorial('Alianza Editorial', 'Nova Editorial');


/* Procedimiento para borrar una categoría y poner todos los libros que estén en ella en una
   categoría provisional.
*/

create or replace procedure borrar_categoria(nom varchar2)
as
    vnom categoria.id%type;
    cursor c1 is select * 
                 from libro 
                 where id_categoria = (select id
                                       from categoria
                                       where nombre like 'Provisional');
    cursor c2 is select * from libro where id_categoria = vnom;
    v2 c1%rowtype;
    vcat categoria.nombre%type;
    contador integer := 0;
    bandera integer := 0;
begin
    commit;

    select id into vnom
    from categoria
    where nombre like nom;

    bandera := 1;

    open c2;

    fetch c2 into v2;

    while c2%found loop
        update libro set id_categoria = 5 where id = v2.id;
        contador := contador + 1;
    end loop;

    delete from categoria where id = vnom;

    close c2;

    dbms_output.put_line('Filas afectadas: ' || contador || chr(10));
    dbms_output.put_line('Libros cambiados:' || chr(10));

    select nombre into vcat
    from categoria
    where id = 5;

    for v1 in c1 loop
        dbms_output.put_line('Nombre: ' || v1.nombre || '. Autor: ' || v1.autor || '. Precio: ' || v1.precio || '€.');
        dbms_output.put_line('Fecha publicación: ' || v1.fecha_pub || '. ISBN: ' || v1.isbn || '. Categoria: ' || vcat || chr(10));
    end loop;

    commit;

    exception
        when no_data_found then
            rollback;
            if bandera = 0 then
                dbms_output.put_line('No se ha encontrado la categoría antigua.');
            elsif bandera = 1 then
                dbms_output.put_line('No se ha encontrado la nueva categoría.');
            end if;
        when too_many_rows then
            dbms_output.put_line('Ha habido más de un resultado en una consulta.');
            rollback;
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;

end;

exec borrar_categoria('Fantasia');