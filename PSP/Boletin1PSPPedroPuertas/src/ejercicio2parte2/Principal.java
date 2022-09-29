/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2parte2;

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
        
        Escribiendo escribir = new Escribiendo();
        escribir.escribir();
        
    }
    
}

class Escribiendo{
    
    public void escribir(){
        try{
            /*Creamos el FileWriter y le indicamos la ubicación donde queremos escribir y el true para
            * indicarle si queremos sobreescribir el archivo en caso de que ya esté creado
            */
            FileWriter escritura = new FileWriter("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro_escritura.txt", true);
            
            /*Creamos una variable tipo int en la que indicaremos el número de veces que queremos
             escribir el mensaje*/
            int contador = 10;
            
            /* Realizamos un bucle for para que se escriba la frase todas las veces que hayamos indicado
            * en el contador
            */
            for(int i = 0; i < contador; i++){
                escritura.write("Línea "+ i + "\n");
            }
            
            //Cerramos el flujo para que el programa termine de escribir
            escritura.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("No se ha podido escribir el archivo.");
        }
        
        
    }
    
}
