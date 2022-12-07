import pyglet


class Contador(pyglet.text.Label):
    __init__(self, text='', font_size=None, color=(255, 255, 255, 255), x=0, y=0, width=None, height=None, anchor_x='left', anchor_y='baseline', halign='left', multiline=False, dpi=None, batch=None, group=None)
        super(Contador, self).__init__(x, y, contar, batch=batch)
        self.x = x
        self.y = y
        self.contar = contar

    def sumar(self):
        self.text = self.contar + 1


