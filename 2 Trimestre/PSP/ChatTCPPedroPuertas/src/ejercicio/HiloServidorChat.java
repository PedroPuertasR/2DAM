package ejercicio;

import java.io.*;
import java.net.*;

public class HiloServidorChat extends Thread {
    DataInputStream entrada;
    Socket socket = null;
    ComunHilos comunHilo;
    
    /*Este es el constructor de la clase HiloServidorChat, que toma dos argumentos: 
    * un objeto Socket y un objeto ComunHilos. El constructor inicializa las 
    * variables de instancia socket y comunHilo y crea un objeto DataInputStream a partir 
    del InputStream del socket*/
    public HiloServidorChat(Socket s, ComunHilos comun) {
        this.socket = s;
        this.comunHilo = comun;
        try {
            //flujo para leer los mensajes introducidos
            entrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("ERROR DE E/S");
            e.printStackTrace();
        }
    }
    
    /*Este es el método run, que se ejecuta cuando se inicia el hilo. 
    * El método comienza imprimiendo el número actual de conexiones en la consola
    * y luego llama al método EnviarMensajesaTodos para enviar los mensajes a todos los 
    * clientes conectados. Luego, el método entra en un ciclo while que se ejecuta 
    * mientras la conexión está activa. Dentro del ciclo, el método lee el mensaje 
    * entrante del cliente, lo procesa y lo envía a todos los clientes conectados.
    * Si se recibe el carácter "*", el método disminuye el número de conexiones 
    * activas y sale del ciclo. Finalmente
    */
    public void run() {
        System.out.println("NUMERO DE CONEXIONES ACTUALES: " + comunHilo.getNumconexionesActuales());

        String texto = comunHilo.getMensajes();
        //enviamos todos los mensajes
        EnviarMensajesaTodos(texto);
        while (true) {
            String cadena = "";
            try {
                cadena = entrada.readUTF();
                if (cadena.trim().equals("*")) {
                    comunHilo.setNumconexionesActuales(comunHilo.getNumconexionesActuales() - 1);
                    System.out.println("NUMERO DE CONEXIONES ACTUALES: " + comunHilo.getNumconexionesActuales());
                    break;
                }
                comunHilo.setMensajes(comunHilo.getMensajes() + cadena + "\n");
                EnviarMensajesaTodos(comunHilo.getMensajes());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //método para enviar los mensajes de los clientes
    private void EnviarMensajesaTodos(String texto) {
        int i;
        // recorremos el array de sockets para enviar los mensajes
        for (i = 0; i < comunHilo.getNumConexiones(); i++) {
            Socket s1 = comunHilo.getElementoArray(i);
            if (!s1.isClosed()) {
                try {
                    DataOutputStream salida = new DataOutputStream(s1.getOutputStream());
                    salida.writeUTF(texto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
