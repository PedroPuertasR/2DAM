/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author pedro
 */
public class HiloA extends Thread{
    
    private Semaphore p1;
    
    public HiloA(Semaphore p1){
        this.p1 = p1;
    }
    
    /* Al iniciar este hilo su semáforo entrará primero, puesto que no intenta
    * adquirir ningún permiso. Imprimirá 5 veces la palabra "Adiós" y liberará
    * 2 recursos, lo cual desbloqueará los otros dos hilos.
    */
    public void run(){
        
        System.out.println("Comienza el hilo A.");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Adiós");
        }
        
        this.p1.release(2);
    }
    
}
