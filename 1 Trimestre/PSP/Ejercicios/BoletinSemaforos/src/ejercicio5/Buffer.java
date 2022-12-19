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

    private int nDatos;
    private final E[] data;
    
    public Buffer(int size) {
        data = (E[]) new Object[size];
        nDatos = 0;
    }

    /* Mientras que la variable nDatos sea mayor o igual que la logitud del 
    * array de objetos el buffer permanecerá en espera. En caso contrario
    * el objeto que le pasemos por parámetro se guardará en la siguiente
    * posición de nuestro array y avisará a los demás hilos de que puede
    * proseguir su proceso.
    */
    public synchronized void put(E x) {
        while (nDatos >= data.length) {
            waiting();
        }
        data[nDatos++] = x;
        notifyAll();
    }

    /* Mientras que la variable nDatos sea menor o igual a 0 el buffer se mantendrá
    * a la espera. En caso contrario guardará en una variable del objeto que se
    * guarda en nuestro array el primer valor y le restará uno a nuestro contador.
    * Más tarde copiará la segunda posición del array en la primera y hará que la
    * variable guardará en esa posición del array sea null.
    * Avisamos a los demás hilos para que despierten y devolvemos la variable x.
    */
    public synchronized E take() {
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

    //Método para dormir al buffer
    private void waiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {
        }
    }
}
