package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class SocketUDPClient {

    private final static int MAX_BYTES = 2048;
    private final static String COD_TEXTO = "UTF-8";
    
    public static void main(String[] args) {
       
        String host = "localhost";
        int puertoEnv = 12345;
        int puertoRec = 45678;
        
        try {
            InetAddress ip = InetAddress.getByName(host);
            
            System.out.println("Creando socket...");
            
            //Creamos el DatagramSocket con el puerto asignado para recibir
            DatagramSocket recib = new DatagramSocket(puertoRec, ip);
            
            byte[] datosRecibidos = new byte[MAX_BYTES];
            
            //Creamos un DatagramPacket que recogerá el mensaje gracias al array
            DatagramPacket rec = new DatagramPacket(datosRecibidos, datosRecibidos.length);
            
            System.out.println("Recibiendo datagrama...");
            
            //Esperamos hasta recibir el mensaje
            recib.receive(rec);
            //Lo metemos en un string indicando la longitud y tipo de texto y lo mostramos
            String mensaje = new String(rec.getData(), 0, rec.getLength(), COD_TEXTO);
            
            System.out.println("Mensaje recibido: " + mensaje);
            
            //Creamos un nuevo DatagramSocket para enviar el mensaje al servidor
            DatagramSocket envio = new DatagramSocket();
            String mensajeEnv = "Mensaje enviado desde el cliente por Pedro Puertas";
            
            byte[] b = mensajeEnv.getBytes(COD_TEXTO);
            
            //Creamos un DatagramPacket para indicar el mensaje, longitud del array y puerto
            DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length, ip, puertoEnv);
            //Conectamos con el servidor
            envio.connect(ip, puertoEnv);

            System.out.println("Enviando datagrama...");

            //Enviamos el datagrama
            envio.send(paqueteEnviado);
            
            System.out.println("Cerrando socket...");
            
            //Cerramos el socket
            envio.close();
            
            System.out.println("Socket cerrado.");
           
        } catch (SocketException ex) {
            Logger.getLogger(SocketUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketUDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


