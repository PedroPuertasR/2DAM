/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio15;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author pedro
 */
public class Suma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int lectura, lectura2;
        Scanner sc = new Scanner(System.in);

        //Realizamos las dos lecturas
        try {
            System.out.println("Introduzca el primer número:");
            lectura = sc.nextInt();
        
            System.out.println("Introduzca el segundo número:");
            lectura2 = sc.nextInt();
        
            //Sumamos los dos números
            System.out.println("Suma: " + (lectura + lectura2));
            //Con la excepción NumberFormat nos aseguramos de que se introduce un número
        } catch (InputMismatchException e) {
            //TODO: handle exception
            System.out.println("Una de las lecturas no es un número");
        }
    }
    
}
