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
         
         /*Creamos un array de Strings para almacenar más tarde la lista de 
         archivos que hay en el origen*/
         String[] lista;
         
         //Con esta condición comprobamos si el archivo de origen es una carpeta
          if(dOrigen.isDirectory()){
                // Si no existe la carpeta de destino la genera
                if(!dDestino.exists()){
                     dDestino.mkdir();
                }
                
                //Instanciamos la lista
                lista = dOrigen.list();
                
                /* En este for indicamos que mientras dure la lista haremos una copia
                * de cada archivo del origen en el destino, es decir dOrigen (archivo de origen)
                * de lista[0] (primera posición de la carpeta de origen) en la lista [0]
                * (primera posición de la carpeta de destino)
                */
                for(int i = 0; i < lista.length; i++){
                     copiarCarpeta(new File(dOrigen, lista[i]), new File(dDestino, lista[i]));
                     System.out.println("Copiado " + lista[i]);
                }
          }
          /*En el caso de que el origen no sea una carpeta rescataremos todos 
          * los archivos del origen y los copiaremos en el destino
          */
          else{
                copiarFichero(dOrigen, dDestino);
          }
     }
    
     public void copiarFichero(File fOrigen, File fDestino) throws IOException{
         
         //Instanciamos el reader y el writer
          InputStream in = new FileInputStream(fOrigen);
          OutputStream out = new FileOutputStream(fDestino);
          
          /*Le indicamos al writer que escriba en la ruta deseada todos 
          los bytes que contiene la lectura*/
          out.write(in.readAllBytes());
         
          //Cerramos los flujos
          in.close();
          out.close();
         
          System.out.println("Copiado " + fOrigen.getName());
         
     }
}