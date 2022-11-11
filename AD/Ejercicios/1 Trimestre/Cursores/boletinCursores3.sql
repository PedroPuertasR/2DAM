/*Ejercicio propuesto 4*/

create or replace procedure listar_emple_for
as
    cursor c0 is select dept_no from depart;
    cursor c1(vofi number) is select apellido, salario, emp_no
                         from emple
                         where dept_no = vofi
                         order by dept_no, apellido;
    dept_ant emple.dept_no%type := 0;
    num_empl number(4) := 0;
    sum_sal number(9,2) := 0;
    tot_sal number(9,2) := 0;
    tot_emple number(4) := 0;
begin

    for v0 in c0 loop

        for v1 in c1 (v0.dept_no) loop

            if dept_ant = 0 then
                dept_ant := v0.dept_no;
            end if;

            if dept_ant <> v0.dept_no then
                dbms_output.put_line('****Dept: ' || dept_ant || '. Num empleados: ' || num_empl || '. Sum salarios: ' || sum_sal || '€.****');
                tot_sal := tot_sal + sum_sal;
                tot_emple := tot_emple + num_empl;
                sum_sal := 0;
                num_empl := 0;
                dept_ant := v0.dept_no;
            end if;

            dbms_output.put_line('Cod: ' || v1.emp_no || '. Apellido: ' || v1.apellido || '. Salario: ' || v1.salario || '€.');

            sum_sal := sum_sal + v1.salario;
            num_empl := num_empl + 1;

        end loop;

    end loop;

    dbms_output.put_line('****Dept: ' || dept_ant || '. Num empleados: ' || num_empl || '. Sum salarios: ' || sum_sal || '€.****');
    tot_sal := tot_sal + sum_sal;
    tot_emple := tot_emple + num_empl;

    dbms_output.put_line('NUMERO TOTAL DE EMPLEADOS: ' || tot_emple || '. TOTAL SALARIOS: ' || tot_sal || '€.');

end;

/*Ejercicio complementario 4*/

create or replace procedure menos_salario
as
    cursor c0 is select oficio from emple;

    cursor c1 (vofi varchar2) is select *
                                from (select apellido, oficio, salario
                                    from emple
                                    where oficio = vofi
                                    order by oficio, salario)
                                where rownum <= 2;

    vdat c1%rowtype;
    voficio emple.oficio%type := '*';
    cont number (4);

begin

    for v0 in c0 loop
        for v1 in c1(v0.oficio) loop
            
        end loop;
    end loop;

    open c1;

    fetch c1 into vdat;

    while c1%found loop
        if voficio <> vdat.oficio then
            voficio := vdat.oficio;
            cont := 0;
        end if;

        if cont < 2 then
            dbms_output.put_line('Oficio: ' || vdat.oficio || '. Apellido: ' || vdat.apellido || '. Salario: '|| vdat.salario);
            cont := cont + 1;  
        end if;

        fetch c1 into vdat;
  
    end loop;

end;