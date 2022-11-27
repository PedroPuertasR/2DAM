/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class HiloA extends Thread{
    
    private Semaphore p1;
    
    public HiloA(Semaphore p1){
        this.p1 = p1;
    }
    
    public void run(){
        
        System.out.println("Comienza el hilo A.");
        
        try {
            this.p1.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Adiós");
        }
    }
    
}
