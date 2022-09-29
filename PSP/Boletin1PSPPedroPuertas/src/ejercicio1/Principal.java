/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.io.FileReader;
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
        
        LeerFichero leer = new LeerFichero();
        leer.lee();
        
    }
    
}

class LeerFichero{
    public void lee(){
        try{
            
            //Instancio el FileReader con la ruta del archivo
            
            FileReader ruta = new FileReader("/home/alumno/Descargas"
                    + "/Boletin1PSPPedroPuertas/recursos/pedro.txt");
            
            //En la variable c código de los caracteres conforme se vayan leyendo
            int c = ruta.read();
            
            /*Con este bucle mostraremos los dígitos en consola hasta que acabe de
            *leer. Como al terminar se leerá un -1 para indicar que se ha terminado
            *la secuencia utilizaremos esa condición para salir del bucle.
            */
            while(c != -1){;
                System.out.println(c);
                c = ruta.read();
            }
            
            //Cerramos el flujo
            ruta.close();
            
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Archivo no encontrado.");
        }
    }
}
