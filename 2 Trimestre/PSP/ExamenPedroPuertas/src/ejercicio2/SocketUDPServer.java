/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author alumno
 */
public class SocketUDPServer {
    
    private final static int MAX_BYTES = 2048;
    private final static String COD_TEXTO = "UTF-8";

    public static void main(String[] args) {
        
        String host = "localhost";
        int puertoRec = 12345;
        int puertoEnv = 45678;
        
        System.out.println("Estableciendo parámetros de conexión.");
        
        try {
            System.out.println("Creando socket");
            
            //Creamos el DatagramSocket de envio
            DatagramSocket envio = new DatagramSocket();
            String mensaje = "Mensaje enviado desde el servidor por Pedro Puertas";
            
            InetAddress ip = InetAddress.getByName(host);
            byte[] b = mensaje.getBytes(COD_TEXTO);

            //Creamos un DatagramPacket para indicar el mensaje, longitud del array y puerto
            DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length, ip, puertoEnv);
            //Conectamos con el cliente
            envio.connect(ip, puertoEnv);

            System.out.println("Enviando datagrama...");

            //Enviamos el paquete y cerramos el socket de envio
            envio.send(paqueteEnviado);
            envio.close();
            
            System.out.println("Recibiendo datagrama...");
            
            //Creamos un DatagramSocket para recibir un mensaje del cliente
            DatagramSocket recib = new DatagramSocket(puertoRec, ip);
            
            byte[] datosRecibidos = new byte[MAX_BYTES];
            
            //Creamos un DatagramPacket que recogerá el mensaje gracias al array
            DatagramPacket rec = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            
            //Esperamos hasta recibir el mensaje
            recib.receive(rec);
            
            //Lo metemos en un string indicando la longitud y tipo de texto y lo mostramos
            String mensajeRec = new String(rec.getData(), 0, rec.getLength(), COD_TEXTO);
            
            System.out.println("Mensaje recibido: " + mensajeRec);
            
            System.out.println("Cerrando socket...");
            
            //Cerramos el socket que recibe
            recib.close();
            
            System.out.println("Socket cerrado.");
            
        } catch (SocketException ex) {
            System.out.println("Excepción de socket");
            ex.printStackTrace();
           
        } catch (IOException ex) {
            System.out.println("Excepción de E/S");
            ex.printStackTrace();
        }
    }
    
}
