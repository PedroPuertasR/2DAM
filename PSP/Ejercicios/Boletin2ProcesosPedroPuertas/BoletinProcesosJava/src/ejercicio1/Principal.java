/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Runtime.getRuntime;

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
        
        Runtime r = getRuntime();
        String comando, linea;
        Process p;
        BufferedReader br;
        

        //Comprobamos que sistema operativo estamos usando
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "ls";
            
        }else{
            comando = "cmd /c dir";
        }
        
        try{

            //Ejecutamos el comando e iniciamos el proceso
            p = r.exec(comando);

            //Cogemos el inputStream y lo guardamos en una variable
            InputStream is = p.getInputStream();
            //Instanciamos el BufferedReader pasandole el InputStream
            br = new BufferedReader(new InputStreamReader(is));
            //Creamos un bucle while por el cual seguimos leyendo hasta que no quede nada
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            //Cerramos el BufferedReader
            br.close();
        }catch(IOException e){
            System.out.println("Error en: " + e);
        }
        
        
        
    }
    
}
