/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class GrandesAlmacenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int NUM_CLI = 300;
        final int UNIDADES = 100;

        //Instanciamos un array de clientes
        Cliente[] cliente = new Cliente[NUM_CLI];
        //Instanciamos un almacen con sus unidades
        Almacen almacen = new Almacen(UNIDADES);
        //Instanciamos la puerta
        Puerta puerta = new Puerta();

        //En este string guardaremos el nombre de los clientes
        String nombreHilo;

        //Instanciamos un array de hilos donde instanciaremos nuestros clientes
        Thread[] hilos = new Thread[NUM_CLI];

        /*En el bucle for iremos instanciando el nombre del cliente, además de
        * el objeto cliente de cada uno de ellos y finalmente su hilo
        * correspondiente, el cual iniciaremos.
        */
        for (int i = 0; i < NUM_CLI; i++) {
            nombreHilo = "Cliente " + i;

            cliente[i] = new Cliente(puerta, almacen, nombreHilo);
            hilos[i] = new Thread(cliente[i]);

            hilos[i].start();
        }

        /* Cada uno de estos hilos esperará a que termine el anterior para que
        * no haya interferencias entre ellos
        */
        for (int i = 0; i < NUM_CLI; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(GrandesAlmacenes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
