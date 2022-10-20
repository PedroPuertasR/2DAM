/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
        
        String comando;
        ProcessBuilder pb;
        FileWriter esc;
        File bat = new File("/home/alumno/Documentos/ordenes.bat");
        File log = new File("/home/alumno/Documentos/salida.txt");
        File error = new File("/home/alumno/Documentos/error.txt");
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "ls";
            
        }else{
            comando = "cmd /c dir";
        }
        
        try{
            esc = new FileWriter("/home/alumno/Documentos/ordenes.bat", false);
            esc.write(comando);
            esc.close();
            
            pb = new ProcessBuilder(comando);
        
            pb.redirectInput(bat);
            pb.redirectOutput(log);
            pb.redirectError(error);
            
            pb.start();
            
        }catch(IOException e){
            System.out.println("Error en la escritura");
            e.printStackTrace();
        }
            
    }
    
}
