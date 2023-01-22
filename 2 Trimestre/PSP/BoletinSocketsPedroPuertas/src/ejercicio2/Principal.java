/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) {
        try {
            //Instanciamos las URL
            URL url1 = new URL("https://www.youtube.com/");
            URL url2 = new URL("https", "youtube", "/watch?v=bl_Jy7Q7l7s");
            URL url3 = new URL("https", "youtube", "/watch?v=oGX59A28QQg");
            URL url4 = new URL(url1, "/watch?v=bl_Jy7Q7l7s");

            //Visualizamos cada una de ellas
            visualizar(url1);
            visualizar(url2);
            visualizar(url3);
            visualizar(url4);

        } catch (MalformedURLException ex) {
            System.out.println("Error al crear la URL.");
        }
    }

    //Con este método visualizamos toda la información de la URL
    private static void visualizar(URL url) {
        System.out.println("------------------------------------------");
        System.out.println(url.toString());
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getUserInfo());
        System.out.println(url.getPath());
        System.out.println(url.getAuthority());
        System.out.println(url.getQuery());
        System.out.println(url.getDefaultPort());
    }
}
