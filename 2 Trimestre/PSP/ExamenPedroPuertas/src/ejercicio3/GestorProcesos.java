package ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class GestorProcesos extends Thread {
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public GestorProcesos(Socket socket) throws IOException {
        this.socket = socket;
        // Crea el flujo de entrada para recibir los datos del cliente
        is = socket.getInputStream();
        // Crea el flujo de salida para enviar los datos al cliente
        os = socket.getOutputStream();
    }

    @Override
    public void run() {
        try {
            System.out.println("(Servidor) Proceso iniciado");
            realizarProceso();
            System.out.println("(Servidor) Proceso finalizado");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra el socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void realizarProceso() throws IOException {
        // Recibe el número aleatorio enviado por el cliente
        Random r = new Random();
        int numAleatorio = (int) r.nextInt(1000);
        System.out.println("(Servidor) El cliente ha enviado el número aleatorio: " + numAleatorio);

        // Espera tantos segundos como indique el número aleatorio
        System.out.println("(Servidor) Esperando " + numAleatorio + " segundos...");
        try {
            Thread.sleep(numAleatorio * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Envía el número aleatorio de vuelta al cliente
        os.write(("" + numAleatorio).getBytes());
    }
}
