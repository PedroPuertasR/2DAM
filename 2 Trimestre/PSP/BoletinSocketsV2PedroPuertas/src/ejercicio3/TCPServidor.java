/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
        int puerto = 6000;
        
        ServerSocket servidor = new ServerSocket(puerto);
        
        System.out.println("Esperando al cliente...");
        
        Socket cliente = servidor.accept();
        
        InputStream entrada = cliente.getInputStream();
        
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        System.out.println("Recibiendo el mensaje del cliente...");
        System.out.println(flujoEntrada.readUTF());
        
        OutputStream salida = cliente.getOutputStream();
        
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        
        System.out.println("Salida...");
        flujoSalida.writeUTF("Pedro Puertas");
        
        flujoEntrada.close();
        flujoSalida.close();
        entrada.close();
        salida.close();
        cliente.close();
        servidor.close();
    }
    
}