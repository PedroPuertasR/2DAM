/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;


/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProcessBuilder pb;
        Process p;
        String comando;
        File log = new File("/home/alumno/Documentos/salida.txt");
        File error = new File("/home/alumno/Documentos/error.txt");
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "ls";
            
        }else{
            comando = "cmd /c dir";
        }
        
        pb = new ProcessBuilder(comando);
        
        pb.redirectOutput(log);
        pb.redirectError(error);
        
        try{
            p = pb.start();
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
    }
    
}
