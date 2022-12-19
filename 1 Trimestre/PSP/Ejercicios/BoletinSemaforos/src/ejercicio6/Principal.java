/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContadorCompartido c = new ContadorCompartido(1);
        
        IncrementadorLento hilo1 = new IncrementadorLento("1", c);
        IncrementadorLento hilo2 = new IncrementadorLento("2", c);
        
        hilo1.start();
        hilo2.start();
        
    }
    
}
