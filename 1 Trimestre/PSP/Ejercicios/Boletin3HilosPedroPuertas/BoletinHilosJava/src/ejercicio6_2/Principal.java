/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6_2;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Instanciamos nuestras DemoPrioridadGet
        DemoPrioridadGet dp1 = new DemoPrioridadGet();
        DemoPrioridadGet dp2 = new DemoPrioridadGet();
        DemoPrioridadGet dp3 = new DemoPrioridadGet();
        
        //Mostramos por pantalla la prioridad que tiene cada uno de nuestros hilos
        System.out.println("dp1 tiene la prioridad: " + dp1.getPriority());
        System.out.println("dp2 tiene la prioridad: " + dp2.getPriority()); 
        System.out.println("dp3 tiene la prioridad: " + dp3.getPriority());
        
        //Cambiamos la prioridad de cada uno de nuestros hilos a la deseada
        dp1.setPriority(2);
        dp2.setPriority(5);
        dp3.setPriority(8);
        
        //Mostramos la nueva prioridad
        System.out.println("dp1 tiene la prioridad: " + dp1.getPriority());
        System.out.println("dp2 tiene la prioridad: " + dp2.getPriority()); 
        System.out.println("dp3 tiene la prioridad: " + dp3.getPriority());
       
        //Mostramos el nombre del hilo principal y su prioridad actual
        System.out.print(Thread.currentThread().getName() + ": ");
        System.out.println("Prioridad del hilo Main : " + Thread.currentThread().getPriority());
        
        //Seteamos su prioridad a 10 y la mostramos por pantalla
        Thread.currentThread().setPriority(10);
        System.out.println("Prioridad del hilo Main : " + Thread.currentThread().getPriority());
    } 
}

class DemoPrioridadGet extends Thread{
   
    public void run(){
        System.out.println("En el método run");
    }
}
