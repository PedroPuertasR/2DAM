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
public class ExclusionMutua {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Introducir el número de hilos");
        
        Scanner leer = new Scanner(System.in);
        int N = leer.nextInt();
        
        DosCerrojos hilos[];
        
        System.out.println("Creando " + N + " hilos ");
        
        hilos = new DosCerrojos[N];
        
        //Bucle que crea cada hilo y los lanza
        for (int i = 0; i < N; i++) {
            //Instanciamos la clase DosCerrojos
            hilos[i] = new DosCerrojos();
            //Iniciamos el hilo
            hilos[i].start();
            //Realizamos un join para que no se ejecute el siguiente hasta que termine
            hilos[i].join();
        }
        
        System.out.println("Valor de la variable Global 1 = "
                + VariableGlobal.variableGlobal1);
        
        System.out.println("Valor de la variable Global 2 = "
                + VariableGlobal.variableGlobal2);
    }
}
