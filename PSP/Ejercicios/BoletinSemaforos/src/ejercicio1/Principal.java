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
public class Principal {

    protected static Semaphore p1 = new Semaphore(1, true);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HiloA h1 = new HiloA(p1);
        HiloB h2 = new HiloB(p1);
        
        h1.start();
        h2.start();
        
    }
    
}
