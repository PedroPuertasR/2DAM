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
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "ls";
            
        }else{
            comando = "cmd /c dir";
        }
        
        try{
            
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            br.close();
        }catch(IOException e){
            System.out.println("Error en: " + e);
        }
        
        
        
    }
    
}
