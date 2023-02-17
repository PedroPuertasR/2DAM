-- Ejercicio 1

create or replace package pk1 as

    type t_alumno is record(ape varchar2(20),
                            notas number(5,2)
                           );

    type tabla is table of t_alumno index by binary_integer;

    contador number := 1;

    procedure guardar_datos(asig varchar2);

    procedure mostrar_datos(asig varchar2);

end;

create or replace package body pk1 as

    tipo1 tabla;

    procedure guardar_datos(asig varchar2) is
        valum alumnos.Codigo_al%type;
        vnotas notas.nota%type;
        cursor c1 is select * 
                     from alumnos
                     where codigo_al in (select codAl
                                         from notas
                                         where CodAs = (select Codigo_as
                                                        from Asignaturas
                                                        where Nombre_as = asig));
    begin
        for v1 in c1 loop
            select nota into vnotas
            from notas
            where codAl = v1.codigo_al
                and CodAs = (select Codigo_as
                            from Asignaturas
                            where Nombre_as = asig);

            tipo1(contador).ape := v1.Apellidos_al;
            tipo1(contador).notas := vnotas;

            contador := contador + 1;
            
        end loop;
        
    end guardar_datos;

    procedure mostrar_datos (asig varchar2) is
        i number;
        vnota notas.nota%type;
        vape alumnos.Apellidos_al%type;
        vprof profesores.Nombre_pr%type;
    begin
        vnota := 0;

        guardar_datos(asig);

        i := tipo1.first;

        select Nombre_pr into vprof
        from Profesores
        where Codigo_pr in (select Profesor_as
                            from Asignaturas
                            where Nombre_as = asig);

        dbms_output.put_line('Asignatura: ' || asig);
        dbms_output.put_line('Profesor: ' || vprof || chr(10));

        while i is not null loop
            dbms_output.put_line('Apellidos: ' || tipo1(i).ape);
            dbms_output.put_line('Notas:' || tipo1(i).notas || chr(10));

            if tipo1(i).notas > vnota then
                vnota := tipo1(i).notas;
                vape := tipo1(i).ape;
            end if;

            i := tipo1.next(i);
        end loop;

        dbms_output.put_line('Máxima nota: ' || vape || ' -> ' || vnota);

    end mostrar_datos;

end pk1;

declare
begin
    pk1.mostrar_datos('Java');
end;  

-- Ejercicio 2.1

create or replace package pk2 as
    type t_notas is table of notas.codAl%type index by binary_integer;
    tipo1 t_notas;
end;

create or replace trigger t1
before insert or update or delete on notas
begin
    pk2.tipo1.delete;
end;

create or replace trigger t2
after insert or update or delete on notas
for each row
begin
    pk2.tipo1(:new.CodAs) := :new.codAl; 
end;

create or replace trigger t3
after insert or update or delete on notas
declare
    i number;
    vmedia alumnos.Notamedia_al%type;
    vmediaasig asignaturas.Notamedia_as%type;
begin
    i := pk2.tipo1.first;

    while i is not null loop
        select avg(nota) into vmedia
        from notas
        where codAl = pk2.tipo1(i);

        select avg(nota) into vmediaasig
        from notas
        where codAs = i;

        update alumnos set Notamedia_al = vmedia where codigo_al = pk2.tipo1(i);
        update asignaturas set Notamedia_as = vmediaasig where codigo_as = i;

        i := pk2.tipo1.next(i);
    end loop;

    exception
        when no_data_found then
            dbms_output.put_line('Error al encontrar las notas en la tabla.');
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;


-- Ejercicio 2.2

create or replace trigger t4
after insert or update or delete on notas
declare
    vnota notas.nota%type;
    cursor c1 is select codigo_al from alumnos;
begin
    for v1 in c1 loop
        select count(*) into vnota
        from notas
        where codAl = v1.codigo_al;

        if vnota = 0 then
            raise_application_error(-20001, 'No puede haber ningún alumno sin al menos una nota.');
        end if; 
    end loop;

    exception
        when others then
            dbms_output.put_line(sqlcode || sqlerrm);
end;