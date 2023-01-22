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

    public static void main(String[] args) {
        
        try {
            // Obtenenmos la dirección IP del equipo
            InetAddress dir = InetAddress.getLocalHost();
            
            // Imprimimos el nombre/IP del equipo
            System.out.println("Nombre/IP: " + dir.toString());
            
            // Llamamos al método pruebaMetodos para imprimir información adicional
            pruebaMetodos(dir);
            
            // Obtenemos la dirección IP del sitio web 
            InetAddress google = InetAddress.getByName("www.google.es");
            // Imprimimos la dirección IP del sitio web
            System.out.println("IP de google: " + google.getHostAddress());
            
            System.out.println("--------------------------------");
            // Obtenemos todas las direcciones IP del sitio web
            InetAddress[] ips = InetAddress.getAllByName("www.google.com");
            
            for (int i = 0; i < ips.length; i++) {
                // Imprimimos la dirección ip actual
                System.out.println("IP " + i + " de google: " + ips[i].getHostAddress());
                // Llamamos al método pruebaMetodos para imprimir información adicional
                pruebaMetodos(ips[i]);
            }
            
        } catch (UnknownHostException ex) {
            System.out.println("Ha ocurrido un error al crear el objeto "
                    + "InetAddress.");
        }   
    }
    
    public static void pruebaMetodos(InetAddress dir) throws UnknownHostException {
        System.out.println("----------pruebaMetodos----------");
        
        // Creamos un nuevo objeto InetAddress a partir del nombre del host
        InetAddress d1 = InetAddress.getByName(dir.getHostName());
        // Imprimimos la dirección original y la dirección nueva
        System.out.println("Dirección original: " + dir.toString() 
                + " // Dirección nueva: " + d1.toString());
        
        // Mostramos la dirección IP del equipo local
        System.out.println("Local host: " + InetAddress.getLocalHost());
        
        // También el nombre del host
        System.out.println("Host name: " + dir.getHostName());
        
        // Imprimimos la dirección IP del host
        System.out.println("Host address: " + dir.getHostAddress());
        
        // Mostramos el nombre canónico del host
        System.out.println("Canonical Host Name: " + dir.getCanonicalHostName());
        System.out.println("--------------------------------");
    }

}