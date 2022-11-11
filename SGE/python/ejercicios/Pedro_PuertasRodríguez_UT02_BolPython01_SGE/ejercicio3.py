if __name__ == '__main__':
    cadena = input("Introduzca una cadena: ").lower()

    arr = {}

    for c in cadena:
        if c in arr.keys():
            arr[c] += 1
        else:
            if c != " ":
                arr[c] = 1

    for i in arr.keys():
        print(str(i) + ": " + str(arr[i]))