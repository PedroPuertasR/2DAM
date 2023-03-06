package ejercicio;

import java.io.*;
import java.net.*;

public class ServidorChat {
    static final int maxCon = 5;

    public static void main(String args[]) throws IOException {
        int PUERTO = 44444;
        //se crea un objeto ServerSocket que representa el servidor y se asocia al puerto definido anteriormente
        ServerSocket servidor = new ServerSocket(PUERTO);
        //se muestra un mensaje en consola para indicar que el servidor ha sido iniciado.
        System.out.println("Servidor iniciado...");
        //e crea un array de sockets que se utilizará para controlar las conexiones al servidor.
        Socket tabla[] = new Socket[maxCon];
        //se crea un objeto de la clase ComunHilos, que se utiliza para compartir información entre los hilos que manejan las conexiones de los clientes.
        ComunHilos comun = new ComunHilos(maxCon, 0, 0, tabla);
        //comienza un bucle while que se ejecuta mientras el número de conexiones actuales no ha alcanzado el límite máximo permitido.
        while (comun.getNumConexiones() < maxCon) {
            //Objeto Socket del cliente que se conecta al servidor.
            Socket socket = new Socket();
            //Se espera a que un cliente se conecte al servidor
            socket = servidor.accept();
            //Se añade el socket del cliente al array y se le asigna un índice en el array.
            comun.addTabla(socket, comun.getNumConexiones());
            //Se incrementa el número de conexiones actuales al servidor.
            comun.setNumconexionesActuales(comun.getNumconexionesActuales() + 1);
            //se incrementa el número total de conexiones al servidor.
            comun.setNumConexiones(comun.getNumConexiones() + 1);
            //se crea un nuevo objeto de la clase HiloServidorChat, que se encargará de manejar la conexión del cliente recién conectado
            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            //se inicia el hilo que manejará la conexión del cliente.
            hilo.start();
        }
        //se cierra el objeto ServerSocket para terminar el servidor después de que se han alcanzado el número máximo de conexiones permitidas
        servidor.close();
    }
}
