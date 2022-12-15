import pygame
from pygame import mixer
from jugador import Jugador
from pelota import Pelota
from marcador import Marcador


#Dimensiones de los jugadores y la pelota
dimen = (20, 100)
dimen_pelota = (40, 40)

pygame.init()

mixer.music.load("sonidos/background.wav")
mixer.music.set_volume(0.05)
mixer.music.play(-1)

choque = mixer.Sound("sonidos/bump.wav")
choque.set_volume(0.3)

score = mixer.Sound("sonidos/score.wav")
score.set_volume(0.05)

pantalla = pygame.display.set_mode([800, 600])
clock = pygame.time.Clock()
terminado = False

jugador_teclaUP = pygame.K_w
jugador_teclaDOWN = pygame.K_s
jugador2_teclaUP = pygame.K_UP
jugador2_teclaDOWN = pygame.K_DOWN

jugador_y = 250
jugador2_y = 250
jugador_x = 40
jugador2_x = 760

pelota_x = 400
pelota_y = 300

velo_y = 6
velo_x = 6

jugador = Jugador(jugador_x, jugador_y, dimen)
jugador2 = Jugador(jugador2_x, jugador2_y, dimen)
pelota = Pelota(pelota_x, pelota_y, dimen_pelota)


lista_jugadores = pygame.sprite.Group()
lista_pelota = pygame.sprite.Group()

lista_jugadores.add(jugador)
lista_jugadores.add(jugador2)
lista_pelota.add(pelota)

jugador_score = Marcador(300, 300)

while not terminado:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            terminado = True

    jugador_score.draw(pantalla, 30)

    colision = pygame.sprite.spritecollide(pelota, lista_jugadores, False)

    for coli in colision:
        choque.play()
        velo_x *= -1

    pantalla.fill([0, 0, 0])

    lista_jugadores.draw(pantalla)
    lista_pelota.draw(pantalla)

    if pelota.rect.y > 550 or pelota.rect.y < 10:
        velo_y *= -1

    if pelota.rect.x > 750:
        score.play()
        pelota.reset()
        velo_x *= -1
    elif pelota.rect.x < 10:
        score.play()
        pelota.reset()
        velo_x *= -1


    jugador.update(jugador_teclaUP, jugador_teclaDOWN)
    jugador2.update(jugador2_teclaUP, jugador2_teclaDOWN)
    pelota.update(velo_x, velo_y)

    pygame.display.flip()
    clock.tick(60)

pygame.quit()
