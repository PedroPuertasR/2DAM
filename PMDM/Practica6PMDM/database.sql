create table tienda(
    id INTEGER NOT NULL PRIMARY KEY,
    direccion VARCHAR(100) NOT NULL,
    presupuesto DECIMAL NOT NULL
);

create table trabajador(
    id INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    dni VARCHAR(9) NOT NULL,
    fecha_cont DATE NOT NULL,
    salario DECIMAL NOT NULL,
    id_jefe INTEGER,
    usuario VARCHAR(30) NOT NULL,
    pass VARCHAR(30) NOT NULL,
    foto VARCHAR(30) NOT NULL,
    CONSTRAINT fk_trabajador_jefe FOREIGN KEY (id_jefe) REFERENCES trabajador(id)
);

create table editorial(
    id INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    cif VARCHAR(9) NOT NULL
);

create table categoria(
    id INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

create table libro(
    id INTEGER NOT NULL PRIMARY KEY,
    nombre VARCHAR (50) NOT NULL,
    editorial INTEGER NOT NULL,
    isbn VARCHAR (13) NOT NULL,
    fecha_pub DATE NOT NULL,
    precio DECIMAL NOT NULL,
    categoria INTEGER NOT NULL,
    tienda INTEGER NOT NULL,
    CONSTRAINT fk_libro_categoria FOREIGN KEY categoria REFERENCES categoria(id),
    CONSTRAINT fk_libro_editorial FOREIGN KEY editorial REFERENCES editorial(id),
    CONSTRAINT fk_libro_tienda FOREIGN KEY tienda REFERENCES tienda(id)
);