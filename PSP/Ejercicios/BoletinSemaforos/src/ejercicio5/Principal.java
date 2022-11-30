/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Buffer<Integer> buffer = new Buffer<Integer>(3);
        Productor p = new Productor(buffer);
        Consumidor c = new Consumidor(buffer);
        p.start();
        c.start();

    }

}
