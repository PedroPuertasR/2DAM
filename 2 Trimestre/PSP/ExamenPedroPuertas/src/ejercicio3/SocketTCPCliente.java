package ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPCliente {
    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;

    public SocketTCPCliente(String serverIP, int serverPort) {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws UnknownHostException, IOException {
        System.out.println("(Cliente) Estableciendo conexión con el servidor " 
                + serverIP + " en el puerto " + serverPort);
        socket = new Socket(serverIP, serverPort);
        System.out.println("(Cliente) Conexión establecida");

        is = socket.getInputStream();
    }

    public void stop() throws IOException {
        System.out.println("(Cliente) Cerrando conexiones...");
        is.close();
        socket.close();
        System.out.println("(Cliente) Conexiones cerradas");
    }

    public int recibirNumeroAleatorio() throws IOException {
        byte[] buffer = new byte[1024];
        int count = is.read(buffer);
        String respuesta = new String(buffer, 0, count);
        return Integer.parseInt(respuesta.trim());
    }
    
    public static void main(String[] args) {
        SocketTCPCliente server = new SocketTCPCliente("localhost",49171);
    }
}


