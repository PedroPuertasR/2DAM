/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author pedro
 */
public class Almacen {

    private final int MAX_LIMITE = 20;
    private int producto = 0;
    private Semaphore productor = new Semaphore(MAX_LIMITE);
    private Semaphore consumidor = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    public void producir(String nombreProductor) {
        System.out.println(nombreProductor + " intentando almacenar un producto");
        try {

            productor.acquire();
            mutex.acquire();
            
            System.out.println(nombreProductor + " almacena un producto. "
                    + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

            Thread.sleep(500);
            
            mutex.release();
            consumidor.release();

        } catch (InterruptedException ex) {
            System.out.println("Error al producir");
        } finally {
            
        }
    }

    public void consumir(String nombreConsumidor) {
        System.out.println(nombreConsumidor + " intentando retirar un producto");
        try {
            mutex.acquire();
            consumidor.acquire();
            System.out.println(nombreConsumidor + " retira un producto. "
                    + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

            Thread.sleep(500);
            
            mutex.release();
            consumidor.release();
        } catch (InterruptedException ex) {
            System.out.println("Error al consumir");
        } finally {
            
        }
    }
}
