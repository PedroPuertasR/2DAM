/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author pedro
 */
public class Almacen {

    private int numProductos;

    public Almacen(int numProductos) {
        this.numProductos = numProductos;
    }

    //Método para comprobar el número de productos
    public int getNumProductos() {
        return numProductos;
    }
    
    //Método para verificar si el numProductos es mayor que cero y poder coger uno.
    public synchronized boolean cogerProducto() {
        if (this.numProductos > 0) {
            this.numProductos--;
            notifyAll();
            return true;
        }
        return false;
    }

}
