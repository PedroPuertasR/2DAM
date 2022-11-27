/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class HiloC extends Thread{
    
    private Semaphore p1;
    
    public HiloC(Semaphore p1){
        this.p1 = p1;
    }
    
    public void run(){
        
        try {
            this.p1.acquire(1);
            
            System.out.println("Comienza el hilo C.");

            for (int i = 0; i < 5; i++) {
                System.out.println("Bye");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
