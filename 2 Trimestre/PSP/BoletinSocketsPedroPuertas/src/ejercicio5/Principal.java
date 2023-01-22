/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://localhost/2018/vernombre.php");
            
            // Abrimos una conexión a la URL
            URLConnection urlCon = url.openConnection();

            String cadena = "nombre=Juan&apellidos=Ramos Martín";
            
            // Obtenemos el flujo de salida para escribir la cadena
            OutputStream output = urlCon.getOutputStream();
            
            // Escribiendo la cadena al flujo de salida
            output.write(cadena.getBytes());
            
            // Cerramos el flujo de salida
            output.close();
            
            // Obtenemos el flujo de entrada para leer la respuesta del servidor
            InputStream input = urlCon.getInputStream();
            
            // Leemos el primer byte de la respuesta
            int i = input.read();

            // Bucle para leer la respuesta byte por byte
            while (i != -1) {
                // Imprimiendo el byte como un char
                System.out.print((char) i);
                // Leyendo el siguiente byte
                i = input.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
