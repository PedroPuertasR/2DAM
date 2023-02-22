package ejercicio6_UDP_MSG_TECLADO;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDCliente {

    public static void main(String[] args) throws IOException {
        int port = 6000;
        InetAddress address = InetAddress.getByName("192.168.8.9");

        System.out.println("Introduce un mensaje para enviarlo al servidor:\n");
        byte[] msg = (new BufferedReader(new InputStreamReader(System.in)))
                        .readLine()
                        .getBytes();

        DatagramPacket send = new DatagramPacket(msg, msg.length, address, port);
        DatagramSocket socket = new DatagramSocket();

        
        
        socket.send(send);
        
        byte[] recibirMsg = new byte[1024];
        
        DatagramPacket msgRecibido = new DatagramPacket(recibirMsg, recibirMsg.length);
        
        socket.receive(msgRecibido);
        
        int apariciones = Integer.parseInt(new String(msgRecibido.getData()).trim());
        
        System.out.println("El número de apariciones de la letra 'a' es: " + apariciones);
        
        socket.close();
    }
}