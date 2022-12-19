import pygame

white = (255, 255, 255)


class Marcador():
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.marcador = 0

    #Método para mostrar en pantalla el marcador
    def draw(self, surf, size):
        font_name = pygame.font.match_font('arial')
        text = str(self.marcador)

        font = pygame.font.Font(font_name, size)
        text_surface = font.render(text, True, white)
        text_rect = text_surface.get_rect()
        text_rect.midtop = (self.x, self.y)
        surf.blit(text_surface, text_rect)

    #Método para sumar uno a la puntuación al marcar
    def marcar(self):
        self.marcador += 1

    #Método para reiniciar el marcador
    def terminar(self):
        self.marcador = 0

