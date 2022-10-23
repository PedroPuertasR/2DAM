/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "ls";
            
        }else{
            comando = "cmd /c dir";
        }
        
        for (int i = 0; i < args.length; i++) {
            comando += args[i];
        }
        
        Ejecuta e = new Ejecuta(comando);
        
    }
    
}

class Ejecuta{
    
    public Ejecuta (String comando){
        
        InputStream is;
        BufferedReader br;
        String linea;
        Runtime r = Runtime.getRuntime();
        Process p;
        
        try{
            
            p = r.exec(comando);
            p.waitFor();
            
            is = p.getInputStream();
            
            br = new BufferedReader(new InputStreamReader(is));
            
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            br.close();
            p.destroy();
            
        }catch(IOException e){
            System.out.println("Error al crear el proceso.");
            e.printStackTrace();
        } catch (InterruptedException ex) {
            System.out.println("Proceso interrumpido.");
        }
    }
}