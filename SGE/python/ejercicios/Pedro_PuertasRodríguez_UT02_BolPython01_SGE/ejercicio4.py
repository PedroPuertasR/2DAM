import csv


#Con esta def guardaremos en un archivo csv la lista que le pasemos
#por parámetro. Esto gracias al writer de csv
def escribir(lista):
    with open('./datos.csv', 'w', newline='') as csvfile:
        writer = csv.writer(csvfile, delimiter=' ')

        writer.writerows(lista)


#Con esta def leeremos el archivo que hemos creado con el escribir
#y lo almacenaremos en una lista, la cual devolveremos
def leer():
    with open('./datos.csv', newline='') as csvfile:
        lector = csv.reader(csvfile, delimiter=' ')

        lista = []

        #Por cada linea del lector se introducirá una fila en la lista
        for row in lector:
            lista.append(row)

    return lista


#Con esta def mostraremos un índice al usuario para que elija el orden de la lista.
#Retornamos la elección del usuario después de la lectura por teclado.
def eleccion():
    print("1. Nombre")
    print("2. Sexo")
    print("3. Edad")
    print("4. Salario")
    print("5. Profesión")

    orden = int(input("Indique el orden deseado: "))

    return orden


#Con esta def ordenaremos dependiendo de la elección del usuario. Podemos coger la lista
#y con el método sort ordenarla por la fila elegida gracias a los lambda. Más tarde
#devolvemos la lista ordenada
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

    #Lista con datos preparada para ser insertada en el archivo
    #lista = [['María', 'Mujer', '20', '1800', 'Escritora'],
    #         ['Pedro', 'Hombre', '26', '1600', 'Programador'],
    #         ['Alvaro', 'Hombre', '22', '1200', 'Profesor'],
    #         ['Clara', 'Mujer', '21', '1650', 'Física']]

    #escribir(lista)

    #Guardamos en una variable la lectura de la lista para instanciarla
    lista = leer()

    #Guardamos en una variable la elección del usuario para ordenar la lista
    orden = eleccion()

    #Más tarde guardaremos en nuestra variable lista la lista ordenada tras indicarle
    #al método la lista y el orden
    lista = ordenar(lista, orden)

    #Mostramos por pantalla la lista ordenada con el bucle for
    for row in lista:
        print(row)
