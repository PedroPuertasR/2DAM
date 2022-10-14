
	Descripci�n de las tablas:
	==========================

HABILIDADES
-----------
# COD_HA	CHAR(5)		C�digo Habilidad
  DESC_HA	VARCHAR2(30)	Descripci�n de Habilidad (O) (U)

CENTROS
-------
# COD_CE	CHAR(4)		C�digo del Centro
* DIRECTOR_CE	NUMBER(6)	Director del Centro
  NOMB_CE	VARCHAR2(30)	Nombre del Centro (O)
  DIRECC_CE	VARCHAR2(50)	Direcci�n del Centro (O)
  POBLAC_CE	VARCHAR2(15)	Poblaci�n del Centro (O)

DEPARTAMENTOS
-------------
# COD_DE	CHAR(5)		C�digo del Departamento
* DIRECTOR_DE	NUMBER(6)	Director del Departamento
* DEPTJEFE_DE	CHAR(5)		Departamento del que depende
* CENTRO_DE	CHAR(4)		Centro trabajo (O)
  NOMB_DE	VARCHAR2(40)	Nombre del Departamento (O)
  PRESUP_DE	NUMBER(11)	Presupuesto del Departamento (O)
  TIPODIR_DE	CHAR(1)		Tipo de Director del Departamento (O)

EMPLEADOS
---------
# COD_EM	NUMBER(6)	C�digo del Empleado
* DEPT_EM	CHAR(5)		Departamento del Empleado (O)
  EXTTEL_EM	CHAR(9)		Extensi�n telef�nica
  FECINC_EM	DATE		Fecha de incorporaci�n del Empleado (O)
  FECNAC_EM	DATE		Fecha de nacimiento del Empleado (O)
  DNI_EM	VARCHAR2(9)	DNI del Empleado (U)
  NOMB_EM	VARCHAR2(40)	Nombre del Empleado (O)
  NUMHIJ_EM	NUMBER(2)	N�mero de hijos del Empleado (O)
  SALARIO_EM	NUMBER(9)	Salario Anual del Empleado (O)

HIJOS
-----
#*PADRE_HI	NUMBER(6)	C�digo del Empleado
# NUMHIJ_HI	NUMBER(2)	N�mero del hijo del Empleado
  FECNAC_HI	DATE		Fecha de nacimiento del Hijo (O)
  NOMB_HI	VARCHAR2(40)	Nombre del Hijo (O)

HABIEMPL
-----------
#*CODHA_HE	CHAR(5)		C�digo de la Habilidad
#*CODEM_HE	NUMBER(6)	C�digo del Empleado


Nota: 
	# PRIMARY KEY
	* FOREIGN KEY
	(O) Obligatorio
	(U) �nico

************************************************************************
1.- Crea las tablas anteriores indicando las claves primarias, for�neas y las restricciones (O) y (U).

SQL>

************************************************************************
2.- Ejecuta las �rdenes del fichero "Datos.txt" con el comando START.

SQL>

************************************************************************

3.- A�ade las siguientes restricciones a la tabla departamentos:
	- Todos los campos num�ricos de la tabla son positivos.
	- El Tipo de Director es 'F' o 'P'.
 Si no pudieras a�adir alguna de las restricciones anteriores modifica los valores de las columnas correspondientes para a�adirlas.

SQL>


************************************************************************

4.-A�ade las siguientes restricciones a la tabla empleados:
	- Todos los nombres de los empleados deben estar en may�sculas.
	- Todos los empleados eran mayores de edad cuando se incorporaron.
 Si no pudieras a�adir alguna de las restricciones anteriores modifica los valores de las columnas correspondientes para a�adirlas.

SQL>

************************************************************************
5.- A�ade la columna NIVEL_HE NUMBER(2), a la tabla HABIEMPL con las siguientes restricciones:
	
	- Por defecto vale 5.
	- Valores v�lidos entre 1 y 10.

SQL>

************************************************************************
6.- Listar el c�digo y nombre de los empleados cuyo c�digo sea distinto de 1, 4, 6, 8 � 10.

SQL>

RESULTADO:

************************************************************************
7.- Listar el nombre de los empleados que no tienen extensi�n telef�nica.

SQL>

RESULTADO:

************************************************************************
8.- Listado del c�digo, nombre y presupuesto de los departamentos ordenado por criterio descendente de presupuesto anual.

SQL>

RESULTADO:

************************************************************************
9.- Listar el nombre del empleado y el nombre y fecha de nacimiento de su hijo/a para aquellos empleados con un �nico hijo. Ordenar por fecha de nacimiento de los hijos.

SQL>

RESULTADO:

************************************************************************
10.- Listar el nombre de los departamentos y del departamento del que dependen (s�lo para los departamentos dependientes).

SQL>

RESULTADO:

************************************************************************
11.- Listar el NIF, nombre del empleado y el nombre del dpto. al que se encuentra asignado ordenado por dpto. y dentro de cada dpto por el nombre de empleado.

SQL>

RESULTADO:

************************************************************************
12.- Listar el salario m�nimo, m�ximo y medio para cada dpto. indicando el c�digo y nombre del dpto. al que pertenece el dato.

SQL>

RESULTADO:

************************************************************************
13.- Listar el salario promedio de los empleados.(Mostrarlo en pesetas y en euros)

SQL>

RESULTADO:

************************************************************************
14.- Listar el nombre de los hijos del empleado que se apellida 'Correa'.

SQL>

RESULTADO:

************************************************************************
15.- Listar el nombre de los departamentos en los que la suma de los sueldos es igual o mayor al 25% del presupuesto.

SQL>

RESULTADO:

************************************************************************
16.- Listar los departamentos que tengan alg�n empleado que gane m�s de 500.000 ptas al mes. (Recuerda que el salario es anual).

SQL>

RESULTADO:

************************************************************************
17.- Para cada extensi�n telef�nica, hallar cu�ntos empleados la usan y el salario medio de �stos.

SQL>

RESULTADO:

************************************************************************
18.- Hallar el salario medio por departamento para aquellos departamentos cuyo salario m�ximo es inferior al salario medio de todos los empleados.

SQL>

RESULTADO:
************************************************************************
19.- Mostrar la habilidad que no tiene ningún empleado.

SQL>

RESULTADO:
************************************************************************
20.- Mostrar los nombres propios de los empleados que tienen al menos dos habilidades.

SQL>

RESULTADO:
************************************************************************

21.- Mostrar los apellidos del empleado con más habilidades.

SQL>

RESULTADO:
***************************************************************************
22.- Realiza un informe que muestre el nombre de cada departamento, nombre y salario de sus empleados y salario medio por departamento.

SQL>

RESULTADO:
***************************************************************************

23.- Realiza un informe que muestre por cada centro, el nombre de sus departamentos, nombre y salario de cada empleado y salario medio por departamento y centro.

SQL>

RESULTADO:




************************************************************************
24.- Crear la tabla TEMP(CODEMP, NOMDEPT, NOMEMP, SALEMP) cuyas columnas tienen el mismo tipo y tama�o las similares existentes en la BD. Insertar en dicha tabla el c�digo de empleado, nombre de dpto, nombre de empleado y salario de los empleados de los centros de MURCIA.

SQL>

RESULTADO:

************************************************************************
25.- Añadir la habilidad de fontanería a todos los empleados que no la tenían. Utiliza una única sentencia.

SQL>

RESULTADO:

************************************************************************
26.- Incrementar en un 10% los salarios de los empleados que ganen menos de 5.000.000 de ptas. Confirma la operación.

SQL>

RESULTADO:

************************************************************************

27.- Incrementar en un 5% los salarios de los empleados que dirigen al mismo tiempo un centro y un departamento. Utiliza INTERSECT.

SQL>

RESULTADO:
*************************************************************************
28.- Deshacer la operaci�n anterior.

SQL>

RESULTADO:
*************************************************************************
29.- Truncar la tabla DEPARTAMENTOS.

SQL>

RESULTADO:
************************************************************************
30.- Borrar la tabla HABILIDADES.

SQL>

RESULTADO:

************************************************************************
