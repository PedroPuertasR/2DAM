import csv


def escribir(lista):

    with open('./datos.csv', 'w', newline='') as csvfile:
        writer = csv.writer(csvfile, delimiter=' ')

        writer.writerows(lista)


def leer():
    with open('./datos.csv', newline='') as csvfile:
        lector = csv.reader(csvfile, delimiter=' ')

        lista = []

        for row in lector:
            lista.append(row)

    return lista


def eleccion():
    print("1. Nombre")
    print("2. Sexo")
    print("3. Edad")
    print("4. Salario")
    print("5. Profesión")

    orden = int(input("Indique el orden deseado: "))

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

    #lista = [['María', 'Mujer', '20', '1800', 'Escritora'],
    #         ['Pedro', 'Hombre', '26', '1600', 'Programador'],
    #         ['Alvaro', 'Hombre', '22', '1200', 'Profesor'],
    #         ['Clara', 'Mujer', '21', '1650', 'Física']]

    #escribir(lista)

    lista = leer()

    orden = eleccion()

    lista = ordenar(lista, orden)

    for row in lista:
        print(row)
