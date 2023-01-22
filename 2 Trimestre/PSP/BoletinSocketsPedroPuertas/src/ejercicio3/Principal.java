/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) {
        try {
            //Instanciamos el URL y el InputStream de esta
            URL url = new URL("http://www.elaltonazo.es");
            InputStream lector = url.openStream();

            //Mostramos en pantalla sus bytes
            for (byte b : lector.readAllBytes())
                System.out.print((char) b);
        } catch (MalformedURLException ex) {
            System.out.println("ERROR - Excepción en la URL.");
        } catch (IOException ex) {
            System.out.println("ERROR - Excepción en la lectura de datos.");
        }
    }
    
}
