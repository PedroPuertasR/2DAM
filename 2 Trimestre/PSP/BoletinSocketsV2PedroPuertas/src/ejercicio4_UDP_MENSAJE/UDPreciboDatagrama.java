/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_UDP_MENSAJE;

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
public class UDPreciboDatagrama {

    private final static int MAX_BYTES = 2048;
    private final static String COD_TEXTO = "UTF-8";
    
    public static void main(String[] args) {
       
        try {
            InetAddress IPServidor = InetAddress.getByName("localhost");
            DatagramSocket clientSocket = new DatagramSocket(12345, IPServidor);
            byte[] datosRecibidos = new byte[MAX_BYTES];
            DatagramPacket paqueteRecibido = new DatagramPacket(datosRecibidos,
                    datosRecibidos.length);
            clientSocket.receive(paqueteRecibido);
            String mensaje = new String(paqueteRecibido.getData(), 0,
                    paqueteRecibido.getLength(), COD_TEXTO);
            System.out.println("Numero de bytes: " + paqueteRecibido.getLength());
            System.out.println("Contenido del paquete: " + mensaje);
            System.out.println("IP de origen: " + paqueteRecibido.getAddress().getHostAddress());
            System.out.println("Puerto de destino: " + paqueteRecibido.getPort());
            
        } catch (SocketException ex) {
            Logger.getLogger(UDPreciboDatagrama.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPreciboDatagrama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
