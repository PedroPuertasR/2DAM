/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

        //Instanciamos la lista con el tamaño elegido
        Empleado[] lista = new Empleado[4];
        /*Creamos un nuevo array para cuando tengamos 
        que leer los objetos y guardarlos dentro*/
        Empleado [] listaLectura;
        //Agregamos los objetos a la lista
        lista[0] = new Empleado("Pedro Puertas", 8000, 2020, 12, 21);
        lista[1] = new Empleado("Alberto Ruíz", 2300, 2002, 10, 30);
        lista[2] = new Empleado("Juan López", 1600, 2006, 4, 27);
        lista[3] = new Empleado("David González", 4300, 2012, 5, 9);
        
        ObjectOutputStream escribirFichero;
        ObjectInputStream leerFichero;
        
        try {
            /*Instanciamos el ObjectOutputStream que necesita un FileOutputStream 
            * como parámetro para poder escribir en la ruta deseada
            */
            escribirFichero = new ObjectOutputStream(new FileOutputStream("/home/"
                    + "alumno/Descargas/Boletin1PSPPedroPuertas/recursos/pedro_escritura.dat", true));
            
            //Escribimos lista como un objeto en el archivo
            escribirFichero.writeObject(lista);
            
            //Cerramos el flujo de la escritura
            escribirFichero.close();

            //Leemos el archivo con un ObjectInputStream
            leerFichero = new ObjectInputStream(new FileInputStream("/home/"
                    + "alumno/Descargas/Boletin1PSPPedroPuertas/recursos/pedro_escritura.dat"));
            
            //Instanciamos la listaLectura con la lectura de los objetos de nuestra ruta
            listaLectura=(Empleado[])leerFichero.readObject();
            
            /*Realizamos un bucle for para leer uno por uno los objetos que contiene nuestra
            nueva lista*/
            for (Empleado e : listaLectura) {
                System.out.println(e);
            }
            
            //Cerramos el flujo de lectura
            leerFichero.close();
            
        } catch (Exception e) {
            System.out.println("No se ha podido realizar la lectura.");
        }
    }
}