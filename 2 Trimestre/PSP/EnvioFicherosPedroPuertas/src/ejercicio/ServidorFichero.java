package ejercicio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pedro
 */
public class ServidorFichero {

    public static void main(String[] args) {
        ServidorFichero server = new ServidorFichero();
        server.escucha(6000);
    }

    /* Método que espera el acceso de un cliente y cuando entra comprueba
    * si el mensaje es una instancia de MensajeDameFichero. En caso afirmativo
    * muestra la ruta por pantalla y lo envia con un objectOutputStream del cliente
     */
    public void escucha(int puerto) {
        try {
            ServerSocket socketServidor = new ServerSocket(puerto);
            System.out.println("\tServidor esperando a cliente...");
            Socket cliente = socketServidor.accept();
            System.out.println("Cliente accediendo...");
            cliente.setSoLinger(true, 10);
            ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
            Object mensaje = flujoEntrada.readObject();

            if (mensaje instanceof MensajeDameFichero) {

                System.out.println("Servidor mostrando fichero solicitado y enviado "
                        + "de vuelta al cliente.");
                System.out.println("Ruta del archivo: " + ((MensajeDameFichero) mensaje).nombreFichero);
                enviaFichero(((MensajeDameFichero) mensaje).nombreFichero, new ObjectOutputStream(cliente.getOutputStream()));
            } else {
                System.err.println("Mensaje no esperado " + mensaje.getClass().getName());
            }

            //Cerrando cliente y server
            cliente.close();
            socketServidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Método que envia el fichero con un objectOutputStream instanciado con el
    * outputStream del cliente. Al que le tenemos que pasar el nombre del fichero
    * y el outputStream del cliente. 
     */
    private void enviaFichero(String fichero, ObjectOutputStream oos) {
        try {
            boolean enviadoUltimo = false;

            FileInputStream fis = new FileInputStream(fichero);

            MensajeTomaFichero mensaje = new MensajeTomaFichero();
            mensaje.nombreFichero = fichero;

            int leidos = fis.read(mensaje.contenidoFichero);

            //Mientras haya bytes que leer en el fileInputStream se mantiene el bucle
            while (leidos > -1) {

                //Instanciamos los bytesValidos con leidos
                mensaje.bytesValidos = leidos;

                /*En caso de que lo que quede en leidos sea menor que la longitud
                * máxima significa que es el último mensaje. Por lo que tenemos 
                * que poner nuestras variables boolean como tal.
                */
                if (leidos < MensajeTomaFichero.LONGITUD_MAXIMA) {
                    mensaje.ultimoMensaje = true;
                    enviadoUltimo = true;
                } else {
                    mensaje.ultimoMensaje = false;
                }

                //Escribimos en el objectOutputStream el mensaje
                oos.writeObject(mensaje);

                //En caso de que sea el último mensaje sale del bucle while
                if (mensaje.ultimoMensaje) {
                    break;
                }

                /*Instanciamos mensaje como MensajeTomaFichero y le indicamos 
                * que su nombre de fichero es nuestro fichero
                */
                mensaje = new MensajeTomaFichero();
                mensaje.nombreFichero = fichero;

                //Volvemos a leer los bytes de FileInputStream del mensaje
                leidos = fis.read(mensaje.contenidoFichero);
            }

            //Si es el ultimo mensaje escribimos en el ObjectOutputStream
            if (enviadoUltimo == false) {
                mensaje.ultimoMensaje = true;
                mensaje.bytesValidos = 0;
                oos.writeObject(mensaje);
            }

            //Cerramos el ObjectOutputStream
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
