/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Ejecutamos la clase MayusculasPadre para realizar todos los procesos
        MayusculasPadre mp = new MayusculasPadre();
        
    }
    
}


class Mayusculas{
    public Mayusculas(){
        String entrada;
        InputStreamReader isr = new InputStreamReader(System.in);
        //Instanciamos el BufferedReader con el input de la lectura por teclado
        BufferedReader br = new BufferedReader (isr);
       
        try
        {   
            //Pasamos cada linea a mayúsculas con el método toUpperCase()
            entrada=br.readLine();
            System.out.println(entrada.toUpperCase());       
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

class MayusculasPadre{
    public MayusculasPadre(){
        try
        {   
            Scanner entrada = new Scanner(System.in);                           
            String lectura;
            System.out.println("Introducir linea:");           
                       
            do
            {
                //Realizamos lecturas hasta que esta sea nula
                lectura = entrada.nextLine();   
               
                if(lectura != null){
                    //Con este método llamamos a la clase Mayusculas
                    llamada(lectura);
                }
            }
            while(lectura != null);
           
            System.out.println("Proceso finalizado");       
        }
        catch(Exception ex)
        {       
            ex.printStackTrace();
        } 
    }
    
    private static void llamada(String lectura){
        
        try {
            /*En este proceso ejecutamos un .jar de la clase Mayusculas
             para realizar la conversión de la lectura*/
            Process p = Runtime.getRuntime().exec("java -jar Jars/mayusculas.jar");
            OutputStream os = p.getOutputStream ();
            InputStream is = p.getInputStream ();
            
            BufferedReader reader = new BufferedReader (new InputStreamReader(is));
            //Con el PrintWriter formateamos la salida del outputStream
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            
            //Mostramos la salida
            pw.println(lectura);
            //Vaciamos con el método flush por si necesitamos volver a utilizarlo más tarde
            pw.flush();
            
            //Instanciamos la variable linea con la lectura del buffer
            String linea = reader.readLine();
            
            //Indicamos que mientras la lectura no este vacia continuamos leyendo
            if(linea != null){
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.println("Error en la llamada.");
        }
    } 
}