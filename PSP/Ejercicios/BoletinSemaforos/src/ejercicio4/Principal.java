/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int PRODUCTOR = 3;
        final int CONSUMIDOR = 10;
        Almacen almacen = new Almacen();
        for (int i = 0; i < PRODUCTOR; i++) {
            new Productor("Productor " + i, almacen).start();
        }
        for (int i = 0; i < CONSUMIDOR; i++) {
            new Consumidor("Consumidor " + i, almacen).start();
        }
        
    }
    
}
