/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio8;

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
        
        /*Instanciamos nuestro array con el tamaño 
        de la cantidad de asignaturas de DAM*/
        Asignatura [] lista = new Asignatura[6];
        //Creamos un array con el que leeremos los objetos
        Asignatura [] listaLectura;
        
        //Agregamos los datos a nuestro array
        lista [0] = new Asignatura("DI");
        lista [1] = new Asignatura("PSP");
        lista [2] = new Asignatura("SGE");
        lista [3] = new Asignatura("EMP");
        lista [4] = new Asignatura("PMDM");
        lista [5] = new Asignatura("AD"); 
        
        ObjectOutputStream escritura;
        ObjectInputStream lectura;     
        
        //Con esta variable recogeremos más tarde las notas de cada asignatura
        double media = 0;
        
        //En este bucle for introduciremos cada nota de nuestro array
        for(Asignatura a: lista){
            System.out.print("Introduce la nota de "+ a.getNombre()+": ");   
            a.setNota(a.introducirNota());
            System.out.println("");
        }
        
        try{

            /*Escribiremos en la ruta deseada tras instanciar nuestro ObjectOutputStream
            * el cual debe llevar como parámetro un FileOutputStream
            */
            escritura = new ObjectOutputStream(new FileOutputStream("/home/alumno/"
                    + "Descargas/Boletin1PSPPedroPuertas/recursos/pedro_asignaturas.dat", true));
            
            //Escribimos los objetos de nuestra lista en la ruta deseada
            escritura.writeObject(lista);
            
            //Cerramos el flujo de escritura
            escritura.close();
            
            /* Instanciamos la lectura de nuestro ObjectInputStream y le indicamos 
            * la ruta de donde leerá los objetos anteriormente guardados
            */
            lectura = new ObjectInputStream(new FileInputStream("/home/alumno/"
                    + "Descargas/Boletin1PSPPedroPuertas/recursos/pedro_asignaturas.dat"));
            
            /*Instanciamos nuestro array de lectura con una conversión del ObjectOutputStream
            * a tipo array de Asignatura
            */
            listaLectura = (Asignatura[])lectura.readObject();
            
            /* Con este for mostraremos cada asignatura con su nota asignada, además
            * de recopilar cada nota para más tarde sacar la media
            */
            for(Asignatura a: listaLectura){
                System.out.println(a);
                media += a.getNota();
            }
            
            //Cerramos el flujo de lectura
            lectura.close();
            
            //Realizamos la media de las asignaturas y la mostramos
            media = media / lista.length;
            
            System.out.println("Media: "+ media);
            
        }catch(Exception e){
            e.getMessage();
            System.out.println("No se ha podido leer el archivo.");
        }  
        
    }
    
}
