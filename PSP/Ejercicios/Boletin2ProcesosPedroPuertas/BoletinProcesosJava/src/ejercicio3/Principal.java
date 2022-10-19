/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
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
        
        Runtime r = getRuntime();
        Process p;
        String comando;
        BufferedReader br;
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "DATE";
            
        }else{
            comando = "cmd /c date";
        }
        
        try{
            p = r.exec(comando);
            
            
        }catch(IOException e){
            System.out.println("Error en " + e);
        }
        
    }
    
}
