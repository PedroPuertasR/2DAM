/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

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
        String cadena, comando;
        BufferedReader br, brTeclado;
        InputStream is;
        Process p;
        
        
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "echo escriba una cadena:";
            
        }else{
            comando = "cmd /c echo escriba una cadena:";
        }
        
        try{
            
            p = r.exec(comando);
            
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brTeclado = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println(br.readLine());
            cadena = brTeclado.readLine();
            
            System.out.println("Cadena: " + cadena);
            
            br.close();
            brTeclado.close();
            
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
    }
    
}
