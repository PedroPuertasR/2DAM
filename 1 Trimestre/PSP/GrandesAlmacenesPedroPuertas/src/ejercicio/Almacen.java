/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author alumno
 */
public class Almacen {
    
    private int numProductos;
    
    public Almacen(int numProductos){
        this.numProductos = numProductos;
    }

    public synchronized boolean cogerProductos(){
        if(numProductos > 0){
            numProductos--;
            return true;
        }else{
            return false;
        }
    }
    
}
