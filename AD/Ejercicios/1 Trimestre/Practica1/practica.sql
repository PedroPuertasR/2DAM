/*
  Procedimiento para bajar el precio de los libros de una editorial que hace más de x tiempo que han salido (fecha number).

  Bajada = porcentaje
  Edi = id_editorial
*/

create or replace procedure subir_precio_libro(edi integer, fecha number, bajada number)
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

