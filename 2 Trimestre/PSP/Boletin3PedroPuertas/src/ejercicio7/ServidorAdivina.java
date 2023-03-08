package ejercicio7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAdivina {

    public static void main(String args[]) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciado...");

        //Creamos un número aleatorio
        int numero = (int) (1 + 25 * Math.random());
        System.out.println("Número a adivinar: " + numero);

        //Creamos el objeto instanciandolo con el número
        ObjetoCompartido objeto = new ObjetoCompartido(numero);
        int id = 0;

        //Con este bucle mientras el servidor recoja una conexión se empezarán
        //los hilos
        while (true) {

            Socket jugador;

            jugador = servidor.accept();

            id++;
            HiloServidorAdivina hilo = new HiloServidorAdivina(jugador, objeto, id);
            hilo.start();
        }
    }
}