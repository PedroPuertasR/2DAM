def sumador(x, y):
    return x + y

def multiplicador(x, y):
    return x * y

if __name__ == '__main__':
    my_funcion = sumador
    print(my_funcion(2, 4))

    my_funcion = multiplicador
    print(my_funcion(2, 4))

    my_funcion = lambda x, y: x ** y
    print(my_funcion(2, 4))


