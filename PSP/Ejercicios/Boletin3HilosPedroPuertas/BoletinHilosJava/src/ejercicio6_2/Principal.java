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
        
        DemoPrioridadGet t1 = new DemoPrioridadGet();
        DemoPrioridadGet t2 = new DemoPrioridadGet();
        DemoPrioridadGet t3 = new DemoPrioridadGet();
        
        System.out.println("Prioridad del hilo t1 : " + t1.getPriority());
        System.out.println("Prioridad del hilo t2 : " + t2.getPriority()); 
        System.out.println("Prioridad del hilo t3 : " + t3.getPriority());
        
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);
        
        System.out.println("Prioridad del hilo t1 : " + t1.getPriority()); //2
        System.out.println("Prioridad del hilo t2 : " + t2.getPriority()); //5
        System.out.println("Prioridad del hilo t3 : " + t3.getPriority());//8
       
        System.out.print(Thread.currentThread().getName()+": ");
        System.out.println("Prioridad del hilo Main : " + Thread.currentThread().getPriority());
        
        Thread.currentThread().setPriority(10);
        System.out.println("Prioridad del hilo Main : " + Thread.currentThread().getPriority());
        
    }
    
}

class DemoPrioridadGet extends Thread{
   
    public void run(){
        System.out.println("Dentro del método run");
    }
}
