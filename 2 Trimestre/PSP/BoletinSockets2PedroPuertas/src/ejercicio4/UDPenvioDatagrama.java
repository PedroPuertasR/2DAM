package Ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPenvioDatagrama {

    private final static int MAX_BYTES = 2048;
    private final static String COD_TEXTO = "UTF-8";

    public static void main(String[] args) {
        
        String nomHost = "localhost";
        int numPuerto = 12345;
        try (DatagramSocket clientSocket = new DatagramSocket();) {
            String mensaje = "Enviando un saludo de Alvaro Díaz Barrios";
            
            
                InetAddress IPServidor = InetAddress.getByName(nomHost);
                byte[] b = mensaje.getBytes(COD_TEXTO);
                
                DatagramPacket paqueteEnviado = new DatagramPacket(b, b.length,IPServidor, numPuerto);
                clientSocket.connect(IPServidor, 12345);
                clientSocket.send(paqueteEnviado);
                clientSocket.close();
                
                
            
        } catch (SocketException ex) {
            System.out.println("Excepcion de socket");
            ex.printStackTrace();
           
        } catch (IOException ex) {
            System.out.println("Exception de E/S");
            ex.printStackTrace();
        }
    }
}
