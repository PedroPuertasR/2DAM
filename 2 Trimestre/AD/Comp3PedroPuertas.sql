-- Caso práctico 1

create view emplead as select emp_no, apellido, oficio, dnombre, loc
                       from emple, depart
                       where emple.dept_no = depart.dept_no;

create or replace trigger t1
instead of insert or update or delete on emplead
for each row
declare
    vdept depart.dept_no%type;
begin
    if deleting then

        delete from emple where emp_no = :old.emp_no;
        dbms_output.put_line('Empleado eliminado.');

    elsif inserting then

        select dept_no into vdept
        from depart
        where dnombre = :new.dnombre
              and loc = :new.loc;

        insert into emple (emp_no, apellido, oficio, dept_no) values (:new.emp_no, :new.apellido, :new.oficio, vdept);

    elsif updating('dnombre') then

        select dept_no into vdept 
        from depart
        where dnombre = :new.dnombre;

        update emple set dept_no = vdept where emp_no = :old.emp_no;

    elsif updating('oficio') then

        update emple set oficio = :new.oficio where emp_no = :old.emp_no;

    else

        raise_application_error(-20001, 'Error en la aplicación.');

    end if;
end;

-- Caso práctico 2

create table control_conexiones(
    usuario varchar2(50) primary key,
    momento date,
    evento varchar2(50)
);

create table control_eventos (
    usuario varchar2(20) primary key, 
    momento date, 
    evento varchar2(40)
);

create or replace trigger ctrl_conexiones
after logon
on database
begin
    insert into control_conexiones (usuario, momento, evento)values (ora_login_user, sysdate, ora_sysevent);
end;

create or replace trigger ctrl_eventos
after ddl
on database
begin
    insert into control_eventos (usuario, momento, evento) values (user, sysdate, ora_sysevent || '*' ||ora_dict_obj_name);
end;

-- Actividad complementaria 3

create view departam as select depart.dept_no, dnombre, loc, count(emp_no) tot_emple
                        from emple, depart
                        where emple.dept_no (+) =
                        depart.dept_no
                        group by depart.dept_no, dnombre, loc;

create or replace trigger t1
instead of insert or delete or update on departam
for each row
begin

    if inserting then

        insert into depart values (:new.dept_no, :new.dnombre, :new.loc);
        dbms_output.put_line('Departamento añadido.');

    elsif updating('loc') then

        update depart set loc = :new.loc where dept_no = :new.dept_no;
        dbms_output.put_line('Departamento actualizado.');

    elsif deleting then

        delete from depart where dept_no = :old.dept_no;
        dbms_output.put_line('Departamento borrado.');

    else

        raise_application_error(-20002, 'Error en la aplicación.');

    end if;

end;

insert into departam values (70, 'sdad', 'dsadas', 2);
update departam set loc = 'ccx' where dept_no = 70;
delete from departam where dept_no = 70;