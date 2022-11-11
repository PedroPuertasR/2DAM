
if __name__ == '__main__':
    cadena = input("Introduzca una cadena: ")
    char1 = input("Introduzca una letra a reemplazar de la cadena: ")
    char2 = input("Introduzca la letra por la que sustituir: ")

    cadena = cadena.replace(char1, char2)

    print(cadena)