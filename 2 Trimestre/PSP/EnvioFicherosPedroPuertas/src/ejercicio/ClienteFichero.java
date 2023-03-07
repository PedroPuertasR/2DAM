/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author pedro
 */
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteFichero {

    public static void main(String[] args) {

        ClienteFichero ficheroCliente = new ClienteFichero();
        ficheroCliente.pide("/home/alumno/Documentos/hola.txt", "localhost", 6000);
    }

    /*Este método pide la ruta del fichero, el servidor y el puerto de este.
    * Con todo esto crearemos un FileOutputStream donde instanciaremos la copia
    * del fichero y mientras recibamos datos del fichero original seguiremos
    * copiando el archivo
    */
    public void pide(String path, String servidor, int puerto) {
        int numBytes = 0;
        try {

            Socket cliente = new Socket(servidor, puerto);
            ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());

            MensajeDameFichero mensaje = new MensajeDameFichero();
            mensaje.nombreFichero = path;
            System.out.println("Fichero solicitado por el cliente: " + mensaje.nombreFichero);

            System.out.println("********************************************************");
            salida.writeObject(mensaje);
            FileOutputStream copia = new FileOutputStream(mensaje.nombreFichero
                    + "_copia");

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            MensajeTomaFichero mensajeRecibido;
            
            Object aux;
            //Mientras no sea el último mensaje estaremos en el do while
            do {
                aux = entrada.readObject();

                /*Si al leer el objeto de entrada es una instancia de 
                * MensajeTomaFichero realiza lo siguiente:
                 */
                if (aux instanceof MensajeTomaFichero) {

                    //Instanciamos mensajeRecibido con nuestro objecto auxiliar
                    mensajeRecibido = (MensajeTomaFichero) aux;

                    //Mostramos el texto que hay dentro del fichero
                    System.out.print(new String(mensajeRecibido.contenidoFichero, 0,
                            mensajeRecibido.bytesValidos));
                    copia.write(mensajeRecibido.contenidoFichero, 0,
                            mensajeRecibido.bytesValidos);
                    numBytes = numBytes + mensajeRecibido.bytesValidos;
                } else {

                    System.err.println("Mensaje no esperado "
                            + aux.getClass().getName());
                    break;
                }
            } while (!mensajeRecibido.ultimoMensaje);
            System.out.println();
            System.out.println();
            System.out.println("Fichero copiado en " + mensaje.nombreFichero + "_copia\n"
                    + "Total de bytes copiados: " + numBytes);
            
            //Cerramos flujos y sockets
            copia.close();
            entrada.close();
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
