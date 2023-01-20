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
            URL url1 = new URL("https://www.youtube.com/");
            URL url2 = new URL("https", "youtube", "/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
            URL url3 = new URL("https", "youtube", 25565, "/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
            URL url4 = new URL(url1, "/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");

            Visualizar(url1);
            Visualizar(url2);
            Visualizar(url3);
            Visualizar(url4);

        } catch (MalformedURLException ex) {
            System.out.println("ERROR - Error al crear alguna URL.");
        }
    }

    private static void Visualizar(URL url) {
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
