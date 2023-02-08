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
        conn = psycopg2.connect(
            host="localhost",
            database="basedatos_odoo",
            user="openpg",
            password="openpgpwd"
        )

        cursor = conn.cursor()

        # Borramos la tabla en caso de que exista
        cursor.execute("DROP TABLE IF EXISTS ejemplo_python;")

        # Creamos la tabla de ejemplo
        cursor.execute("""
        CREATE TABLE ejemplo_python (
            id serial PRIMARY KEY,
            nombre text,
            salario real,
            fecha_alta date
        );
        """)

        # Hacemos el insert de algunas filas
        cursor.execute("""
        INSERT INTO ejemplo_python (nombre, salario, fecha_alta)
        VALUES ('Juan', 30000, '2022-01-01'), ('Ana', 35000, '2022-02-01'), ('Pedro', 40000, '2022-03-01');
        """)

        print("Filas añadidas.\n")

        # Guardamos los cambios
        conn.commit()

        cursor.execute("SELECT * FROM ejemplo_python;")

        # Guardamos en la variable rows todas las filas seleccionadas
        rows = cursor.fetchall()

        for i in rows:
            print(i)

        cursor.execute("DELETE FROM ejemplo_python WHERE ID = 1;")
        cursor.execute("DELETE FROM ejemplo_python WHERE ID = 2;")

        print("\nFilas borradas.\n")

        # Guardamos los cambios
        conn.commit()

        # Hacemos el select de las filas y mostramos con el bucle for
        cursor.execute("SELECT * FROM ejemplo_python;")

        rows = cursor.fetchall()

        for i in rows:
            print(i)

        # Cerramos la conexión
        conn.close()

        break

    elif lectura == 2:
        conn = mariadb.connect(
            host="localhost",
            user="root",
            password="usuario",
            database="reportes"
        )

        cursor = conn.cursor()

        # Borramos la tabla si existe
        cursor.execute("DROP TABLE IF EXISTS ejemplo_python")

        # Creamos la tabla
        cursor.execute("""
        CREATE TABLE ejemplo_python (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre TEXT,
            salario FLOAT,
            fecha_alta DATE
        );
        """)

        # Insertamos datos
        cursor.execute("""
        INSERT INTO ejemplo_python (nombre, salario, fecha_alta)
        VALUES ('Juan', 30000, '2022-01-01'), ('Ana', 35000, '2022-02-01'), ('Pedro', 40000, '2022-03-01');
        """)

        print("Filas añadidas.\n")

        # Guardamos los cambios
        conn.commit()

        # Hacemos el select para mostrar los datos
        cursor.execute("SELECT * FROM ejemplo_python")

        # Mostramos las filas por pantalla
        rows = cursor.fetchall()
        for i in rows:
            print(i)

        # Borramos filas
        cursor.execute("DELETE FROM ejemplo_python WHERE ID = 1")
        cursor.execute("DELETE FROM ejemplo_python WHERE ID = 2")

        print("\nFilas borradas.\n")

        # Guardamos los cambios
        conn.commit()

        # Mostramos todas las filas restantes
        cursor.execute("SELECT * FROM ejemplo_python")
        rows = cursor.fetchall()
        for i in rows:
            print(i)

        # Cerramos la conexión
        conn.close()

        break

    elif lectura == 3:

        # Creamos la conexión en memoria
        conn = sqlite3.connect(':memory:')
        cursor = conn.cursor()

        # Creamos la tabla
        cursor.execute('''CREATE TABLE IF NOT EXISTS ejemplo (id INTEGER PRIMARY KEY, nombre TEXT)''')

        # Insertamos algunos datos
        cursor.execute("INSERT INTO ejemplo (nombre) VALUES ('Pedro'), ('Alejandro'), ('José'), ('Natalia')")

        conn.commit()

        print("Filas añadidas.\n")

        # Hacemos el select de las filas
        cursor.execute("SELECT * FROM ejemplo")

        # Las guardamos en rows y las mostramos con el bucle for
        rows = cursor.fetchall()

        for i in rows:
            print(i)

        # Borramos algunas filas
        cursor.execute("DELETE FROM ejemplo WHERE id = 1")
        cursor.execute("DELETE FROM ejemplo WHERE id = 2")

        print("\nFilas borradas.\n")

        # Hacemos el select y las mostramos con el for
        cursor.execute("SELECT * FROM ejemplo")

        rows = cursor.fetchall()

        for i in rows:
            print(i)

        conn.close()

        break

    else:
        print("Seleccione una opción correcta:")
        lectura = input()
        lectura = int(lectura)
