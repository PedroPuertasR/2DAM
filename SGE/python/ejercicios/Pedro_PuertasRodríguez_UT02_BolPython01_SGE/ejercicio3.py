if __name__ == '__main__':

    #Leemos por teclado y lo pasamos a minúsculas para que no haya problemas
    cadena = input("Introduzca una cadena: ").lower()

    #Creamos un diccionario para desglosar nuestra cadena
    d = {}

    #Gracias al bucle for cogeremos cada letra de la cadena
    for c in cadena:
        #Con este if haremos una condición por la cual se sumará 1 a cada posición
        #del diccionario, el cual estará relacionado con la posición de las letras
        #de la cadena
        if c in d.keys():
            d[c] += 1
        else:
            #En caso de que el contador de la letra no se encuentre en el diccionario
            #todavía se igualará a 1 en su posición
            if c != " ":
                d[c] = 1

    #Con este bucle for mostraremos por pantalla cada letra con el número total de veces
    #que ha aparecido
    for i in d.keys():
        print(str(i) + ": " + str(d[i]))