/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author pedro
 */
public class HiloB extends Thread{
    
    private Semaphore p1;
    
    public HiloB(Semaphore p1){
        this.p1 = p1;
    }
    
    public void run(){
        
        System.out.println("Comienza el hilo B.");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Hola");
        }
        
        this.p1.release();
    }
    
}
