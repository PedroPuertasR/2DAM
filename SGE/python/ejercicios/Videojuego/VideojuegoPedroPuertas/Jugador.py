import pyglet


class Jugador(pyglet.sprite.Sprite):
    def __init__(self, image, x=0, y=0, batch=None):
        super(Jugador, self).__init__(image, x, y, batch=batch)
        self.x = x
        self.y = y
        self.moverY = False
        self.moverYAbajo = False

    def update(self, dt):
        if self.moverY:
            self.y += 80
        if self.moverYAbajo:
            self.y -= 80