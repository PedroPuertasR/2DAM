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
public class Productor extends Thread {

    private Almacen almacen;

    public Productor(String name, Almacen almacen) {
        this.setName(name);
        this.almacen = almacen;
    }

    public void run() {
        while (true) {
            almacen.producir(this.getName());
        }
    }
}
