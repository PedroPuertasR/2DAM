/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) {
        try {
            //Instanciamos el URL
            URL url = new URL("http://www.elaltozano.es");

            // Abrimos una conexión a la URL
            URLConnection con = url.openConnection();

            // Obtenemos el flujo de entrada de la conexión
            InputStream lector = con.getInputStream();

            // Iteramos sobre los bytes leídos del flujo y los
            // convertimos a char para imprimirlos en pantalla
            for (byte b : lector.readAllBytes()) {
                System.out.print((char) b);
            }

        } catch (MalformedURLException ex) {
            System.out.println("ERROR - Excepción en la URL.");
        } catch (IOException ex) {
            System.out.println("ERROR - Excepción en el IS.");
        }
    }

}
