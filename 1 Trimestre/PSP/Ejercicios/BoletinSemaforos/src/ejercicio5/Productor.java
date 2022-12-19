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
class Productor extends Thread {

    public static final int P_DELAY = 1000;
    private final Buffer<Integer> buffer;
    private static int n = 0;

    public Productor(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    /* Al iniciar el hilo el productor sumará 1 a su contador y pondrá en
    * el buffer el número de productos que tiene. Además haremos que el hilo
    * espere un segundo.
    */
    @Override
    public void run() {
        while (true) {
            n++;
            System.out.println("P: " + n);
            buffer.put(n);
            nap(P_DELAY);
        }
    }

    //Método para hacer que el hilo espere durante el tiempo que indiquemos
    private void nap(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}
