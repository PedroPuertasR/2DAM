/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

import java.io.File;
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
        
        //Indicamos las rutas tanto de origen como de destino
        File origen = new File("/home/alumno/Descargas/Boletin1PSPPedroPuertas/recursos/origen");
        File destino = new File("/home/alumno/Descargas/Boletin1PSPPedroPuertas/recursos/destino");
        Fichero archivo = new Fichero();
         
          // Código
        try{
            archivo.copiarCarpeta(origen, destino);
            System.out.println("Copia realizada");
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("No se ha podido copiar el fichero.");
        }
        
    }
    
}