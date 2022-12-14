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

    /* Al iniciar el hilo adquiere un permiso y guarda en una variable el get
    * del ContadorCompartido, lo que hara que muestre por pantalla su valor.
    * Esperará 1 segundo y seteará el contador compartido a la variable que
    * hemos guardado antes. Lo que hará que también se muestre su valor por pantalla.
    */
    @Override
    public synchronized void run() {
        try {
            s.acquire();
            int in = c.getN(id);
            wait(1000);
            c.setN(id, in);
        } catch (InterruptedException ex) {
            Logger.getLogger(IncrementadorLento.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            s.release();
        }
    }
    
    
    
}
