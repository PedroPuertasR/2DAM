/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String carpeta, linea;
        Process p;
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){
            carpeta = System.getProperty("user.dir") + "\"Jars";
        }else{
            carpeta = System.getProperty("user.dir") + "\"\"Jars";
        }
        
        //Instanciamos el ProcessBuilder pasandole los comandos
        ProcessBuilder pb = new ProcessBuilder("java", "-jar",  "ejercicio12.jar", "Pedro");
        
        //Le indicamos al ProcessBuilder la carpeta en la que se encuentra el .jar
        pb.directory(new File(carpeta));
        
        try{
            //Iniciamos el proceso
            p = pb.start();
            
            //Instanciamos el BufferedReader con el inputStream del proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            //Leemos con el buffer hasta que sea nulo
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            br.close();
        }catch(IOException e){
            System.out.println("Error en la ejecución");
        }
    }
    
}
