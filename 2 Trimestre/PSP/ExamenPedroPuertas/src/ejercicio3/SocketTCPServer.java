package ejercicio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTCPServer {
    private ServerSocket serverSocket;
    private int puerto;

    public SocketTCPServer(int puerto) throws IOException {
        this.puerto = puerto;
        serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor a la escucha por el puerto:" + puerto);

        while (true) {
            System.out.println("(Servidor) Esperando conexión...");
            Socket socket = serverSocket.accept();
            System.out.println("(Servidor) Conexión establecida con el cliente " 
                    + socket.getInetAddress().getHostName());
            GestorProcesos gestor = new GestorProcesos(socket);
            gestor.start();
        }
    }

    public void stop() throws IOException {
        System.out.println("(Servidor) Cerrando conexión...");
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            SocketTCPServer server = new SocketTCPServer(49171);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
