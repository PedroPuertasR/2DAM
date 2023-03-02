package Ejercicio1_ENVIO_OBJ_PERSONA;

import java.io.*;
import java.net.*;

public class Client {
    /**
     * Cliente TCP
     */
    public static void main(String[] args) throws IOException {
        try {
            Socket localConn = new Socket("192.168.8.11", 6000);
            
            System.out.println("Conexión realizada.");
            
            // Recibimos datos del server
            ObjectInputStream in = new ObjectInputStream(localConn.getInputStream());
            Persona p = (Persona) in.readObject();
            
            System.out.println("Recibido el siguiente objeto: " + p);
            
            p.setEdad(25);
            System.out.println("Realizados los siguientes cambios: " + p);
            
            ObjectOutputStream out = new ObjectOutputStream(localConn.getOutputStream());
            out.writeObject(p);
           
            out.close();
            in.close();
            localConn.close();
        } catch (IOException ex) {
            System.out.println("ERROR: Un error IO ha ocurrido en el cliente.");
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: Un error ClassNotFound ha ocurrido en el cliente.");
        }
    }
}