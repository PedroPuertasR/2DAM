/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author alumno
 */
public class Fichero {
    
     public void copiarCarpeta(File dOrigen, File dDestino) throws IOException{
         
         //Con esta condición comprobamos si existe el directorio de origen
          if(dOrigen.isDirectory()){
                // Si la carpeta no existe la genera
                if(!dDestino.exists()){
                     dDestino.mkdir();
                }
                                              
                String[] hijos = dOrigen.list();
                                              
                for(int i = 0; i < hijos.length; i++){
                     copiarCarpeta(new File(dOrigen, hijos[i]), new File(dDestino, hijos[i]));
                     System.out.println("Copiado " + hijos[i]);
                }
          }
          else{
                copiarFichero(dOrigen, dDestino);
          }
     }
    
     public void copiarFichero(File fOrigen, File fDestino) throws IOException{
         
          InputStream in = new FileInputStream(fOrigen);
          OutputStream out = new FileOutputStream(fDestino);
          byte[] buffer = new byte[1024];
          
          int cap;

          while ((cap = in.read(buffer)) > 0){
                out.write(buffer, 0, cap);
          }
         
          in.close();
          out.close();
         
          System.out.println("Copiado " + fOrigen.getName());
         
     }
}