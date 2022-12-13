import pygame


class Jugador(pygame.sprite.Sprite):
    def __init__(self, x, y, dimen):
        super().__init__()
        self.image = pygame.image.load("imagenes/jugador.png")
        self.image = pygame.transform.scale(self.image, dimen)
        self.rect = self.image.get_rect()
        self.rect.center = [x, y]

    def update(self, teclaUP, teclaDOWN):
        velo = 3

        tecla = pygame.key.get_pressed()

        if tecla[teclaUP] and self.rect.y > 0:
            self.rect.y -= velo

        if tecla[teclaDOWN] and self.rect.y < 500:
            self.rect.y += velo
