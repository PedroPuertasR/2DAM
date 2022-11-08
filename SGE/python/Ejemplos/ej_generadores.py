import random as rdm

def generaleatorios(cantidad, maximo):
    cuenta = 0
    while cuenta < cantidad:
        cuenta += 1
        yield rdm.randint(0, maximo)

if __name__ == '__main__':
    generador = generaleatorios(20, 5)

    for g in generador:
        print(g)

    generador2 = generaleatorios(5, 100)

    for i in range(5):
        valor = next(generador2)
        print(valor)