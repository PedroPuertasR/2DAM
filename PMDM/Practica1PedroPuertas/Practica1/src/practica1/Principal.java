/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import java.util.List;
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
        List <Automovil> lista = new ArrayList<Automovil>();
        Automovil auto1 = new Automovil ("Seat", "Panda", 10000);
        Automovil auto2 = new Automovil ("Toyota", "Yaris", 9500);
        lista.add(auto1);
        lista.add(auto2);
        Concesionario gestion = new Concesionario(auto1, auto2);
        Scanner leer = new Scanner(System.in);
        int opcion;
        int opcionAuto;
        int opcionPrecio;
        String opcionString;
        
        System.out.println("Bienvenido a este programa.");
        
        do{
            gestion.imprimirMenu();
            opcion = leer.nextInt();
            
            switch(opcion){
                case 0:
                    break;
                case 1:
                    gestion.verCoches(lista);
                    break;
                case 2:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches(lista);
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
                        gestion.verCoches(lista);
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
                        gestion.verCoches(lista);
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("La marca es: " + gestion.verMarca(opcionAuto));
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                
                case 5:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches(lista);
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("Indique el nuevo modelo:");
                            opcionString = leer.nextLine();
                            System.out.println("El nuevo modelo es: " + gestion.cambiarModelo(opcionAuto, opcionString));         
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                    
                case 6:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches(lista);
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("Indique la nueva marca:");
                            opcionString = leer.nextLine();
                            System.out.println("La nueva marca es: " + gestion.cambiarMarca(opcionAuto, opcionString));         
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                case 7:
                    do{
                        System.out.println("¿Qué coche desea seleccionar?");
                        gestion.verCoches(lista);
                        opcionAuto = leer.nextInt();
                        
                        if(opcionAuto != 1 || opcionAuto !=2){
                            System.out.println("Elija una opción correcta.");
                        }else{
                            System.out.println("Indique el nuevo precio:");
                            opcionPrecio = leer.nextInt();
                            System.out.println("El nuevo precio es: " + gestion.cambiarPrecio(opcionAuto, opcionPrecio) + " €");         
                        }
                    }while(opcionAuto != 1 || opcionAuto != 2);
                    break;
                    
                default:
                    System.out.println("Seleccione una opción correcta.");
                    
            }
        }while(opcion != 0);
        
        System.out.println("Gracias por usar este programa.");
        
    }
    
}
