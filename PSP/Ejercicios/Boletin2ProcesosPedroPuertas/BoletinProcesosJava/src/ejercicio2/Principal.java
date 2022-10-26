/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Metemos en un array de String los comandos a ejecutar
        String[] comandos = {"java", "-jar", "Ejercicio1.jar"};
        
        ProcessBuilder pb = new ProcessBuilder(comandos);
        Process p;
        BufferedReader br;
        InputStream is;
        String linea;
        
        try{
            
            /*A través del método directory de ProcessBuilder indicamos cual es la carpeta
            * en la que se encuentra nuestro Jar para poder ejecutarlo
            */
            pb.directory(new File("/home/alumno/Documentos/Pedro Puertas/2DAM/PSP/Ejercicios/"
                    + "Boletin2ProcesosPedroPuertas/BoletinProcesosJava/src/Jars"));
            
            //Iniciamos el proceso
            p = pb.start();
            
            //Como en el anterior ejercicio cogemos el InputStream e instanciamos el BufferedReader
            is = p.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            
            //Con el bucle while leemos hasta que esté vacio el BufferedReader
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            //Cerramos el BufferedReader
            br.close();
        }catch(Exception e){
            System.out.println("Error en " + e);
        }
        
    }
    
}
