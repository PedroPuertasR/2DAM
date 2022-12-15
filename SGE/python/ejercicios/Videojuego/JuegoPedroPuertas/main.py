import pygame
from pygame import mixer
from jugador import Jugador
from pelota import Pelota
from marcador import Marcador

pygame.init()

#Dimensiones de los jugadores y la pelota
dimen = (20, 100)
dimen_pelota = (40, 40)

#Declaración de música y sonidos
mixer.music.load("sonidos/background.wav")
mixer.music.set_volume(0.05)
mixer.music.play(-1)

choque = mixer.Sound("sonidos/bump.wav")
choque.set_volume(0.3)

scoreSonido = mixer.Sound("sonidos/score.wav")
scoreSonido.set_volume(0.05)

#Declaración del tamaño, framerate y condición del bucle del juego principal
pantalla = pygame.display.set_mode([800, 600])
clock = pygame.time.Clock()
terminado = False

#Declaración de las teclas que usará cada jugador
jugador_teclaUP = pygame.K_w
jugador_teclaDOWN = pygame.K_s
jugador2_teclaUP = pygame.K_UP
jugador2_teclaDOWN = pygame.K_DOWN

#Declaración de las posiciones de los jugadores
jugador_y = 250
jugador2_y = 250
jugador_x = 40
jugador2_x = 760

#Declaración de la posición de la pelota
pelota_x = 400
pelota_y = 300

#Declaración de la velocidad de la pelota
velo_y = 6
velo_x = 6

#Instancias de los jugadores, la pelota y los grupos de sprites
jugador = Jugador(jugador_x, jugador_y, dimen)
jugador2 = Jugador(jugador2_x, jugador2_y, dimen)
pelota = Pelota(pelota_x, pelota_y, dimen_pelota)

lista_jugadores = pygame.sprite.Group()
lista_pelota = pygame.sprite.Group()

lista_jugadores.add(jugador)
lista_jugadores.add(jugador2)
lista_pelota.add(pelota)

#Instancias de los marcadores
score = Marcador(550, 0)
score2 = Marcador(250, 0)

#Declaración de los textos al finalizar el juego y la posición de estos
texto_ganador = "Ha ganado el jugador 1"
texto_ganador2 = "Ha ganado el jugador 2"
texto_fin = "Pulse espacio para reiniciar el juego"

fin_x = 400
fin_y = 150
fin_tecla = 200


#Método para mostrar en pantalla un texto
def draw(surf, size, text, x, y):
    font_name = pygame.font.match_font('arial')

    font = pygame.font.Font(font_name, size)
    text_surface = font.render(text, True, (255, 255, 255))
    text_rect = text_surface.get_rect()
    text_rect.midtop = (x, y)
    surf.blit(text_surface, text_rect)


#Programa principal
while not terminado:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            terminado = True
        if event.type == pygame.KEYDOWN:
            # En caso de que usemos la tecla espacio se reiniciará el juego
            if event.key == pygame.K_SPACE:
                score.terminar()
                score2.terminar()
                velo_x = 6
                velo_y = 6
                pelota.reset()
            # En caso de que usemos la tecla escape se terminará el juego
            if event.key == pygame.K_ESCAPE:
                terminado = True

    #Variable para guardar la colisión entre sprites
    colision = pygame.sprite.spritecollide(pelota, lista_jugadores, False)

    #Con este bucle le indicamos a colision lo que debe hacer al colisionar
    for coli in colision:
        choque.play()
        velo_x *= -1

    pantalla.fill([0, 0, 0])

    #Pintando listas de sprites y marcadores en pantalla
    lista_jugadores.draw(pantalla)
    lista_pelota.draw(pantalla)

    score.draw(pantalla, 40)
    score2.draw(pantalla, 40)

    #Condición para el rebote de la pelota en y
    if pelota.rect.y > 550 or pelota.rect.y < 10:
        velo_y *= -1

    #Condiciones para aumentar el marcador de cada jugador
    if pelota.rect.x > 750:
        scoreSonido.play()
        pelota.reset()
        velo_x *= -1
        score2.marcar()
    elif pelota.rect.x < 10:
        scoreSonido.play()
        pelota.reset()
        velo_x *= -1
        score.marcar()

    #Condiciones para terminar el juego
    if score2.marcador == 5:
        velo_y = 0
        velo_x = 0
        draw(pantalla, 40, texto_ganador, fin_x, fin_y)
        draw(pantalla, 40, texto_fin, fin_x, fin_tecla)
    elif score.marcador == 5:
        velo_y = 0
        velo_x = 0
        draw(pantalla, 40, texto_ganador2, fin_x, fin_y)
        draw(pantalla, 40, texto_fin, fin_x, fin_tecla)

    #Updates de los jugadores y la pelota
    jugador.update(jugador_teclaUP, jugador_teclaDOWN)
    jugador2.update(jugador2_teclaUP, jugador2_teclaDOWN)
    pelota.update(velo_x, velo_y)

    pygame.display.flip()
    clock.tick(60)

pygame.quit()