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

    for v1 in c1 loop

        select avg(salario) into media
        from trabajador
        where tienda = v1.id;

        for v2 in c2(v1.id) loop
            
            if media < v2.salario then
                delete from trabajador where id = v2.id;
                contador := contador + 1;
            end if;

        end loop;

        media := 0;

    end loop;

    if contador <= 0 then
        raise_application_error(-20001, 'No se ha dado de baja a ningún empleado.');
    end if;

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