import pygame


class Pelota(pygame.sprite.Sprite):
    def __init__(self, x, y, dimen):
        super().__init__()
        self.image = pygame.image.load("imagenes/pelota.png")
        self.image = pygame.transform.scale(self.image, dimen)
        self.image.convert()
        self.rect = self.image.get_rect()
        self.rect.x = x
        self.rect.y = y

    def update(self):
        velo_y = 10

        self.rect.y += velo_y

        if self.rect.y > 590 or self.rect.y < 10:
            velo_y *= -1

        if self.rect.x > 800:
            self.rect.x = 400
            self.rect.y = 300
