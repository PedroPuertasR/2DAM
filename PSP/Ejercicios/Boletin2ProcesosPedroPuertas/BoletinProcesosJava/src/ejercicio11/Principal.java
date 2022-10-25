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
        
        MayusculasPadre mp = new MayusculasPadre();
        
    }
    
}


class Mayusculas{
    public Mayusculas(){
        String entrada;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
       
        try
        {   
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
                lectura = entrada.nextLine();   
               
                if( lectura != null){
                    llamada(lectura);
                }
            }
            while(!lectura.isBlank());
           
            System.out.println("Proceso finalizado");       
        }
        catch(Exception ex)
        {       
            ex.printStackTrace();
        } 
    }
    
    private static void llamada(String lectura){
        
        try {
            Process p = Runtime.getRuntime().exec("java -jar mayusculas.jar");
            OutputStream os = p.getOutputStream ();
            InputStream is = p.getInputStream ();
            
            BufferedReader reader = new BufferedReader (new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            
            pw.println(lectura);
            pw.flush();
            
            // Se lee la primera linea
            String linea = reader.readLine();
            
            if(!linea.isBlank()){
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.out.println("Error en la llamada.");
        }
    } 
}