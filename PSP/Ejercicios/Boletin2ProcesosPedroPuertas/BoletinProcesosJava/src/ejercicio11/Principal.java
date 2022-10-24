/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Mayusculas m = new Mayusculas();
        
        
        
    }
    
}

class Mayusculas{
    public Mayusculas(){

        String comando, lectura;
        Process p, pPadre;
        OutputStream os;
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader (is);
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "echo escriba algo:";
            
        }else{
            comando = "cmd /c echo escriba algo:";
        }
        
        try {
            p = new ProcessBuilder(comando).start();
            
            lectura = teclado.readLine();
            
            //pPadre = new ProcessBuilder(teclado).start();
            
            os = p.getOutputStream();
            
            
            
            System.out.println(os);
        } catch (IOException ex) {
            Logger.getLogger(Mayusculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
