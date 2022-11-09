/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuertasRodríguezPedroProblema1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String linea;
        
        Process p;
        
        //Instanciamos el ProcessBuilder que ejecutará el .jar
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "SumaControlada.jar");
        //Le indicamos el directorio donde se encuentra el .jar
        pb.directory(new File("./."));
        
        try {
            //Iniciamos el proceso
            p = pb.start();
            //Instanciamos un InputStream para guardar el del proceso
            InputStream is = p.getInputStream();
            
            //Instanciamos un buffer para realizar la lectura por pantalla
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            /*Con este bucle indicamos que mientras haya algo que leer aparecerá por pantalla
            */
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Problema1.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
}
