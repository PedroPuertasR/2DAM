/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
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
        
        Runtime r = Runtime.getRuntime();
        String cadena, comando;
        BufferedReader br, brTeclado;
        Process p;
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "echo escriba una cadena:";
            
        }else{
            comando = "cmd /c echo escriba una cadena:";
        }
        
        try{
            //Iniciamos el proceso
            p = r.exec(comando);
            
            //Instanciamos los BufferedReader, tanto el de lectura como el del InputStream del proceso
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brTeclado = new BufferedReader(new InputStreamReader(System.in));
            
            //Mostramos la lectura e instanciamos la variable cadena con la lectura por teclado
            System.out.println(br.readLine());
            cadena = brTeclado.readLine();
            
            //Mostramos la lectura por teclado
            System.out.println("Cadena: " + cadena);
            
            //Cerramos los BufferedReader
            br.close();
            brTeclado.close();
            
            p.destroy();
            
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
    }
    
}
