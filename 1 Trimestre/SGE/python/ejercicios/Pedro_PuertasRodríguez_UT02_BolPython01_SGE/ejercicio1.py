
if __name__ == '__main__':
    #Leemos por teclado la cadena
    cadena = input("Introduzca una cadena: ")

    #Leemos por teclado las letras que queremos intercambiar
    char1 = input("Introduzca una letra a reemplazar de la cadena: ")
    char2 = input("Introduzca la letra por la que sustituir: ")

    #Realizamos un replace en la cadena con las dos letras
    cadena = cadena.replace(char1, char2)

    #Mostramos por pantalla
    print(cadena)