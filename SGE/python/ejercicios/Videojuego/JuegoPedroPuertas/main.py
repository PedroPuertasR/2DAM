import pygame
from jugador import Jugador
from pelota import Pelota


black = (0, 0, 0)

dimen = (20, 100)
dimen_pelota = (40, 40)

pygame.init()

pantalla = pygame.display.set_mode([800, 600])
clock = pygame.time.Clock()
terminado = False

jugador_teclaUP = pygame.K_w
jugador_teclaDOWN = pygame.K_s
jugador2_teclaUP = pygame.K_UP
jugador2_teclaDOWN = pygame.K_DOWN

jugador_y = 250
jugador2_y = 250
jugador_x = 20
jugador2_x = 780

pelota_x = 400
pelota_y = 300

jugador = Jugador(jugador_x, jugador_y, dimen)
jugador2 = Jugador(jugador2_x, jugador2_y, dimen)
pelota = Pelota(pelota_x, pelota_y, dimen_pelota)


lista_sprites = pygame.sprite.Group()
lista_sprites.add(jugador)
lista_sprites.add(jugador2)
lista_sprites.add(pelota)

while not terminado:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            terminado = True

    pantalla.fill(black)

    lista_sprites.draw(pantalla)

    jugador.update(jugador_teclaUP, jugador_teclaDOWN)
    jugador2.update(jugador2_teclaUP, jugador2_teclaDOWN)
    pelota.update()

    pygame.display.flip()
    clock.tick(60)

pygame.quit()