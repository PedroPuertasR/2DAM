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

    private int permisos;

    public MiSemaforo(int permisos) {
        this.permisos = permisos;
    }

    public synchronized void acquire() throws InterruptedException {
        acquire(1);
    }

    public synchronized void acquire(int n) throws InterruptedException {
        while(n > permisos){
            wait();
        }
        permisos -= n;
    }

    public synchronized void release() {
        release(1);
    }

    public synchronized void release(int n) {
        permisos += n;
        notifyAll();
    }

}
