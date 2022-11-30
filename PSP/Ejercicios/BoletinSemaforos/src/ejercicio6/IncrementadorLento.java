/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class IncrementadorLento extends Thread{
    
    private String id;
    private ContadorCompartido c;
    private Semaphore s;

    public IncrementadorLento(String id, ContadorCompartido c) {
        this.id = id;
        this.c = c;
        this.s = new Semaphore(1, true);
    }

    @Override
    public void run() {
        try {
            s.acquire(c.getN(id));
            
            sleep(1000);
            
            c.setN(id, c.getN(id) + 1);
            
            s.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(IncrementadorLento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
