
package ejercicio6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDServer{
    public static void main(String[] args) throws IOException {
        int numPuerto = 6000;
        
        System.out.println("Servidor Esperando Datagrama .......... ");

        try (DatagramSocket socketServidor = new DatagramSocket(numPuerto)) {
            
            byte[] buffer = new byte[1024];
            DatagramPacket recibirPaquete = new DatagramPacket(buffer, buffer.length);
            socketServidor.receive(recibirPaquete);
            String mensaje = new String(recibirPaquete.getData(), 0, recibirPaquete.getLength());
            
            int numeroDeA = 0;
            
            for (int i = 0; i < mensaje.length(); i++) {
                if (mensaje.charAt(i) == 'a') {
                    numeroDeA++;
                }
            }
            
            InetAddress direccionCliente = recibirPaquete.getAddress();
            int puertoCliente = recibirPaquete.getPort();
            byte[] enviarDatos = Integer.toString(numeroDeA).getBytes();
            
            DatagramPacket enviarPaquete = 
                    new DatagramPacket(enviarDatos, enviarDatos.length, direccionCliente, puertoCliente);
            
            socketServidor.send(enviarPaquete);
            
            socketServidor.close();
        }
    }
}
