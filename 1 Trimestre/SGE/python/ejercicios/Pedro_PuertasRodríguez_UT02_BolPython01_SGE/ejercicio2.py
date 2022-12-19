if __name__ == '__main__':
    limite = 10
    contador = 0
    numero = 0

    #Con este while sumaremos números hasta que lleguemos a 10 veces.
    #Esto gracias al contador que hemos declarado anteriormente

    while contador < limite:
        numero += int(input("Introduzca un número: "))
        contador += 1

    #Realizamos la media con el limite (que en nuestro caso es 10) y la
    #suma de los números
    media = numero / limite

    #Mostramos por pantalla
    print("La media es: %.2f" % (media))