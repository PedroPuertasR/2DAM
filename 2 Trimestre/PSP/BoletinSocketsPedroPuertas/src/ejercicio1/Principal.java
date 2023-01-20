/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            InetAddress dir = InetAddress.getLocalHost();

            InetAddress google = InetAddress.getByName("www.google.es");

            InetAddress[] ips = InetAddress.getAllByName("www.google.com");

            for (int i = 0; i < ips.length; i++) {
                System.out.println("IP " + i + " de google: " + ips[i].getHostAddress());
            }

        } catch (UnknownHostException ex) {
            System.out.println("ERROR - Ha ocurrido un error al crear el objeto "
                    + "InetAddress.");
        }

    }
    
    public static void pruebaMetodos(InetAddress dir) throws UnknownHostException {
        System.out.println("----------pruebaMetodos----------");
        // Prueba de getByName y toString
        InetAddress d1 = InetAddress.getByName(dir.getHostName());
        System.out.println("Dirección original: " + dir.toString() 
                + " // Dirección nueva: " + d1.toString());
        
        // Prueba de getLocalHost
        System.out.println("Local host: " + InetAddress.getLocalHost());
        
        // Prueba de getHostName
        System.out.println("Host name: " + dir.getHostName());
        
        // Prueba de getHostAddress
        System.out.println("Host address: " + dir.getHostAddress());
        
        // Prueba de getCanonicalHostName
        System.out.println("Canonical Host Name: " + dir.getCanonicalHostName());
        System.out.println("--------------------------------");
    }

}