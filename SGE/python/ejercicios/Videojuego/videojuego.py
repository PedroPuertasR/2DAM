import pyglet


class MyWindow(pyglet.window.Window):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.set_minimum_size(640, 480)
        self.set_maximum_size(1280,720)

        self.contador = 0
        self.contadorDos = 0

        ancho = 35
        alto = 150

        self.img = pyglet.image.load('jugador.png')
        self.img.width = ancho
        self.img.height = alto

        self.sprite = pyglet.sprite.Sprite(self.img, y= self.height/2)
        self.spriteDos = pyglet.sprite.Sprite(self.img, y= self.height/2, x= self.width/2)

    def on_draw(self):
        window.clear()
        self.sprite.draw()
        self.spriteDos.draw()

    def on_key_press(self, key, modifiers):
        if(key == pyglet.window.key.W):
            window.clear()
            if(self.contador < 4):
                self.contador += 1
                self.sprite.y += 80

        elif(key == pyglet.window.key.S):
            window.clear()
            if(self.contador > -5):
                self.contador -= 1
                self.sprite.y -= 80

        elif(key == pyglet.window.key.UP):
            window.clear()
            if(self.contadorDos < 4):
                self.contadorDos += 1
                self.spriteDos.y += 80

        elif (key == pyglet.window.key.DOWN):
            window.clear()
            if (self.contadorDos > -5):
                self.contadorDos -= 1
                self.spriteDos.y -= 80

if __name__ == "__main__":
    window = MyWindow(1280, 720, "Videojuego", resizable=False)
    pyglet.app.run()