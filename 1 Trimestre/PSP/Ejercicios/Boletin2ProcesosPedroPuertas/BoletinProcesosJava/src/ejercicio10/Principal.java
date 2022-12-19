/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        //Ejecutamos la clase Aleatorio para que realice el proceso
        Aleatorio a = new Aleatorio();
        
    }
    
}

class Aleatorio{
    public Aleatorio(){
    
        String lectura;
        BufferedReader br, brTeclado;
        String comando;
        Process p;
        Runtime r = Runtime.getRuntime();
        
        
        if(System.getProperty("os.name").equalsIgnoreCase("linux")){

            comando = "echo escriba algo:";
            
        }else{
            comando = "cmd /c echo escriba algo:";
        }
        
        try {
            //Iniciamos el proceso
            p = r.exec(comando);
            
            //Instanciamos los Buffer con el input del proceso y otro para la lectura por teclado
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brTeclado = new BufferedReader(new InputStreamReader(System.in));
            
            //Leemos el buffer del proceso e instanciamos la variable lectura guardando la lectura por teclado
            System.out.println(br.readLine());
            lectura = brTeclado.readLine();
            
            /*Con este bucle leemos por teclado hasta que no le pasemos nada. Cada vez que escribamos 
            algo nos devolvera un numero aleatorio
            */
            while(!lectura.equalsIgnoreCase("")){
                System.out.println(lectura);
                System.out.println(alea(10, 0));
                lectura = brTeclado.readLine();
            }
            
            //Cerramos los Buffer y destruimos el proceso
            br.close();
            brTeclado.close();
            p.destroy();
        } catch (IOException ex) {
            Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Método para generar el aleatorio
    public int alea(int max, int min) {
        Random aleatorio = new Random();
        int num;

        num = aleatorio.nextInt(max - min + 1) + min;

        return num;
    }
}