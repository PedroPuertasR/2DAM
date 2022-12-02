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

    /* Con este método adquirimos 1 recurso del productor y otro del mutex, por
    * lo que utilizará los dos, sumará 1 al almacenamiento e imprimirá por 
    * pantalla que se almacena un producto. Esperará medio segundo y liberará
    * los recursos. 
    */
    public void producir(String nombreProductor) {
        System.out.println(nombreProductor + " intentando almacenar un producto");
        try {

            productor.acquire();
            mutex.acquire();
            
            producto++;
            
            System.out.println(nombreProductor + " almacena un producto. "
                    + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));

            Thread.sleep(500);

        } catch (InterruptedException ex) {
            System.out.println("Error al producir");
        } finally {
            mutex.release();
            consumidor.release();
        }
    }

    /* Con este método adquirimos 1 recurso del mutex y otro del consumidor para
    * decrecer el número de productos del almacén. Por lo que si hay algún producto
    * en el almacén retiraremos uno de ellos. Tras todo esto liberamos
    * los recursos obtenidos del mutex y el consumidor.
    */
    public void consumir(String nombreConsumidor) {
        System.out.println(nombreConsumidor + " intentando retirar un producto");
        try {
            mutex.acquire();
            consumidor.acquire();

            if (producto >= 1){
                producto--;
                System.out.println(nombreConsumidor + " retira un producto. "
                    + "Almacén con " + producto + (producto > 1 ? " productos." : " producto."));
            }
            
            Thread.sleep(1000);
            
        } catch (InterruptedException ex) {
            System.out.println("Error al consumir");
        } finally {
            mutex.release();
            consumidor.release();
        }
    }
}
