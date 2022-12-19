/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

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
        
        String comando, linea;
        ProcessBuilder pb;
        BufferedReader br;
        Process p;
        InputStream is;
        Map entorno;
        List lista;
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "ls";
            
        }else{
            comando = "cmd /c dir";
        }
        
        pb = new ProcessBuilder(comando);
        
        try{
            
            //Iniciamos el proceso con el ProcessBuilder
            p = pb.start();
            
            //Cogemos el inputStream del proceso
            is = p.getInputStream();
            
            //Instanciamos el BufferedReader
            br = new BufferedReader(new InputStreamReader(is));
            
            //Leemos la salida del BufferedReader hasta que sea nulo
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            //Instanciamos la variable entorno que es tipo Map (Como el resultado de pb.environment())
            entorno = pb.environment();
            
            //Mostramos el entorno por la salida estándar
            System.out.println("\nDatos del entorno:");
            System.out.println(entorno);
            
            //Instanciamos la variable lista (tipo List) con los comandos del ProcessBuilder
            lista = pb.command();
            
            System.out.println("\nComandos usados:");
            
            //Mostramos los comandos por la salida estándar
            for(int i = 0; i < lista.size(); i++){
                System.out.println(lista.get(i));
            }
            
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
        
    }
    
}
