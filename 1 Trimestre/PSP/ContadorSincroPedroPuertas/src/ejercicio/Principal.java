/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

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
        
        Scanner sc = new Scanner(System.in);
        
        int incre, decre;
        
        System.out.println("Bienvenido al programa.");
        
        do{
            
            System.out.println("Indique el número de incremento:");
            
            incre = sc.nextInt();
            
            System.out.println("Indique el número de decremento:");
            
            decre = sc.nextInt();
            
        }while(incre == 0 || decre == 0);
        
    }
    
}
