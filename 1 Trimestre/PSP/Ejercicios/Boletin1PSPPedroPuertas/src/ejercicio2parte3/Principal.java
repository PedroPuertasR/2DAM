/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2parte3;

import java.io.FileReader;
import java.io.FileWriter;
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
        
        Copia c = new Copia();
        c.copiar();
        
    }
    
}

class Copia{
    public void copiar(){
        
        try{
            //Creamos el FileReader y el FileWriter para indicar las rutas en las que queremos leer y copiar el archivo
            FileReader leer = new FileReader("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro.txt");
            FileWriter copiar = new FileWriter("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro_copia.txt", true);
            
            //Creamos una variable tipo int para almacenar los datos
            int c = leer.read();
            
            /*Realizamos un bucle en el cual el programa va a leer todas las palabras con la variable c
            * y las va a escribir con el .write en el nuevo archivo
            */
            while(c != -1){
                copiar.write(c);
                c = leer.read();
            }
            
            //Cerramos los flujos para que termine de copiar el programa
            leer.close();
            copiar.close();
            
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("No se ha podido copiar el archivo.");
        }
        
    }
}
