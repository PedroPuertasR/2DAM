/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        FileReader archivo;
        BufferedReader filtro;
        FileWriter destino;
        String linea;
        
        try{
            //Instanciamos el FileReader indicando la ruta de donde vamos a leer.
            archivo = new FileReader("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedrotab.txt");
            //Instanciamos el BufferedReader y le indicamos la lectura.
            filtro = new BufferedReader(archivo);
            
            /*Instanciamos el FileWriter y le indicamos la ruta donde queremos almacenar
            * la copia, también indicamos si queremos sobreescribir en caso de que ya
            * exista el archivo.
            */
            destino = new FileWriter("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedrotab_copia.txt", true);
            
            //Almacenamos en el linea lo que hay en el buffer.
            linea = filtro.readLine();
            
            /* En este while ponemos la condición de que mientras linea no sea null va
            * a seguir reemplazando.
            * Lo que estamos reemplazando son los tabuladores con dos espacios, esto es
            * gracias al condicional if en el que indicamos que si linea contiene un tabulador
            * ("\t") reemplace este con los dos espacios, además de más tarde escribirlo en el
            * destino.
            */
            while(linea != null){
                if(linea.contains("\t")){
                    linea = linea.replaceAll("\t", "  ");
                }
                
                destino.write(linea);
                linea = filtro.readLine();            
            }
            
            //Cerramos todos los flujos
            archivo.close();
            filtro.close();
            destino.close();
            
        }catch(IOException e){
            System.out.println("No se ha podido leer el archivo");
        }
            
        
    }
    
}
