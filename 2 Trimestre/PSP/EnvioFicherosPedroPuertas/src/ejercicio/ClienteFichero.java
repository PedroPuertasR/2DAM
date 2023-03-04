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

        ClienteFichero objClienteFichero = new ClienteFichero();
        objClienteFichero.pide("D:/Trabajo/hola.txt", "localhost", 6000);
    }

    public void pide(String path, String servidor, int puerto) {
        int numeroBytes = 0;
        try {

            Socket socketCliente = new Socket(servidor, puerto);
            ObjectOutputStream flujoSalida = new ObjectOutputStream(socketCliente.getOutputStream());
            MensajeDameFichero mensaje = new MensajeDameFichero();
            mensaje.nombreFichero = path;
            System.out.println("Fichero solicitado por el cliente " + mensaje.nombreFichero);

            System.out.println("********************************************************");
            flujoSalida.writeObject(mensaje);
            FileOutputStream ficheroCopia = new FileOutputStream(mensaje.nombreFichero
                    + "_copia");

            ObjectInputStream flujoEntrada = new ObjectInputStream(socketCliente.getInputStream());
            MensajeTomaFichero mensajeRecibido;
            Object mensajeAux;
            do {
                mensajeAux = flujoEntrada.readObject();

                if (mensajeAux instanceof MensajeTomaFichero) {

                    mensajeRecibido = (MensajeTomaFichero) mensajeAux;

                    System.out.print(new String(mensajeRecibido.contenidoFichero, 0,
                            mensajeRecibido.bytesValidos));
                    ficheroCopia.write(mensajeRecibido.contenidoFichero, 0,
                            mensajeRecibido.bytesValidos);
                    numeroBytes = numeroBytes + mensajeRecibido.bytesValidos;
                } else {

                    System.err.println("Mensaje no esperado "
                            + mensajeAux.getClass().getName());
                    break;
                }
            } while (!mensajeRecibido.ultimoMensaje);
            System.out.println();
            System.out.println();
            System.out.println("Fichero copiado en " + mensaje.nombreFichero + "_copia"
                    + "Se han copiado un total de " + numeroBytes + " Bytes");
            ficheroCopia.close();
            flujoEntrada.close();
            socketCliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
