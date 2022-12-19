import pygame


class Jugador(pygame.sprite.Sprite):
    def __init__(self, x, y, dimen):
        super().__init__()
        #Indicamos la foto del jugador
        self.image = pygame.image.load("imagenes/jugador.png")
        #Transformamos la imagen para adaptarla a la pantalla
        self.image = pygame.transform.scale(self.image, dimen)
        self.rect = self.image.get_rect()
        self.rect.center = [x, y]

    #Controles para el jugador, se le pasa la tecla para subir y la de bajar por parámetro
    def update(self, teclaUP, teclaDOWN):
        velo = 5

        #Instanciamos una tecla para utilizarla más tarde en nuestras condiciones
        tecla = pygame.key.get_pressed()

        #Condiciones para que el jugador no salga de la pantalla
        if tecla[teclaUP] and self.rect.y > 0:
            self.rect.y -= velo
        elif tecla[teclaDOWN] and self.rect.y < 500:
            self.rect.y += velo

    #Método para reiniciar la posición del jugador
    def reset(self, y):
        self.rect.y = y
