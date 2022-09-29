/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

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
        
        Escribiendo e = new Escribiendo();
        e.escribir();
        
    }
    
}


class Escribiendo{
    
    public void escribir(){
        
        try{
            /*
            *Creamos el FileWriter e indicamos la ruta en la que queremos guardar el archivo.
            *También indicamos true o false dependiendo de si queremos sobreescribir o no el archivo
            *En caso de que ya esté creado.
            */
           
            FileWriter escritura = new FileWriter("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro_escribir.txt", true);
            
            //Con el método write le indicamos lo que queremos escribir en el archivo.
            escritura.write("Hola soy Pedro");
            
            //Cerramos el flujo
            escritura.close();
            System.out.println("Se ha escrito en el archivo");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("No se ha podido escribir el archivo.");
        }
        
        
    }
    
}