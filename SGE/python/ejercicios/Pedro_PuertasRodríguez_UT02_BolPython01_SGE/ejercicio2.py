if __name__ == '__main__':
    limite = 10
    contador = 0
    numero = 0

    while contador < limite:
        numero += int(input("Introduzca un número: "))
        contador += 1

    media = numero / limite

    print("La media es: %.2f" % (media))