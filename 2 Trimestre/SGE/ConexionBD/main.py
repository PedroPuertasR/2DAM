from builtins import print, input, int
import mariadb
import sqlite3
import psycopg2


print("Indique en que base de datos quiere realizar las gestiones:")
print("1. PostgreSQL\n2. MariaDB\n3. SQLite3")

lectura = input()
lectura = int(lectura)

while True:
    if lectura == 1:
        # Creamos la conexión
        conn = psycopg2.connect(
            host="localhost",
            database="bdpython",
            user="openpg",
            password="openpgpwd"
        )

        cursor = conn.cursor()

        # Borramos la tabla en caso de que exista
        cursor.execute("DROP TABLE IF EXISTS ejemplo_python;")

        # Creamos la tabla de ejemplo
        cursor.execute("""
        CREATE TABLE PEDROPUERTAS (
            id serial PRIMARY KEY,
            nombre varchar(50),
            salario real,
            fecha_alta date,
            inscrito boolean
        );
        """)

        # Hacemos el insert de algunas filas
        cursor.execute("""
        INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito)
        VALUES
            ('Juan', 5000, '2022-01-01', True),
            ('María', 6000, '2022-02-01', True),
            ('Pedro', 7000, '2022-03-01', False),
            ('Ana', 8000, '2022-04-01', True),
            ('Lucía', 9000, '2022-05-01', False);
        """)


        print("Filas añadidas.\n")

        # Guardamos los cambios
        conn.commit()

        cursor.execute("SELECT * FROM PEDROPUERTAS;")

        # Guardamos en la variable rows todas las filas seleccionadas
        rows = cursor.fetchall()

        for i in rows:
            print(i)

        cursor.execute("DELETE FROM PEDROPUERTAS WHERE ID = 1;")
        cursor.execute("DELETE FROM PEDROPUERTAS WHERE ID = 2;")

        print("\nFilas borradas.\n")

        # Guardamos los cambios
        conn.commit()

        # Hacemos el select de las filas y mostramos con el bucle for
        cursor.execute("SELECT * FROM PEDROPUERTAS;")

        rows = cursor.fetchall()

        for i in rows:
            print(i)

        # Cerramos la conexión
        conn.close()

        break

    elif lectura == 2:

        # Creamos la conexión
        conn = mariadb.connect(
            host="localhost",
            user="root",
            password="usuario",
            database="bdpython"
        )

        cursor = conn.cursor()

        # Borramos la tabla si existe
        cursor.execute("DROP TABLE IF EXISTS PEDROPUERTAS")

        # Creamos la tabla
        cursor.execute("""
        CREATE TABLE PEDROPUERTAS(
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre TEXT,
            salario FLOAT,
            fecha_alta DATE,
            inscrito BOOLEAN
        );
        """)

        # Insertamos datos
        cursor.execute("""
        INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito)
        VALUES
            ('Juan', 5000, '2022-01-01', True),
            ('María', 6000, '2022-02-01', True),
            ('Pedro', 7000, '2022-03-01', False),
            ('Ana', 8000, '2022-04-01', True),
            ('Lucía', 9000, '2022-05-01', False);
        """)


        print("Filas añadidas.\n")

        # Guardamos los cambios
        conn.commit()

        # Hacemos el select para mostrar los datos
        cursor.execute("SELECT * FROM PEDROPUERTAS")

        # Mostramos las filas por pantalla
        rows = cursor.fetchall()
        for i in rows:
            print(i)

        # Borramos filas
        cursor.execute("DELETE FROM PEDROPUERTAS WHERE ID = 1")
        cursor.execute("DELETE FROM PEDROPUERTAS WHERE ID = 2")

        print("\nFilas borradas.\n")

        # Guardamos los cambios
        conn.commit()

        # Mostramos todas las filas restantes
        cursor.execute("SELECT * FROM PEDROPUERTAS")
        rows = cursor.fetchall()
        for i in rows:
            print(i)

        # Cerramos la conexión
        conn.close()

        break

    elif lectura == 3:

        # Creamos la conexión en memoria
        conn = sqlite3.connect('bdpython.db')
        cursor = conn.cursor()

        # Creamos la tabla
        cursor.execute('''CREATE TABLE IF NOT EXISTS PEDROPUERTAS (id INTEGER PRIMARY KEY, nombre TEXT, 
        salario REAL, fecha_alta DATE, inscrito BOOLEAN)''')

        # Insertamos algunos datos
        cursor.execute(
            "INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito) "
            "VALUES ('Juan', 5000.0, '2022-01-01', 1)")
        cursor.execute(
            "INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito) "
            "VALUES ('Ana', 6000.0, '2022-02-01', 0)")
        cursor.execute(
            "INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito) "
            "VALUES ('Pedro', 7000.0, '2022-03-01', 1)")
        cursor.execute(
            "INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito) "
            "VALUES ('Sofia', 8000.0, '2022-04-01', 0)")
        cursor.execute(
            "INSERT INTO PEDROPUERTAS (nombre, salario, fecha_alta, inscrito) "
            "VALUES ('Lucas', 9000.0, '2022-05-01', 1)")
        conn.commit()

        print("Filas añadidas.\n")

        # Hacemos el select de las filas
        cursor.execute("SELECT * FROM PEDROPUERTAS")

        # Las guardamos en rows y las mostramos con el bucle for
        rows = cursor.fetchall()

        for i in rows:
            print(i)

        # Borramos algunas filas
        cursor.execute("DELETE FROM PEDROPUERTAS WHERE id = 1")
        cursor.execute("DELETE FROM PEDROPUERTAS WHERE id = 2")

        print("\nFilas borradas.\n")

        # Hacemos el select y las mostramos con el for
        cursor.execute("SELECT * FROM PEDROPUERTAS")

        rows = cursor.fetchall()

        for i in rows:
            print(i)

        conn.close()

        break

    else:
        print("Seleccione una opción correcta:")
        lectura = input()
        lectura = int(lectura)
