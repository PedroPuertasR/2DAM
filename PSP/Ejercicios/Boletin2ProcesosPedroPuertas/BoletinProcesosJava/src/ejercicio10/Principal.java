/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10;

import java.util.Scanner;

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
        
        
        
    }
    
}

class Aleatorio{
    public Aleatorio(){
    
        Scanner sc = new Scanner(System.in);
        String lectura = sc.nextLine();
        Process p;
        
        while(!lectura.equals("")){
            System.out.println(lectura);
            System.out.println(alea());
        }
        
    }
    
    public int alea(){
        int aleat = (int)Math.random() * 10;
        
        return aleat;
    }
}