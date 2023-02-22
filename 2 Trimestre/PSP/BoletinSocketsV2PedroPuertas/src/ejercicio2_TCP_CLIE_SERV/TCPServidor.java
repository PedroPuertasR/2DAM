/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2_TCP_CLIE_SERV;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alumno
 */
public class TCPServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        int Puerto = 6000;
        
        ServerSocket Servidor = new ServerSocket(Puerto);
        
        System.out.println("Escuchando en " + Servidor.getLocalPort());
        
        Socket cliente1 = Servidor.accept();
        
        Servidor.close();
        cliente1.close();
        
    }
    
}
