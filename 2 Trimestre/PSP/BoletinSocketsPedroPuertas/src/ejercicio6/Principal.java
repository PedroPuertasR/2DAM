/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

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
        // Creamos el objeto URL y obtenemos una conexión
        URL url = new URL("https://www.google.es");
        URLConnection conexion = url.openConnection();
        
        System.out.println("Dirección [getURL()]:" + conexion.getURL());
        
        // Obtenemos la fecha de la última modificación de la conexión.
        Date fecha = new Date(conexion.getLastModified());
        System.out.println("Fecha última modificación [getLastModified()]: " + fecha);
        
        // Mostramos el tipo de contenido del archivo
        System.out.println("Tipo de Contenido [getContentType()]: "
                + conexion.getContentType());
        
        System.out.println("============================================ ");
        System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
        //USAMOS UNA ESTRUCTURA Map PARA RECUPERAR CABECERAS
        Map camposcabecera = conexion.getHeaderFields();
        Iterator it = camposcabecera.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        
        System.out.println("============================================ ");
        System.out.println("CAMPOS 1 Y 4 DE CABECERA:");
        System.out.println("getHeaderField(1)=> "
                + conexion.getHeaderField(1));
        System.out.println("getHeaderField(4)=> "
                + conexion.getHeaderField(4));

        System.out.println("============================================");
        System.out.println("CONTENIDO DE [url.getFile()]:" + url.getFile());
        BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
        
        String cadena;
        while ((cadena = pagina.readLine()) != null) {
            System.out.println(cadena);

        }
    }
    
}
