package ejercicio;

import java.io.*;
import java.net.*;

public class ServidorChat {
    static final int maxCon = 5;

    public static void main(String args[]) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        
        System.out.println("Servidor iniciado...");

        Socket tabla[] = new Socket[maxCon];
        
        /*Creamos un objeto de la clase ComunHilos, que se utiliza para compartir
        * información entre los hilos que manejan las conexiones de los clientes.
        */
        
        ComunHilos comun = new ComunHilos(maxCon, 0, 0, tabla);
        
        /*Este bucle while se ejecuta mientras el número de conexiones
        *actuales no ha alcanzado el límite máximo permitido.
        */
        while (comun.getNumConexiones() < maxCon) {
            
            Socket socket = new Socket();
            socket = servidor.accept();
            
            //Se añade el socket del cliente al array y se le asigna un índice en el array.
            comun.aniadirArray(socket, comun.getNumConexiones());
            //Se incrementa el número de conexiones actuales al servidor.
            comun.setNumconexionesActuales(comun.getNumconexionesActuales() + 1);
            //se incrementa el número total de conexiones al servidor.
            comun.setNumConexiones(comun.getNumConexiones() + 1);
            //se crea un nuevo objeto de la clase HiloServidorChat, que se encargará
            //de manejar la conexión del cliente recién conectado
            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            //se inicia el hilo que manejará la conexión del cliente.
            hilo.start();
        }
        //se cierra el objeto ServerSocket para terminar el servidor después de
        //que se han alcanzado el número máximo de conexiones permitidas
        servidor.close();
    }
}
