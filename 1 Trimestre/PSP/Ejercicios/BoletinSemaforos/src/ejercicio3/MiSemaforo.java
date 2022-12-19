/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 *
 * @author pedro
 */
public class MiSemaforo {

    //El número de permisos almacenados en el semáforo.
    private int permisos;

    public MiSemaforo(int permisos) {
        this.permisos = permisos;
    }

    //Llamamos al método acquire(int n), pero solo con un recurso.
    public synchronized void acquire() throws InterruptedException {
        acquire(1);
    }

    /* Mientras que el entero que le pasemos sea mayor que el número de permisos
    * almacenados el hilo quedará a la espera. Una vez liberado le restaremos
    * n a los permisos, puesto que adquiriremos los indicados en n.
    */
    public synchronized void acquire(int n) throws InterruptedException {
        while(n > permisos){
            wait();
        }
        permisos -= n;
    }

    //Llamamos al método release(int n) pero solo con una unidad.
    public synchronized void release() {
        release(1);
    }

    /* Liberamos los recursos sumandole n a los permisos almacenados e informamos
    * a los hilos que estén a la espera de ello liberándolos.
    */
    public synchronized void release(int n) {
        permisos += n;
        notifyAll();
    }

}
