import pyglet


class Contador(pyglet.text.Label):
    def __init__(self, label, x=0, y=0, batch=None):
        super(Contador, self).__init__(label, x, y, batch=batch)
        self.x = x
        self.y = y

    def sumar(self):
        self.text = self.text + 1