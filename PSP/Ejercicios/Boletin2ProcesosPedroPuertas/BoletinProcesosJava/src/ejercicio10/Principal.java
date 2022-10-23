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
import java.util.Scanner;
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
            p = r.exec(comando);
            
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            brTeclado = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println(br.readLine());
            lectura = brTeclado.readLine();
            
            while(!lectura.equalsIgnoreCase("")){
                System.out.println(lectura);
                System.out.println(alea(10, 0));
                lectura = brTeclado.readLine();
            }
            
            br.close();
            brTeclado.close();
            p.destroy();
        } catch (IOException ex) {
            Logger.getLogger(Aleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int alea(int max, int min) {
        Random aleatorio = new Random();
        int num;

        num = aleatorio.nextInt(max - min + 1) + min;

        return num;
    }
}