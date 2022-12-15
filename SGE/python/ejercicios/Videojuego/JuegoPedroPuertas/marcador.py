import pygame

white = (255, 255, 255)

class Marcador():
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.marcador = 0

    def draw(self, surf, size):
        font_name = pygame.font.match_font('arial')
        text = str(self.marcador)

        font = pygame.font.Font(font_name, size)
        text_surface = font.render(text, True, white)
        text_rect = text_surface.get_rect()
        text_rect.midtop = (self.x, self.y)
        surf.blit(text_surface, text_rect)


