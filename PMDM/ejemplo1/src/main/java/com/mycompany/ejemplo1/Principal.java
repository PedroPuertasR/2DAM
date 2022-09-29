/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplo1;

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
        
        Automovil auto1 = new Automovil ("Seat", "Panda", 10000);
        Automovil auto2 = new Automovil ("Toyota", "Yaris", 9500);
        Concesionario gestion = new Concesionario(auto1, auto2);
        Scanner leer = new Scanner(System.in);
        int opcion;
        int opcionAuto;
        
        System.out.println("Bienvenido a este programa.");
        
        do{
            gestion.imprimirMenu();
            opcion = leer.nextInt();
            
            switch(opcion){
                case 0:
                    break;
                case 1:
                    System.out.println("¿Qué coche desea seleccionar?");
                    gestion.verCoches();
                    break;
                case 2:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches();
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("El precio es de: " + gestion.verPrecio(opcionAuto) + " €");
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                case 3:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches();
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("El modelo es: " + gestion.verModelo(opcionAuto));
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                case 4:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches();
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("La marca es: " + gestion.verMarca(opcionAuto));
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                    
                    
                    
            }
        }while(opcion != 0);
        
    }
    
}
