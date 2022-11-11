import csv

def leer():

    lista = []

    with open('datos.csv') as csv_file:
        lectura = csv.reader(csv_file, delimiter=";")

        for row in lectura:
            lista.append(row)

    return lista

def mostrar(lista):

    for row in lista:
        print(row, end="\n")

def eleccion():

    print("1. Nombre")
    print("2. Edad")
    print("3. Sexo")
    print("4. Salario")
    print("5. Profesión")

    orden = input("Indique el orden deseado: ")

    return orden

def ordenar(lista, orden):

    if orden == 1:
        lista.sort(key=(lambda row: row[0]))
    elif orden == 2:
        lista.sort(key=(lambda row: row[1]))
    elif orden == 3:
        lista.sort(key=(lambda row: row[2]))
    elif orden == 4:
        lista.sort(key=(lambda row: row[3]))
    else:
        lista.sort(key=(lambda row: row[4]))

    return lista

if __name__ == '__main__':

    lista = leer()

    print(lista)

    orden = eleccion()

    lista = ordenar(leer(), orden)

    mostrar(lista)