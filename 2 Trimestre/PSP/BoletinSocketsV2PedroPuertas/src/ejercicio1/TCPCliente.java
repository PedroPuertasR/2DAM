/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import ejercicio2.*;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author alumno
 */
public class TCPCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int puerto = 6000;
        
        Socket cliente = new Socket("localhost", puerto);
        
        System.out.println("Local Port:     " + cliente.getLocalPort());
        System.out.println("Remote Port:    " + cliente.getPort());
        System.out.println("Host/Address:   " + cliente.getLocalAddress());
        System.out.println("Remote Host:    " + cliente.getInetAddress().getHostName());
        System.out.println("Remote Address: " + cliente.getInetAddress().getHostAddress());
        
        cliente.close();

    }

}
