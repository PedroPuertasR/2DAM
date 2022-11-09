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
            /*Instanciamos el FileWriter que nos guardará lo que escribamos en un archivo .bat
             utilizamos el false para que no sobreescriba el archivo, sino que lo sustituya*/
            esc = new FileWriter("/home/alumno/Documentos/ordenes.bat", false);
            //Escribimos el comando y cerramos la escritura
            esc.write(comando);
            esc.close();
            
            //Instanciamos el ProcessBuilder con el comando especificado
            pb = new ProcessBuilder("bash");
        
            //Redireccionamos el input, output y error a sus respectivos archivos
            pb.redirectInput(bat);
            pb.redirectOutput(log);
            pb.redirectError(error);
            
            //Iniciamos el proceso para que realice todas estas escrituras
            pb.start();
            
        }catch(IOException e){
            System.out.println("Error en la escritura");
            e.printStackTrace();
        }
            
    }
    
}
