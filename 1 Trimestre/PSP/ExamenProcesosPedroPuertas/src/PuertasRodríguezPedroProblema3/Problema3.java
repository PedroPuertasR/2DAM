/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuertasRodríguezPedroProblema3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Problema3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Runtime r = Runtime.getRuntime();
        
        //Variable que contiene la salida para imprimir por pantalla
        String salida;
        
        try {
            //Creamos el proceso que ejecutara el comando ls
            Process p = Runtime.getRuntime().exec("ls");
            
            //Creamos el inputStream que le pasaremos al buffer
            InputStream is = p.getInputStream();
            
            //Creamos el buffer que leerá lo que contiene el inputStream
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            /*En este bucle mostraremos por pantalla lo que haya 
            * dentro del buffer hasta que sea nulo (hasta que termine de leer)
            */
            while((salida = br.readLine()) != null){
                System.out.println(salida);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Problema3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
