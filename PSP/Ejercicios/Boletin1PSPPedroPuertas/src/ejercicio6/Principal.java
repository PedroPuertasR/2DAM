/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        FileReader archivoDos;
        BufferedReader bufferArchivo;
        BufferedReader bufferArchivoDos;
        FileWriter escritura;
        Scanner lectura = new Scanner(System.in);
        String ruta;
        String rutaDos;
        String destino;
        String linea;
        String lineaDos;
        
        //Preguntamos al usuario las rutas a través de un Scanner
        System.out.println("Introducir la ruta y el nombre del 1º fichero:");
        ruta = lectura.nextLine();
        System.out.println("Introducir la ruta y el nombre del 2º fichero:");
        rutaDos = lectura.nextLine();
        System.out.println("Introducir la ruta y el nombre del fichero destino:");
        destino = lectura.nextLine();
        
        try{
            
            /*Instanciamos los FileReader, BufferedReader y FileWriter con sus
             correspondientes rutas*/
            archivo = new FileReader(ruta);
            archivoDos = new FileReader(rutaDos);
            bufferArchivo = new BufferedReader(archivo);
            bufferArchivoDos = new BufferedReader(archivoDos);
            escritura = new FileWriter(destino, true);
            
            //Almacenamos en los strings la lectura de los buffers
            linea = bufferArchivo.readLine();
            lineaDos = bufferArchivoDos.readLine();
            
            /* Indicamos con el while que mientras que linea y lineaDos no lleguen
            * al final (con la diferencia de null), va a seguir escribiendo en el 
            * destino una línea de la primer lectura y otra de la segunda.
            */
            while(linea != null && lineaDos != null){
                escritura.write(linea + "\n");
                escritura.write(lineaDos + "\n");
                linea = bufferArchivo.readLine();
                lineaDos = bufferArchivoDos.readLine();
            }
            
            //Cerramos los flujos
            archivo.close();
            archivoDos.close();
            bufferArchivo.close();
            bufferArchivoDos.close();
            escritura.close();
            
        }catch(IOException e){
            System.out.println("No se ha podido copiar el archivo.");
        }
        
        
        
    }
    
}
