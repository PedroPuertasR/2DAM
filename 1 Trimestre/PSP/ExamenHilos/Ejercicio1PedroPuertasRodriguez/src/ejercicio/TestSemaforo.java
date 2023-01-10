/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

/**
 *
 * @author alumno
 */
public class TestSemaforo {

    private static final int CNT = 100000;
    private int x = 0;

    public static void main(String[] args) throws InterruptedException {
        TestSemaforo test = new TestSemaforo();
        test.inicio();
    }

    public void inicio() throws InterruptedException {
        MiSemaforo s = new MiSemaforo(1);
        Thread t1 = new Agente(s);
        Thread t2 = new Agente(s);
        Thread t3 = new Agente(s);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        if (x == 3 * CNT) {
            System.out.println("ok");
        } else {
            System.out.println("Error de condicion de carrera modificacion"
                    + "descontrolada de una variable compartida!");
        }

    }

    public class Agente extends Thread {

        private final MiSemaforo semaforo;

        public Agente(MiSemaforo semaforo) {
            this.semaforo = semaforo;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < CNT; i++) {
                    semaforo.acquire();
                    x = x + 1;
                    semaforo.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public class MiSemaforo {

        //Número de permisos
        private int n;

        public MiSemaforo(int n) {
            this.n = n;
        }

        //Método para adquirir un solo un permiso con el método acquire con parámetros
        public synchronized void acquire() throws InterruptedException {
            acquire(1);
        }

        /*Método para adquirir los permisos que le pasemos por parámetros,en caso
        * de que el número de permisos que contiene nuestra clase sea menor que
        * el que se piden se mantendrá en espera.
         */
        public synchronized void acquire(int num) throws InterruptedException {
            while (n < num) {
                wait();
            }
            n -= num;
        }

        //Método para liberar un solo permiso utilizando el método release con parámetros
        public synchronized void release() {
            release(1);
        }

        /* Método para liberar el número de permisos que le indiquemos por parámetros,
        * una vez realizado esto avisaremos a los demás hilos en espera.
         */
        public synchronized void release(int num) {
            n += num;
            notifyAll();
        }

    }

}
