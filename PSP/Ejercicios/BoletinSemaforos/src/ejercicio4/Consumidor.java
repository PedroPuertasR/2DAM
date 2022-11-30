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
public class Consumidor extends Thread {

    private Almacen almacen;

    public Consumidor(String name, Almacen a) {
        this.setName(name);
        this.almacen = a;
    }

    public void run() {
        while (true) {
            almacen.consumir(this.getName());
        }
    }

}
