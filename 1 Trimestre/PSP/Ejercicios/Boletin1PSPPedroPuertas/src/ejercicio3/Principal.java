/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.io.BufferedReader;
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
        Leer_Fichero accediendo = new Leer_Fichero();
        accediendo.lee();
    }
    
}

class Leer_Fichero{
    public void lee(){
        try{
            //Creamos el FileReader con nuestra ruta
            FileReader lectura = new FileReader("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro.txt");
            //Creamos el BufferedReader incluyendo nuestra lectura del txt
            BufferedReader bufferLectura = new BufferedReader(lectura);
            //Creamos el FileWriter con el destino para la copia del txt
            FileWriter escritura = new FileWriter("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro_copia.txt", true);
            
            /*Con el método write del FileWrite escribimos lo que está almacenado
            * en el buffer
            */
            escritura.write(bufferLectura.readLine());
            
            //Cerramos todos los flujos
            lectura.close();
            escritura.close();
            bufferLectura.close();
            
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("No se ha podido copiar el archivo.");
        }
        
    }
}
