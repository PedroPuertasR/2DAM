package ejercicio7;

public class ObjetoCompartido {

    private int numero;
    private boolean acabo; 
    private int ganador;

    public ObjetoCompartido(int numero) {
        this.numero = numero;
        this.acabo = false;

    }

    public boolean acabado() {
        return acabo;
    }

    public int getGanador() {
        return ganador;
    }

    public synchronized String jugada(int jugador, int elegido) {
        String resultado = "";

        //Si el juego no ha acabado comprobamos el número elegido
        if (!acabado()) {
            if (elegido > numero) {
                resultado = "Numero menor que el escrito";
            }else if (elegido < numero) {
                resultado = "Numero mayor que el escrito";
            }else{
                resultado = "Jugador " + jugador + " ha adivinado el número: "
                        + numero;
                //Si adivina el número indicamos que se ha terminado el juego
                acabo = true;
                ganador = jugador;
            }
        } else {
            //Si el juego ha terminado indicamos el resultado
            resultado = "Jugador " + ganador + " ha adivinado el número: " 
                    + numero;
        }

        return resultado;
    }
}
