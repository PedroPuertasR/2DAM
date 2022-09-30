/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
        
        int contador = 0;
        int datosEntrada [] = new int[437185];
        boolean finalArchivo = false;
        int byteEntrada;
        FileInputStream archivoLectura;
        FileOutputStream archivoEscritura;
        
        try{
            //Creamos la lectura e introducimos la ruta de la imagen a copiar
            archivoLectura = new FileInputStream("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro.png");
            
            /*Creamos la escritura e introducimos la ruta donde vamos a copiar
            * nuestra imagen
            */
            archivoEscritura = new FileOutputStream("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro_copia.png", true);
            
            /*En este while indicaremos que mientras no llegue el final del archivo,
            * el cual indicamos en el if/else a través de una condición que propone que
            * si los bytes de entrada no son -1 (el final del archivo), no se volverá true.
            */
            while(!finalArchivo){
                byteEntrada = archivoLectura.read();
                archivoEscritura.write(byteEntrada);
                
                if(byteEntrada != -1){
                    byteEntrada = datosEntrada[contador];
                }else{
                    finalArchivo = true;
                }
                //Vamos aumentando el contador hasta que llegue al máximo de los datos de entrada.
                contador++;
            }
            //Cerramos el flujo.
            archivoLectura.close();
        }catch(IOException e){
            System.out.println("Error al acceder a la imagen.");
        }
        
    }
      
}
