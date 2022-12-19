/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class SumaControlada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String entrada;
        int num1;
        int num2 = num1 = 0;
        
        try{
            System.out.println("Introduzca el primer sumando: ");
            Scanner sc = new Scanner(System.in);
            entrada = sc.nextLine();
        
            num1 = Integer.parseInt(entrada);
            
            try{
                System.out.println("Introduzca el segundo sumando: ");
                sc = new Scanner(System.in);
                entrada = sc.nextLine();

                num2 = Integer.parseInt(entrada);
                
                System.out.println("La suma de " + num1 + " y " + num2 + " es = " + (num1+num2));
                
            }catch(NumberFormatException e){
                System.out.println("ERROR el segundo sumando no es un número.");
            }
        }catch(NumberFormatException e){
            System.out.println("ERROR el primer sumando no es un número.");
        }
        
    }
    
}
