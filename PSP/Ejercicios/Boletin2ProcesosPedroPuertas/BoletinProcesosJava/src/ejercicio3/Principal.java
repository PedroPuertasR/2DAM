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
            //Iniciamos el proceso
            p = r.exec(comando);
            
            //Cogemos el inputStream, el outputStream y el errorStream
            is = p.getInputStream();
            isError = p.getErrorStream();
            os = p.getOutputStream();
            
            //Instanciamos el BufferedReader con el inputStream y también otro para el error
            br = new BufferedReader(new InputStreamReader(is));
            brError = new BufferedReader(new InputStreamReader(isError));
            
            //Escribimos con el outputStream la fecha cogiendo los bytes para que no haya problema
            os.write("21/12/1995".getBytes());
            //Vaciamos el outputStream para que esté limpio para la próxima vez
            os.flush();
            //Cerramos el flujo
            os.close();
            
            //Con los siguientes bucles while leemos tanto la salida como el error hasta que sea nulo
            while((linea = br.readLine()) != null){
                System.out.println(linea);
            }
            
            while((lineaError = brError.readLine()) != null){
                System.out.println(lineaError);
            }
            
            //Cerramos los dos BufferedReader
            br.close();
            brError.close();
            
        }catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        
    }
    
}
