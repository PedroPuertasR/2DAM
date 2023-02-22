/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6_URL_ConexionDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author alumno
 */
public class Principal {

    public static void main(String[] args) throws MalformedURLException, IOException {

        // Creamos una nueva URL
        URL url = new URL("https://www.google.es");
        // Abrimos una conexión a la URL
        URLConnection conexion = url.openConnection();
        
        //La mostramos
        System.out.println("Dirección [getURL()]:" + conexion.getURL());
        
        //Obtenemos la fecha de última modificación del sitio web y la mostramos
        Date fecha = new Date(conexion.getLastModified());
        System.out.println("Fecha última modificación [getLastModified()]: " + fecha);
        
        //Obtenemos el tipo de contenido del sitio web y lo imprimimos
        System.out.println("Tipo de Contenido [getContentType()]: "
                + conexion.getContentType());
        
        //También imprimimos todos los campos de cabecera
        System.out.println("============================================ ");
        System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
        Map camposcabecera = conexion.getHeaderFields();
        
        //Gracias al iterator podemos recorrer el Map y mostrarlo
        Iterator it = camposcabecera.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        
        //Imprimimos los campos de cabecera
        System.out.println("============================================ ");
        System.out.println("CAMPOS 1 Y 4 DE CABECERA:");
        System.out.println("getHeaderField(1)=> "
                + conexion.getHeaderField(1));
        System.out.println("getHeaderField(4)=> "
                + conexion.getHeaderField(4));
        
        //Imprimimos por pantalla el contenido del sitio web
        System.out.println("============================================");
        System.out.println("CONTENIDO DE [url.getFile()]:" + url.getFile());

    }
    
}
