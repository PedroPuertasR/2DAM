/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PuertasRodríguezPedroProblema2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Mayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Instanciamos un objeto PasarMayusPadre para que se ejecute nuestro código
        PasarMayusPadre p = new PasarMayusPadre();

    }

}


//Esta clase es la que he utilizado para crear el mayusculas.jar
class PasarMayus {

    public PasarMayus() {

        //String para almacenar los que contiene el buffer
        String entrada;
        
        //InputStream creado para la salida estándar
        InputStreamReader isr = new InputStreamReader(System.in);
        
        //Buffer que leerá la salida estándar
        BufferedReader br = new BufferedReader(isr);

        try {
            //Almacenamos en entrada la lectura del buffer
            entrada = br.readLine();
            
            //Mostramos lo introducido por teclado pasándolo antes a mayúsculas
            System.out.println(entrada.toUpperCase());
            
            //Cerramos el buffer
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}

class PasarMayusPadre {

    public PasarMayusPadre() {
        try {
            //Creamos el scanner para leer por teclado
            Scanner sc = new Scanner(System.in);
            //En este String almacenamos la lectura por teclado
            String lectura;
            
            System.out.println("Introducir linea:");

            do {
                lectura = sc.nextLine();

                /*Mientras que introduzcamos algo por teclado 
                * se ejecutará el método llamada
                */
                if (lectura != null) {
                    llamada(lectura);
                }
            } while (lectura != null);
        } catch (Exception e) {
            System.out.println("Fallo en el padre.");
        }
    }

    /*Con este método crearemos el proceso por el que ejecutaremos el .jar y 
    * mostraremos la salida
    */
    public void llamada(String lectura) {
        
        String linea;
        
        try {

            //Instanciamos un ProcessBuilder que ejecutará el .jar
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", "mayusculas.jar");

            //Le indicamos al ProcessBuilder donde se encuentra nuestro .jar
            pb.directory(new File("./."));

            //Iniciamos el proceso
            Process p = pb.start();

            /*Instanciamos el OutputStream e InputStream para poder pasarselo
            * al buffer y al printWriter 
            */
            OutputStream os = p.getOutputStream();
            InputStream is = p.getInputStream();

            //Instanciamos el buffer
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            //Creamos un PrintWriter para mostrar la salida del proceso
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));

            //Mostramos la lectura con el PrintWriter
            pw.println(lectura);

            //Limpiamos el PrintWriter para la próxima vez que se utilice
            pw.flush();

            //Guardamos en linea la lectura del buffer
            linea = br.readLine();

            //Mientras que la cadena no esté vacía la mostramos por pantalla
            if (linea != null) {
                System.out.println(linea);
            }
            
            //Cerramos el buffer
            br.close();
        } catch (IOException e) {
            System.out.println("Error en el método llamada.");
        }
    }

}
