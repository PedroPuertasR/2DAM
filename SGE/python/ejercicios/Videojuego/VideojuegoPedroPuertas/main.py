import pyglet
import pymunk
from Jugador import Jugador


window = pyglet.window.Window(1280, 720, "Ping pong", resizable=False)

jugador_image = pyglet.image.load('jugador.png')
jugador_image.width = 35
jugador_image.height = 150

jugadorx = window.width/2
jugadory = window.height/2
jugador2y = window.height-50

jugador1 = Jugador(jugador_image, jugadorx, jugadory, None)
jugador2 = Jugador(jugador_image, jugadorx, jugador2y, None)


@window.event
def on_draw():
    window.clear()
    jugador1.draw()
    jugador2.draw()


@window.event
def on_key_pressed(symbol, modifiers):
    contador = 0
    contadorDos = 0

    if symbol == pyglet.key.W:
        if contador < 4:
            contador += 1
            jugador1.moverY = True

    elif symbol == pyglet.key.S:
        if contador > -5:
            contador -= 1
            jugador1.moverYAbajo = True

    elif symbol == pyglet.key.UP:
        if contadorDos < 4:
            contadorDos += 1
            jugador2.moverY = True

    elif symbol == pyglet.key.DOWN:
        if contadorDos > -5:
            contadorDos -= 1
            jugador2.moverYAbajo = True


@window.event
def on_key_release(symbol, modifiers):
    if symbol == pyglet.key.W:
        jugador1.moverY = False

    elif symbol == pyglet.key.S:
        jugador1.moverYAbajo = False

    elif symbol == pyglet.key.UP:
        jugador2.moverY = False

    elif symbol == pyglet.key.DOWN:
        jugador2.moverYAbajo = False


def update(dt):
    jugador1.update(dt)
    jugador2.update(dt)


if __name__ == "__main__":
    pyglet.app.run()
    pyglet.clock.schedule_interval(update, 1 / 60.0)