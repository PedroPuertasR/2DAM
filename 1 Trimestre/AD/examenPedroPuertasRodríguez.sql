/*Pedro Puertas Rodríguez 2º DAM*/

/*Ejercicio 1*/

create or replace procedure insertar_alquiler(peli char, socio_al char, fecha_alq date, fecha_dev date)
as
    e1 exception;
    v_peli char(3);
    v_soc char(4);
    v_fecha_alq date;
    bandera number := 0;
    pragma exception_init(e1, -1);
begin
    select socio into v_soc
    from alquiler
    where socio = socio_al;

    bandera := 1;

    select copia_pel into v_peli
    from alquiler
    where copia_pel = peli;

    if fecha_alq < fecha_dev then
        raise_application_error(-20001, 'La fecha de devolución no puede ser anterior a la del alquiler.');
    end if;

    select fec_alquila into v_fecha_alq
    from alquiler
    where copia_pel = peli
          and socio = socio_al
          and fec_alquila = fecha_alq;

    if v_fecha_alq is null then
        insert into alquiler values(peli, socio_al, fecha_alq, fecha_dev);
    else
        raise e1;
    end if;

    exception
        when no_data_found then
            if bandera = 0 then
                dbms_output.put_line('No se ha encontrado el socio.');
            elsif bandera = 1 then
                dbms_output.put_line('No existe la película.');
            elsif bandera = 2 then
                dbms_output.put_line('Error en la fecha.');
            end if;
        when e1 then
            dbms_output.put_line('Alquiler duplicado.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;

exec insertar_alquiler('113', '1001', '09/10/2014', '08/10/2014');

/*Ejercicio 2*/

create or replace procedure mostrar_peliculas(nom_socio varchar2, ape_socio varchar2, ape2_socio varchar2)
as
    cursor c1(v_num char) is select *
                            from alquiler
                            where socio = v_num;
    v_num char(4);
begin
    select num_socio into v_num
    from socio
    where nombre like nom_socio
          and apellido1 like ape_socio
          and apellido2 like ape2_socio;

    dbms_output.put_line('Nombre completo: ' || nom_socio || ' ' || ape_socio || ' ' || ape2_socio);

    for v1 in c1(v_num) loop
        dbms_output.put_line('Película: ' || v1.copia_pel || '. Fecha alquiler: ' || v1.fec_alquila || '. Fecha devolución: ' || v1.fec_devolucion);
    end loop;

    exception
        when no_data_found then
            dbms_output.put_line('Socio no encontrado.');
        when too_many_rows then
            dbms_output.put_line('Una consulta ha devuelto más de una fila.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;

exec mostrar_peliculas('Pedro','Gutiérrez','Solero');

/*Ejercicio 3*/

create or replace procedure actualizar_datos
as
    cursor c1 is select pelicula, count(*) as total
                 from copia_pelicula 
                 group by pelicula;
    contador number := 0;
begin
    commit;

        for v1 in c1 loop
            if v1.total >= 2 then
                update pelicula set precio_alquiler = precio_alquiler + (precio_alquiler * 0.02) where codigo = v1.pelicula;
                contador := contador + 1;
            else
                update pelicula set precio_alquiler = precio_alquiler + (precio_alquiler * 0.04) where codigo = v1.pelicula;
                contador := contador + 1;
            end if;
        end loop;

        dbms_output.put_line('Procedimiento terminado. Filas afectadas: ' || contador);

    commit;

    exception
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
            rollback;
end;

exec actualizar_datos;

/*Ejercicio 4*/

create or replace procedure mostrar_titulo(gen in varchar2, v_titulo out varchar2)
as
begin

    select * into v_titulo
    from(select titulo
         from pelicula
         where genero like gen) result
    where rownum <= 1;

    if v_titulo is null then
        raise_application_error(-20002, 'No existe ese género.');
    end if;
end;

declare
    gen varchar2(20) := 'Drama';
    v_titulo varchar2(50);
begin
    mostrar_titulo(gen, v_titulo);
    dbms_output.put_line('Titulo: '|| v_titulo); 
end;

/*Ejercicio 5*/

create or replace procedure mostrar_info
as
    cursor c1 is select distinct titulo, id_copia, precio_alquiler
                 from pelicula, copia_pelicula
                 where pelicula.codigo = copia_pelicula.pelicula
                       and id_copia in (select distinct copia_pel
                                        from alquiler);
    cursor c2(copia char) is select nombre, fec_nac
                             from socio
                             where num_socio in (select socio
                                                 from alquiler
                                                 where copia_pel = copia);
    v_edad number(5,0);
    v_edad_media number(5,2) := 0;
    v_rec_peli number := 0;
    v_tot_rec number := 0;
    contador number := 0;
begin
    for v1 in c1 loop
        dbms_output.put_line('Pelicula: ' || v1.titulo);
        dbms_output.put_line('Socios:');

        for v2 in c2(v1.id_copia) loop

            select months_between(sysdate, v2.fec_nac) / 12 into v_edad
            from dual;

            v_edad_media := v_edad_media + v_edad;
            contador := contador + 1;
            v_rec_peli := v_rec_peli + v1.precio_alquiler;
            dbms_output.put_line('Nombre: ' || v2.nombre || '. Edad: ' || v_edad);

        end loop;

        v_edad_media := v_edad_media / contador;

        dbms_output.put_line('Edad media de socios: ' || v_edad_media || '. Dinero recaudado: ' || v_rec_peli || '€');
        dbms_output.put_line('**********************************');
        contador := 0;
        v_edad_media := 0;
        v_tot_rec := v_tot_rec + v_rec_peli;
        v_rec_peli := 0;

    end loop;

    dbms_output.put_line('Total recaudado: ' || v_tot_rec || '€');
    
    exception
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;