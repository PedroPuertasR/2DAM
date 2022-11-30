/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author alumno
 */
public class Buffer<E> {

    private final E[] data;
    private int nDatos;

    public Buffer(int size) {
        data = (E[]) new Object[size];
        nDatos = 0;
    }

    public synchronized void put(E x) {
        while (nDatos >= data.length) {
            waiting();
        }
        data[nDatos++] = x;
        notifyAll();
    }

    public E take() {
        while (nDatos <= 0) {
            waiting();
        }
        E x = data[0];
        nDatos--;
        System.arraycopy(data, 1, data, 0, nDatos);
        data[nDatos] = null;
        notifyAll();
        return x;
    }

    public void waiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {
        }
    }

}
