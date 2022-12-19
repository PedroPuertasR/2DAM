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
public class Principal {

    protected static Semaphore p1 = new Semaphore(0, true);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HiloA Hil1 = new HiloA(p1);
        Hil1.start();
        HiloB Hil2 = new HiloB(p1);
        Hil2.start();
        HiloC Hil3 = new HiloC(p1);
        Hil3.start();
        
    }
    
}
