package ejercicio7_UDP_MULTI;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCClient {

    public static void main(String[] args) {
        try {
            int port = 6000;
            InetAddress mcGroup = InetAddress.getByName("225.0.0.1");
            MulticastSocket socket = new MulticastSocket(port);
            byte[] buffer = new byte[2048];

            socket.joinGroup(mcGroup);

            while (true) {
                buffer = new byte[2048];
                DatagramPacket receive = new DatagramPacket(buffer, buffer.length);

                socket.receive(receive);
                String data = new String(receive.getData());
                if ("*".equals(data)) {
                    break;
                }
                System.out.println("Multicast: " + data);
            }
            
            socket.leaveGroup(mcGroup);
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}