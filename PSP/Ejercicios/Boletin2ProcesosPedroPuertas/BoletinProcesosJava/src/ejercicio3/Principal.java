/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
        BufferedReader br, brError;
        OutputStream os;
        InputStream isError, is;
        String linea, lineaError;
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "DATE";
            
        }else{
            comando = "cmd /c date";
        }
        
        try{
            p = r.exec(comando);
            
            is = p.getInputStream();
            isError = p.getErrorStream();
            os = p.getOutputStream();
            
            br = new BufferedReader(new InputStreamReader(is));
            brError = new BufferedReader(new InputStreamReader(isError));
            
            os.write("21/12/1995".getBytes());
            os.flush();
            os.close();
            
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            while((lineaError = brError.readLine()) != null){
                System.out.println(lineaError);
            }
            
            br.close();
            brError.close();
            
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
    }
    
}
