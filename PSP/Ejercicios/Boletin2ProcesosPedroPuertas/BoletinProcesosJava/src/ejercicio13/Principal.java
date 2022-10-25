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
        
        ProcessBuilder pb = new ProcessBuilder("java", "-jar",  "ejercicio12.jar", "Pedro");
        
        pb.directory(new File(carpeta));
        
        try{
            p = pb.start();
            
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            br.close();
        }catch(IOException e){
            System.out.println("Error en la ejecución");
        }
    }
    
}
