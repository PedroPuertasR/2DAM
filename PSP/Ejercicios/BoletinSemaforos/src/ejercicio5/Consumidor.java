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
class Consumidor extends Thread {

    public static final int C_DELAY = 1000;
    private final Buffer<Integer> buffer;
    private int esperado = 0;

    public Consumidor(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    /* Al iniciar el hilo sumará 1 al contador y esperará un segundo para 
    * coger del buffer un producto y guardarlo en una variable que 
    * mostraremos más tarde por pantalla
    */
    @Override
    public void run() {
        while (true) {
            esperado++;
            nap(C_DELAY);
            int n = buffer.take();
            System.out.println("C: " + n);
            if (n != esperado) {
                System.out.println("C: ERROR: esperado " + esperado);
            }
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
